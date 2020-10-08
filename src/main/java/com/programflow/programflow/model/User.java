package com.programflow.programflow.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Data
@ToString(exclude = {"event"})
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique = true)
    private String userId;

    @OneToOne(mappedBy = "managerUser")
    private Event event;

    private String fullName;

    @Email
    private String email;

    private String password;



}