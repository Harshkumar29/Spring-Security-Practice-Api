package spr.security.practise.Repositer;

import org.springframework.data.jpa.repository.JpaRepository;

import spr.security.practise.Modal.User;



public interface UserRepo extends JpaRepository<User,String>{
    public User findByUsername(String username);
    public User findByEmail(String email);
} 
