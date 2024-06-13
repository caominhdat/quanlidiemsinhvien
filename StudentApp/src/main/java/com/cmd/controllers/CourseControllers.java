/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cmd.controllers;

import com.cmd.pojo.Course;
import com.cmd.services.CourseService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author AERO
 */
@Controller
public class CourseControllers {
    @Autowired
    private CourseService courService;
    
    @GetMapping("/courses")
    public String addCourseView(Model model){
        model.addAttribute("course", new Course());
        return "course-list";
    }
    
    @GetMapping("/course/{courseId}")
    public String updateCourseView(Model model,@PathVariable(value = "courseId") int id) {
        model.addAttribute("course", this.courService.getCourseById(id));
        
        return "course-list";
    }
    
    @PostMapping("/course")
    public String addCourseProcess(Model model, @ModelAttribute(value = "course") @Valid Course c,
            BindingResult rs ) {
        
        if (!rs.hasErrors()) {
            try {
                this.courService.addOrUpdate(c);
                
                return "redirect:/";
            } catch(Exception ex) {
                model.addAttribute("errMsg", ex.toString());
            }
        }
        
        return "course-list";
    }
}
