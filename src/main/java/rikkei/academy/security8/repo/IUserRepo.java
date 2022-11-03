package rikkei.academy.security8.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import rikkei.academy.security8.model.User;

import java.util.Optional;

public interface IUserRepo extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

    Optional<User> findByUsername(String username);
}
