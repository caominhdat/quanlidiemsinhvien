/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cmd.controllers;

import com.cmd.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author AERO
 */
@Controller
public class IndexControllers {
    @Autowired
    private CourseService courseService;
    
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("course", this.courseService.getCourse());
        return "index";
    }
}
