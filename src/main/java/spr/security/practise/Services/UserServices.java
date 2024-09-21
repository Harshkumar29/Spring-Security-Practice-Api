package spr.security.practise.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spr.security.practise.Modal.User;
import spr.security.practise.Repositer.UserRepo;

@Service
public class UserServices {
    @Autowired
    private UserRepo repo;
    
    public User getUserbyEmail(String email){
        return repo.findById(email).orElseThrow(null);
    }
    public User addUser(User user){
        repo.save(user);
        return user;
    }
    public List<User> getAllUser(){
        return repo.findAll();
    }
    public User updatePassword(User user,String email){
        User existingUser = getUserbyEmail(email);
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setUsername(user.getUsername());
        return user;
    }
    public void deleteUser(String email){
        User user = getUserbyEmail(email);
        repo.delete(user);
    }
}
