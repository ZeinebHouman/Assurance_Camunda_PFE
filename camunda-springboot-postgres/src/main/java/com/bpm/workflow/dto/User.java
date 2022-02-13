package com.bpm.workflow.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Builder
@ToString
@Entity
@Table(name = "user", schema = "public")
public class User implements Serializable {

    @Id
    @Column(nullable=false , updatable =false)
    private double id;
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private String jobTitle;
    private String phone;
    public User(){}
    public User(double id, String email, String password, String firstname, String lastname, String jobTitle, String phone) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.jobTitle = jobTitle;
        this.phone = phone;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
