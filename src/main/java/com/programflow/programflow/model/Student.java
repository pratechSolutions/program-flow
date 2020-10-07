package com.programflow.programflow.model;


import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@ToString(exclude = {"event"})
@Entity
public class Student {

    @Id
    @GeneratedValue
    private Integer studentId;

    private String university;

    private String mail;

    private String password;

    private String postcode;



}