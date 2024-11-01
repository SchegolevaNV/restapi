package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "people_and_pets")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PeopleAndPet {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "my_name")
    private String myName;

    @Column(name = "pet_name")
    private String petName;

    @Column(name = "age")
    private int age;
}
