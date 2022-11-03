package rikkei.academy.security8.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rikkei.academy.security8.model.RoleName;
import rikkei.academy.security8.model.User;

public interface IUserService {
    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

    User findByUsername(String username);

    void save(User user);

    Page<User> findAll(Pageable pageable);

    void addRoleToUser(String username, RoleName roleName);
}
