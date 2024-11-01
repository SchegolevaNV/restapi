package com.example.repository;

import com.example.model.PeopleAndPet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleAndPetRepository extends JpaRepository<PeopleAndPet, Integer> {
}
