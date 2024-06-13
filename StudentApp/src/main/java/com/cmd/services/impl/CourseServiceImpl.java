/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cmd.services.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.cmd.pojo.Course;
import com.cmd.repositories.CourseRepository;
import com.cmd.services.CourseService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AERO
 */
@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    private CourseRepository courseRepo;
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<Course> getCourse(Map<String, String> params) {
        return this.courseRepo.getCourse(params);
    }

    @Override
    public void addOrUpdate(Course c) {
        if (!c.getFile().isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(c.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                c.setImage(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(CourseServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.courseRepo.addOrUpdate(c);
    }

    @Override
    public Course getCourseById(int id) {
        return this.courseRepo.getCourseById(id);
    }

    @Override
    public void deleteCourse(int id) {
        this.courseRepo.deleteCourse(id);
    }
    
}
