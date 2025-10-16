package MyApp.dtos;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public record RegisterDto(
        String firstName,
        String lastName,
        String login,
        char[] password
) {
    @JsonCreator
    public RegisterDto(
            @JsonProperty("firstName") String firstName,
            @JsonProperty("lastName") String lastName,
            @JsonProperty("login") String login,
            @JsonProperty("password") char[] password
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
    }
}