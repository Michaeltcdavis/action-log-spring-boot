package com.davcott.actionLog.user;

import com.davcott.actionLog.error.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private UserRepository users;

    @PostMapping(path = "/")
    public ResponseEntity<String> addUser(
            @RequestParam String name,
            @RequestParam String email
        ) {
        User n = new User();
        n.setUserName(name);
        n.setEmail(email);
        n.setCreatedDate(new Date());
        users.save(n);
        return ResponseEntity.ok("User saved successfully.");
    }

    @GetMapping(path = "/")
    public ResponseEntity<Iterable<User>>  getAllUsers() {
        return ResponseEntity.ok(users.findAll());
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") int id) {
        User d = users.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user not found with id: " + id));
        users.deleteById(id);
        return ResponseEntity.ok("User deleted successfully.");
    }


}
