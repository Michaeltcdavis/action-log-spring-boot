package com.davcott.actionLog.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private UserRepository users;

    @PostMapping(path = "/")
    public @ResponseBody String addUser(
            @RequestParam String name,
            @RequestParam String email
        ) {
        User n = new User();
        n.setUserName(name);
        n.setEmail(email);
        n.setCreatedDate(new Date());
        users.save(n);
        return "Saved";
    }

    @GetMapping(path = "/")
    public @ResponseBody Iterable<User> getAllUsers() {
        return users.findAll();
    }


}
