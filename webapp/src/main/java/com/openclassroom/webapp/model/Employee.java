package com.openclassroom.webapp.model;

import lombok.*;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private Long id;

    private String lastName;

    private String firstName;

    private String password;

    private String mail;
}
