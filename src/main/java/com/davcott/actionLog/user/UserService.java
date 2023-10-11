package com.davcott.actionLog.user;

public interface UserService {

    void addUser(String name, String email);

    Iterable<User> allUsers();

    User getUser(int id);

    void deleteUser(int id);

}
