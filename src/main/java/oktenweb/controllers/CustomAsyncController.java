package oktenweb.controllers;



import oktenweb.dao.ContactDAO;
import oktenweb.models.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CustomAsyncController {

    @Autowired
    private ContactDAO contactDAO;
    //rest controllers work with methods Get and Post which do not redirect to pages

    @PostMapping("/saveContact")
    public List<Contact> saveAsync(@RequestBody Contact contact){
        contactDAO.save(contact);
        System.out.println(contact);
        System.out.println("react");

        List<Contact> results = contactDAO.findAll();
        return results;
    }

    @GetMapping("/showContact")
    public List<Contact> showContact(){
        List<Contact> results = contactDAO.findAll();
        return results;
    }

}
