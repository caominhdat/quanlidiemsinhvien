/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cmd.repositories.impl;

import com.cmd.pojo.User;
import com.cmd.repositories.UserRepository;
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
public class UserRepositoryImpl implements UserRepository{
    
    @Autowired
    private LocalSessionFactoryBean factoryBean;

    @Override
    public User getUserByUsername(String username) {
        Session s = this.factoryBean.getObject().getCurrentSession();
        Query q = s.createNamedQuery("User.findByUsername");
        q.setParameter("username", username);
        
        return (User) q.getSingleResult();
    }

    @Override
    public void addUser(User user) {
        Session s = this.factoryBean.getObject().getCurrentSession();
        s.save(user);
    }
    
}
