/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cmd.services.impl;

import com.cmd.pojo.Grade;
import com.cmd.repositories.GradeRepository;
import com.cmd.services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AERO
 */
@Service
public class GradeServiceImpl implements GradeService {
    @Autowired
    private GradeRepository gradeRepo;

    @Override
    public void inputGrade(Grade g) {
        this.gradeRepo.inputGrade(g);
    }
}
