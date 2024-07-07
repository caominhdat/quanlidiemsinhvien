/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cmd.repositories.impl;

import com.cmd.pojo.Student;
import com.cmd.repositories.StudentRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author AERO
 */
@Repository
@Transactional
public class StudentRepositoryImpl implements StudentRepository {
    @Autowired
    private LocalSessionFactoryBean factory;
//    @Autowired
//    private Environment env;

    @Override
    public Student getStudentById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Student s WHERE s.id = :id");
        q.setParameter("id", id);
        return (Student) q.getSingleResult();
    }

    @Override
    public List<Student> getStudent(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Student> q = b.createQuery(Student.class);
        Root r = q.from(Student.class);
        q.select(r);

        List<Predicate> predicates = new ArrayList<>();

//        String kw = params.get("kw");
//        if (kw != null && !kw.isEmpty()) {
//            predicates.add(b.like(r.get("lastName"), String.format("%%%s%%", kw)));
//        }

        String stuId = params.get("stuId");
        if (stuId != null && !stuId.isEmpty()) {
            predicates.add(b.equal(r.get("studentId"), Integer.parseInt(stuId)));
        }

        q.where(predicates.toArray(Predicate[]::new));
        q.orderBy(b.desc(r.get("id")));

        javax.persistence.Query query = s.createQuery(q);
        
        
//        String c = params.get("page");
//        if (c != null && !c.isEmpty()) {
//            int pageSize = Integer.parseInt(env.getProperty("course.pageSize").toString());
//            int start = (Integer.parseInt(c) - 1) * pageSize;
//            query.setFirstResult(start);
//            query.setMaxResults(pageSize);
//        }

        List<Student> student = query.getResultList();
        
        return student;
    }
    
}
