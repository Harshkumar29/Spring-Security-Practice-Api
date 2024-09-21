package spr.security.practise.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
    @GetMapping("/signin")
    public String signIn() {
        return "login";
    }
    
}
