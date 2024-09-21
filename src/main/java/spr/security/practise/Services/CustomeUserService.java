package spr.security.practise.Services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import spr.security.practise.Modal.User;
import spr.security.practise.Repositer.UserRepo;
@Service
public class CustomeUserService implements UserDetailsService{

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User user = repo.findByUsername(username);
            if (user == null) {
                throw new UsernameNotFoundException("User not found");
            }
    
            return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                new ArrayList<>()
            );
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving user", e);
        }
    }
    
}
