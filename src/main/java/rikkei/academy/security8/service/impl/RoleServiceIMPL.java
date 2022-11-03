package rikkei.academy.security8.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rikkei.academy.security8.model.Role;
import rikkei.academy.security8.model.RoleName;
import rikkei.academy.security8.repo.IRoleRepo;
import rikkei.academy.security8.service.IRoleService;

@RequiredArgsConstructor
@Service
@Transactional
public class RoleServiceIMPL implements IRoleService {

    private final IRoleRepo roleRepo;

    @Override
    public Role findByName(RoleName name) {
        return roleRepo.findByName(name);
    }

    @Override
    public void save(Role role) {
        roleRepo.save(role);
    }
}
