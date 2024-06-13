/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cmd.services;

import com.cmd.pojo.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author AERO
 */
public interface UserService extends UserDetailsService{
    User getUserByUsername(String username);
    void addUser(User user);
}
