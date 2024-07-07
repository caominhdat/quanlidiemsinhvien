/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cmd.controllers;

import com.cmd.pojo.Grade;
import com.cmd.services.GradeService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
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
public class ApiGradeController {
    @Autowired
    private GradeService gradeService;
    
    
    @PostMapping(path = "/grade/", consumes = {
        MediaType.APPLICATION_FORM_URLENCODED_VALUE,
    })
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin
    public void create(@RequestParam Map<String, String> params) {
        Grade g = new Grade();
        String additional1 = params.get("additional1");
        g.setAdditional1(Float.parseFloat(additional1));
        String additional2 = params.get("additional2");
        g.setAdditional2(Float.parseFloat(additional2));
        String additional3 = params.get("additional3");
        g.setAdditional3(Float.parseFloat(additional3));
        String midterm = params.get("midterm");
        g.setMidterm(Float.parseFloat(midterm));
        String final1 = params.get("final1");
        g.setFinal1(Float.parseFloat(final1));
        
        this.gradeService.inputGrade(g);
    }
}
