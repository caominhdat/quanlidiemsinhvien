/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cmd.controllers;

import com.cmd.services.CourseService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author AERO
 */
@Controller
public class IndexControllers {
    @Autowired
    private CourseService courseService;
    
    @RequestMapping("/")
    public String index(Model model,
            @RequestParam Map<String, String> params) {
        model.addAttribute("course", this.courseService.getCourse(params));
        return "index";
    }
}
