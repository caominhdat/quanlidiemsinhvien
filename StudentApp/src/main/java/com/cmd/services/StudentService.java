/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cmd.services;

import com.cmd.pojo.Student;
import java.util.List;
import java.util.Map;

/**
 *
 * @author AERO
 */
public interface StudentService {
    Student getStudentById (int id);
    List<Student> getStudent(Map<String, String> params);
}
