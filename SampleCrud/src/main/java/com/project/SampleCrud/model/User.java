package com.project.SampleCrud.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "USER")
public class User{

    @Id
    @Column(name = "ID",nullable = false)
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "USERNAME", unique = true)
    private String username;

    @Column(name = "PASSWORD")
    private String password;

}
