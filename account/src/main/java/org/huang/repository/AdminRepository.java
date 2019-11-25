package org.huang.repository;


import org.huang.entity.Admin;

public interface AdminRepository {
    public Admin login(String username, String password);
}
