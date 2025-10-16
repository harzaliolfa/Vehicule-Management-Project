package MyApp.services;

import MyApp.dtos.CredentialsDto;
import MyApp.dtos.RegisterDto;
import MyApp.dtos.UserDto;
import MyApp.entities.User;
import MyApp.exceptions.AppException;
import MyApp.mappers.UserMapper;
import MyApp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.Optional;


@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public UserDto login(CredentialsDto credentialsDto) {
        User user = userRepository.findByLogin(credentialsDto.login()).orElseThrow(() ->
                new AppException("Unknown User",HttpStatus.NOT_FOUND));

        if(passwordEncoder.matches(CharBuffer.wrap(credentialsDto.password()), user.getPassword())){

            // Erase password from memory so it could not linger in memory and potentially be read by an attacker or memory dump
            Arrays.fill(credentialsDto.password(), '\0');
            return userMapper.toUserDto(user);
        }
        throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);

    }

    public UserDto register(RegisterDto registerDto) {
        Optional<User> optionalUser = userRepository.findByLogin(registerDto.login());

        if (optionalUser.isPresent()) {
            throw new AppException("User already exists", HttpStatus.BAD_REQUEST);
        }

        User user = userMapper.registerToUser(registerDto);
        user.setPassword(passwordEncoder.encode(CharBuffer.wrap(registerDto.password())));

        User savedUser = userRepository.save(user);

        return userMapper.toUserDto(savedUser);
    }
}
