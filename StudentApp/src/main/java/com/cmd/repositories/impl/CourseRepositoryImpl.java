/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cmd.repositories.impl;

import com.cmd.pojo.Course;
import com.cmd.repositories.CourseRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author AERO
 */
@Repository
@Transactional
public class CourseRepositoryImpl implements CourseRepository{
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Course> getCourse() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createNamedQuery("Course.findAll");
        
        return q.getResultList();
    }
    
}
