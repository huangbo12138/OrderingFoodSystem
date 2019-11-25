package org.huang.repository;


import org.huang.entity.User;

public interface UserRepository {
    public User login(String username, String password);
}
