package rikkei.academy.security8.service;

import rikkei.academy.security8.model.Role;
import rikkei.academy.security8.model.RoleName;

public interface IRoleService {
    Role findByName(RoleName name);

    void save(Role role);
}
