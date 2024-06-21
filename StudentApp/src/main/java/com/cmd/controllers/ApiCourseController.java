/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cmd.controllers;

import com.cmd.pojo.Course;
import com.cmd.services.CourseService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author AERO
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ApiCourseController {
    @Autowired
    private CourseService courService;
    
    @DeleteMapping("/course/{courseId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(Model model,@PathVariable(value = "courseId") int id) {
        this.courService.deleteCourse(id);
    }
    
    @GetMapping("/course/")
    @CrossOrigin
    public ResponseEntity<List<Course>> list(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.courService.getCourse(params), HttpStatus.OK);
    }
    
    @GetMapping(path = "/course/{courseId}/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Course> retrieve(@PathVariable(value = "courseId") int id) {
        return new ResponseEntity<>(this.courService.getCourseById(id), HttpStatus.OK);
    }
    
}
