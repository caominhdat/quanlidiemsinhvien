/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cmd.repositories.impl;

import com.cmd.pojo.Grade;
import com.cmd.repositories.GradeRepository;
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
public class GradeRepositoryImpl implements GradeRepository{
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public void inputGrade(Grade g) {
        Session s = this.factory.getObject().getCurrentSession();
        s.save(g);
    }
}
