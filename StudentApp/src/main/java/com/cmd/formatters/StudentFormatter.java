/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cmd.formatters;

import com.cmd.pojo.Student;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author AERO
 */
public class StudentFormatter implements Formatter<Student>{

    @Override
    public String print(Student stu, Locale locale) {
        return String.valueOf(stu.getId());
    }

    @Override
    public Student parse(String stuId, Locale locale) throws ParseException {
        Student s = new Student();
        s.setId(Integer.parseInt(stuId));
        
        return s;
    }
    
}
