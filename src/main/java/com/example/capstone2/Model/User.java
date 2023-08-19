package com.example.capstone2.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @Column(columnDefinition = "varchar(20) not null")
    @NotEmpty
    private String name;
    @NotEmpty
    @Email
    @Column(columnDefinition = "varchar(20) not null")
    private String email;
    @NotEmpty
    @Column(columnDefinition = "varchar(20) not null")
   // @Pattern(regexp = "^[A-Za-z\\s]{1,}[0-9\\s]{1,}", message = "Please enter a valid password")
    private String password;
    private Double points;
     @NotNull
    private Integer salary;

}