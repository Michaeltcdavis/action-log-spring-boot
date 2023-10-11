package com.davcott.actionLog.user;

import com.davcott.actionLog.error.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository users;

    @Override
    public void addUser(String name, String email) {
        User n = new User();
        n.setUserName(name);
        n.setEmail(email);
        n.setCreatedDate(new Date());
        users.save(n);
    }

    @Override
    public Iterable<User> allUsers() {
        return users.findAll();
    }

    @Override
    public User getUser(int id) {
        return users.findById(id).orElseThrow(() -> noUserException(id));
    }

    @Override
    public void deleteUser(int id) {
        User d = users.findById(id)
                .orElseThrow(() -> noUserException(id));
        users.deleteById(id);
    }

    private ResourceNotFoundException noUserException(int id) {
        return new ResourceNotFoundException("User not found with id: " + id);
    }
}
