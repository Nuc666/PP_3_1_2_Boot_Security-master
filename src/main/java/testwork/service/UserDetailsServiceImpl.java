package testwork.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import testwork.dao.UserRepositiry;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepositiry userRepositiry;

    public UserDetailsServiceImpl(UserRepositiry userRepositiry) {
        this.userRepositiry = userRepositiry;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepositiry.findByFirstName(username);
    }
}
