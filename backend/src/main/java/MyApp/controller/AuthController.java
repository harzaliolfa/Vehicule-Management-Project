package MyApp.controller;


import MyApp.config.UserAuthProvider;
import MyApp.dtos.CredentialsDto;
import MyApp.dtos.RegisterDto;
import MyApp.dtos.UserDto;
import MyApp.services.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@Slf4j
@RestController
@AllArgsConstructor
public class AuthController {
    private  final UserService userService;
    private final UserAuthProvider userAuthProvider;

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody CredentialsDto credentialsDto){
        UserDto user = userService.login(credentialsDto);
        user.setToken(userAuthProvider.createToken(user));
        log.info("user logged in " + user );
        return ResponseEntity.ok(user);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody RegisterDto registerDto){
        UserDto user = userService.register(registerDto);
        user.setToken(userAuthProvider.createToken(user));
        log.info("user created " + user );
        return  ResponseEntity.created(URI.create("/users/" + user.getId())).body(user);
    }

}
