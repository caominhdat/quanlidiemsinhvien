/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cmd.services.impl;

import com.cmd.pojo.StudentCourse;
import com.cmd.repositories.StudentCourseRepository;
import com.cmd.services.StudentCourseService;
import org.springframework.stereotype.Service;

/**
 *
 * @author AERO
 */
@Service
public class StudentCourseServiceImpl implements StudentCourseService{
    private StudentCourseRepository studentCourseRepo;

    @Override
    public StudentCourse getStudentCourseById(int id) {
        return this.studentCourseRepo.getStudentCourseById(id);
    }
    
}
