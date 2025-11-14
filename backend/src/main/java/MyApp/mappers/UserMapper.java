package MyApp.mappers;


import MyApp.dtos.RegisterDto;
import MyApp.dtos.UserDto;
import org.mapstruct.Mapper;
import MyApp.entities.User;
import org.mapstruct.Mapping;


@Mapper(componentModel =  "spring")
public interface UserMapper {

    UserDto toUserDto(User user);

    // We ignored the password because it has different format
    // It has a char [] in the registerDTO and a string in the user object
    @Mapping(target = "password", ignore = true)
    User registerToUser(RegisterDto userDto);
}
