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
    private UserService userService;

    @PostMapping(path = "/")
    public ResponseEntity<String> addUser(
            @RequestParam String name,
            @RequestParam String email
        ) {
        userService.addUser(name, email);
        return ResponseEntity.ok("User saved successfully.");
    }

    @GetMapping(path = "/")
    public ResponseEntity<Iterable<User>>  getAllUsers() {

        return ResponseEntity.ok(userService.allUsers());
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") int id) {
        User u = userService.getUser(id);
        return ResponseEntity.ok(u);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully.");
    }


}
