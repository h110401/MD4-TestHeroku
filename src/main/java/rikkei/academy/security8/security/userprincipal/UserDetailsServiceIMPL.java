package rikkei.academy.security8.security.userprincipal;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import rikkei.academy.security8.model.User;
import rikkei.academy.security8.repo.IUserRepo;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceIMPL implements UserDetailsService {
    private final IUserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException(String.format("User %s not found", username))
        );
        return UserPrincipal.build(user);
    }
}