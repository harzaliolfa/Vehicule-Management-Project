package MyApp.config;


import MyApp.dtos.UserDto;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;

// This class create and validate the JWT
@RequiredArgsConstructor
@Component
public class UserAuthProvider {

    // For encoding and decoding the JWT the back need a secret key
    @Value("${security.jwt.token.secret-key:secret-key}")
    private String secretKey;

    // This is to avoid having the raw secret key availble in the jvm
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

//    public Authentication validateToken(String token){
//
//    }


}
