package oktenweb.controllers;
import oktenweb.models.User;
import oktenweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/")
    public String loginPage1() {
        return "userPage";
    }

    @GetMapping("/getToUserPage")
    public String getToUserPage() {
        return "userPage";
    }

    @GetMapping("/getToLoginPage")
    public String getToLoginPage() {
        return "login";
    }

    @GetMapping("/contactPage")
    public String contactPage(){
        return "contactPage";
    }

    @PostMapping("/successURL")
    public String successURL(){
        return "redirect:/contactPage";
    }


    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/saveUser")
    public String saveUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword())); // to encode the pass
        userService.save(user);
        return "redirect:/login";
    }
}



