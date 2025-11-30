package MyApp.controller;

import MyApp.dtos.UserDto;
import MyApp.entities.User;
import MyApp.mappers.UserMapper;
import MyApp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class UserController {

    private UserRepository userRepository;
    private UserMapper userMapper;

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = users.stream().map(
                user -> userMapper.toUserDto(user)
        ).collect(Collectors.toList());
        return  ResponseEntity.ok(userDtos);
    }
}
