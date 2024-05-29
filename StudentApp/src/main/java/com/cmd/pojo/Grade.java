/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cmd.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AERO
 */
@Entity
@Table(name = "grade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grade.findAll", query = "SELECT g FROM Grade g"),
    @NamedQuery(name = "Grade.findById", query = "SELECT g FROM Grade g WHERE g.id = :id"),
    @NamedQuery(name = "Grade.findByMidterm", query = "SELECT g FROM Grade g WHERE g.midterm = :midterm"),
    @NamedQuery(name = "Grade.findByFinal1", query = "SELECT g FROM Grade g WHERE g.final1 = :final1"),
    @NamedQuery(name = "Grade.findByAdditional1", query = "SELECT g FROM Grade g WHERE g.additional1 = :additional1"),
    @NamedQuery(name = "Grade.findByAdditional2", query = "SELECT g FROM Grade g WHERE g.additional2 = :additional2"),
    @NamedQuery(name = "Grade.findByAdditional3", query = "SELECT g FROM Grade g WHERE g.additional3 = :additional3"),
    @NamedQuery(name = "Grade.findByStatus", query = "SELECT g FROM Grade g WHERE g.status = :status"),
    @NamedQuery(name = "Grade.findByCreatedAt", query = "SELECT g FROM Grade g WHERE g.createdAt = :createdAt"),
    @NamedQuery(name = "Grade.findByUpdatedAt", query = "SELECT g FROM Grade g WHERE g.updatedAt = :updatedAt")})
public class Grade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "midterm")
    private Float midterm;
    @Column(name = "final")
    private Float final1;
    @Column(name = "additional_1")
    private Float additional1;
    @Column(name = "additional_2")
    private Float additional2;
    @Column(name = "additional_3")
    private Float additional3;
    @Size(max = 6)
    @Column(name = "status")
    private String status;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @JoinColumn(name = "student_course_id", referencedColumnName = "id")
    @ManyToOne
    private StudentCourse studentCourseId;

    public Grade() {
    }

    public Grade(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getMidterm() {
        return midterm;
    }

    public void setMidterm(Float midterm) {
        this.midterm = midterm;
    }

    public Float getFinal1() {
        return final1;
    }

    public void setFinal1(Float final1) {
        this.final1 = final1;
    }

    public Float getAdditional1() {
        return additional1;
    }

    public void setAdditional1(Float additional1) {
        this.additional1 = additional1;
    }

    public Float getAdditional2() {
        return additional2;
    }

    public void setAdditional2(Float additional2) {
        this.additional2 = additional2;
    }

    public Float getAdditional3() {
        return additional3;
    }

    public void setAdditional3(Float additional3) {
        this.additional3 = additional3;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public StudentCourse getStudentCourseId() {
        return studentCourseId;
    }

    public void setStudentCourseId(StudentCourse studentCourseId) {
        this.studentCourseId = studentCourseId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grade)) {
            return false;
        }
        Grade other = (Grade) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cmd.pojo.Grade[ id=" + id + " ]";
    }
    
}
