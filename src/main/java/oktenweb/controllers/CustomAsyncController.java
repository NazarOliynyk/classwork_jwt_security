package oktenweb.controllers;



import oktenweb.dao.ContactDAO;
import oktenweb.dao.UserDAO;
import oktenweb.models.Contact;
import oktenweb.models.User;
import oktenweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CustomAsyncController {

    @Autowired
    private ContactDAO contactDAO;

    @Autowired
    private UserDAO userDAO;

    //rest controllers work with methods Get and Post which do not redirect to pages

    @PostMapping("/saveContact")
    public String saveContact(@RequestBody Contact contact){
        contactDAO.save(contact);

        return "Contact saved";
    }

//    @Autowired
//    private UserService userService;
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @PostMapping("/saveUser")
//    public String saveUser(@RequestBody User user){
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        userService.save(user);
//
//        return "User saved";
//    }


    @GetMapping("/showContact")
    public List<Contact> showContact(){
        List<Contact> results = contactDAO.findAll();
        return results;
    }

}
