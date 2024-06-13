/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cmd.formatters;

import com.cmd.pojo.Course;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author AERO
 */
public class CourseFormatter implements Formatter<Course>{

    @Override
    public String print(Course cour, Locale locale) {
       return String.valueOf(cour.getId());
    }

    @Override
    public Course parse(String courId, Locale locale) throws ParseException {
        Course c = new Course();
        c.setId(Integer.parseInt(courId));
        
        return c;
    }
    
}
