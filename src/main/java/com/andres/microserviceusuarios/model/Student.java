package com.andres.microserviceusuarios.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "students")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @PrePersist
    public void insertDateCreated(){
        this.created = new Date();
    }

}
