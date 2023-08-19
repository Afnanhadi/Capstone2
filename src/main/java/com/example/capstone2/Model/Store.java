package com.example.capstone2.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Store {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @Column(columnDefinition = "varchar(20) not null")
    @NotEmpty
    private String nameStore;
    @NotEmpty
    @Column(columnDefinition = "varchar(20) not null")
    private String address;
    @Column(columnDefinition = "varchar(20) not null check(state='Available' or state='Locked')")
    @NotEmpty
    private String state;

}
