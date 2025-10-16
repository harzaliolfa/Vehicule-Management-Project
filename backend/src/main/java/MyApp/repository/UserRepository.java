package MyApp.repository;

import MyApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByLogin(String login);
}
