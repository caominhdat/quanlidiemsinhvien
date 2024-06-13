/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cmd.repositories.impl;

import com.cmd.pojo.Course;
import com.cmd.repositories.CourseRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author AERO
 */
@Repository
@Transactional
@PropertySource("classpath:configs.properties")
public class CourseRepositoryImpl implements CourseRepository {

    @Autowired
    private LocalSessionFactoryBean factoryBean;
    @Autowired
    private Environment env;

    @Override
    public List<Course> getCourse(Map<String, String> params) {
        Session s = this.factoryBean.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Course> q = b.createQuery(Course.class);
        Root r = q.from(Course.class);
        q.select(r);

        List<Predicate> predicates = new ArrayList<>();

        String kw = params.get("kw");
        if (kw != null && !kw.isEmpty()) {
            predicates.add(b.like(r.get("courseName"), String.format("%%%s%%", kw)));
        }

        String courId = params.get("courId");
        if (courId != null && !courId.isEmpty()) {
            predicates.add(b.equal(r.get("courseId"), Integer.parseInt(courId)));
        }

        q.where(predicates.toArray(Predicate[]::new));
        q.orderBy(b.desc(r.get("id")));

        Query query = s.createQuery(q);
        
        
        String c = params.get("page");
        if (c != null && !c.isEmpty()) {
            int pageSize = Integer.parseInt(env.getProperty("course.pageSize").toString());
            int start = (Integer.parseInt(c) - 1) * pageSize;
            query.setFirstResult(start);
            query.setMaxResults(pageSize);
        }

        List<Course> course = query.getResultList();
        
        return course;
    }

    @Override
    public void addOrUpdate(Course c) {
        Session s = this.factoryBean.getObject().getCurrentSession();
        if (c.getId() != null)
            s.update(c);
        else
            s.save(c);
    }

    @Override
    public Course getCourseById(int id) {
        Session s = this.factoryBean.getObject().getCurrentSession();
        return s.get(Course.class, id);
    }

    @Override
    public void deleteCourse(int id) {
        Session s = this.factoryBean.getObject().getCurrentSession();
        Course c = this.getCourseById(id);
        s.delete(c);
    }

}
