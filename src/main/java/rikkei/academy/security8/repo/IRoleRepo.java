package rikkei.academy.security8.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import rikkei.academy.security8.model.Role;
import rikkei.academy.security8.model.RoleName;

public interface IRoleRepo extends JpaRepository<Role, Long> {
    Role findByName(RoleName name);
}
