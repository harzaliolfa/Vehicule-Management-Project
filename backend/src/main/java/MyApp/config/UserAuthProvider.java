package MyApp.config;


import MyApp.dtos.UserDto;
import MyApp.entities.User;
import MyApp.exceptions.AppException;
import MyApp.mappers.UserMapper;
import MyApp.repository.UserRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Collections;
import java.util.Date;

// This class create and validate the JWT
@RequiredArgsConstructor
@Component
public class UserAuthProvider {

    // For encoding and decoding the JWT the back need a secret key
    @Value("${security.jwt.token.secret-key:secret-key}")
    private String secretKey;

    private UserRepository userRepository;
    private UserMapper userMapper;

    // This is to avoid having the raw secret key available in the jvm
    @PostConstruct
    protected void init(){
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes(StandardCharsets.UTF_8));
    }

    public String createToken(UserDto userDto){
            Date now = new Date();
            Date validity = new Date(now.getTime() + 3_600_000);
            return JWT.create()
                    .withIssuer(userDto.getLogin())
                    .withIssuedAt(now)
                    .withExpiresAt(validity)
                    .withClaim("firstName", userDto.getFirstName())
                    .withClaim("lastName", userDto.getLastName())
                    .sign(Algorithm.HMAC256(secretKey));
    }

    public Authentication validateToken(String token){
        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        JWTVerifier jwtVerifier = JWT.require(algorithm).build();

        DecodedJWT decoded = jwtVerifier.verify(token);
        UserDto user = UserDto.builder()
                .login(decoded.getIssuer())
                // Retrieve the "firstName" claim as a String
                .firstName(decoded.getClaim("firstName").asString())
                // Retrieve the "lastName" claim as a String
                .lastName(decoded.getClaim("lastName").asString())
                .build();

        // Create a Spring Security Authentication object for the user
        // The second parameter (credentials) is null since we don’t have the password here
        // The third parameter is an empty list — meaning no authorities/roles are assigned
        return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
    }


    public Authentication validateTokenStrongly(String token) {
        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        JWTVerifier jwtVerifier = JWT.require(algorithm).build();

        DecodedJWT decoded = jwtVerifier.verify(token);

        User user = userRepository.findByLogin(decoded.getIssuer())
                .orElseThrow(() -> new AppException("Unknown User", HttpStatus.NOT_FOUND));

        return  new UsernamePasswordAuthenticationToken(userMapper.toUserDto(user), null, Collections.emptyList());
    }
}
