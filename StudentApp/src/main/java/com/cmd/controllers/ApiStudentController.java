/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cmd.controllers;


import com.cmd.pojo.Student;
import com.cmd.services.StudentService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author AERO
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ApiStudentController {
    @Autowired
    private StudentService stuService;
    
    @GetMapping("/student/")
    @CrossOrigin
    public ResponseEntity<List<Student>> list(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.stuService.getStudent(params), HttpStatus.OK);
    }
        
    @GetMapping(path = "/student/{studentId}/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> retrieve(@PathVariable(value = "studentId") int id) {
        return new ResponseEntity<>(this.stuService.getStudentById(id), HttpStatus.OK);
    }
}
