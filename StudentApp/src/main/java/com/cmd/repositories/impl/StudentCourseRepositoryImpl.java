/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cmd.repositories.impl;

import com.cmd.pojo.StudentCourse;
import com.cmd.repositories.StudentCourseRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;
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
public class StudentCourseRepositoryImpl implements StudentCourseRepository{
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public StudentCourse getStudentCourseById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM StudentCourse s WHERE s.id = :id");
        q.setParameter("id", id);
        return (StudentCourse) q.getSingleResult();
    }  
}
