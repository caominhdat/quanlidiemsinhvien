/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cmd.services.impl;

import com.cmd.pojo.Student;
import com.cmd.repositories.StudentRepository;
import com.cmd.services.StudentService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AERO
 */
@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepo;

    @Override
    public Student getStudentById(int id) {
        return this.studentRepo.getStudentById(id);
    }

    @Override
    public List<Student> getStudent(Map<String, String> params) {
        return this.studentRepo.getStudent(params);
    }

}
