package MyApp.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/** We used char[] for password because they're more secure than strings ,
 *  in fact string are immuatable that's mean if we allocate a place for them the value stays
 *  there waiting for gatbage collector to clean it , but char[] are mutable that's mean after
 *  checking we can assign them to empty char to avoid reading them by attackers **/
public record CredentialsDto(String login, char[] password) {
    @JsonCreator
    public CredentialsDto(@JsonProperty("login") String login,
                          @JsonProperty("password") String password) {
        this(login, password.toCharArray());
    }

}
