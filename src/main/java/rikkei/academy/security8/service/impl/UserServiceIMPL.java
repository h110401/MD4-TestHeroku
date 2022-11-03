package rikkei.academy.security8.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rikkei.academy.security8.model.Role;
import rikkei.academy.security8.model.RoleName;
import rikkei.academy.security8.model.User;
import rikkei.academy.security8.repo.IRoleRepo;
import rikkei.academy.security8.repo.IUserRepo;
import rikkei.academy.security8.service.IUserService;

@RequiredArgsConstructor
@Service
@Transactional
public class UserServiceIMPL implements IUserService {

    private final IRoleRepo roleRepo;
    private final IUserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public boolean existsByEmail(String email) {
        return userRepo.existsByEmail(email);
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepo.existsByUsername(username);
    }

    @Override
    public User findByUsername(String username) {
        return userRepo.findByUsername(username).orElse(null);
    }

    @Override
    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepo.findAll(pageable);
    }

    @Override
    public void addRoleToUser(String username, RoleName roleName) {
        User user = userRepo.findByUsername(username).orElse(new User());
        Role role = roleRepo.findByName(roleName);
        user.getRoles().add(role);
    }
}
