package spr.security.practise.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spr.security.practise.Modal.User;
import spr.security.practise.Services.UserServices;




@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServices userServices;

    @GetMapping
    public List<User> getallUser() {
        return userServices.getAllUser();
    }
    
    @GetMapping("/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userServices.getUserbyEmail(email);
    }
    
    @PostMapping()
    public User newUser(@RequestBody User user) {
        return userServices.addUser(user);
    }
    
    @DeleteMapping("/{email}")
    public void deleteUser(@PathVariable String email) {
        userServices.deleteUser(email);
    }

    @PutMapping("/{email}")
    public User updatePassword(@RequestBody User user,@PathVariable String email) {
        return userServices.updatePassword(user,email);
    }
}
