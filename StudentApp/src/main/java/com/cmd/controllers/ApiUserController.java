/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cmd.controllers;

import com.cmd.pojo.User;
import com.cmd.services.UserService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author AERO
 */
@RestController
@RequestMapping("/api")
public class ApiUserController {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;

    @PostMapping(path = "/user/", consumes = {
        MediaType.APPLICATION_JSON_VALUE,
        MediaType.MULTIPART_FORM_DATA_VALUE
    })
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin
    public void create(@RequestParam Map<String, String> params, @RequestPart MultipartFile[] file) {
        User u = new User();
        u.setUsername(params.get("username"));
        String password = params.get("password");
        u.setPassword(this.passwordEncoder.encode(password));
        u.setEmail(params.get("email"));
        u.setRole(params.get("role"));
        if (file.length > 0) {
            u.setFile(file[0]);
        }

        this.userService.addUser(u);
    }
}
