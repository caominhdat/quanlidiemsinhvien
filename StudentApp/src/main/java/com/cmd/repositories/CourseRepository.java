/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cmd.repositories;

import com.cmd.pojo.Course;
import java.util.List;
import java.util.Map;

/**
 *
 * @author AERO
 */
public interface CourseRepository {
    List<Course> getCourse(Map<String, String> params);
    void addOrUpdate(Course c);
}
