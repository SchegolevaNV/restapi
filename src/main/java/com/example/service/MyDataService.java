package com.example.service;

import com.example.model.PeopleAndPet;
import com.example.repository.PeopleAndPetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyDataService {

    private final PeopleAndPetRepository peopleAndPetRepository;

    public Page<PeopleAndPet> getMyData(final int offset, final int limit) {
        int page = offset/limit;
        Pageable pageable = PageRequest.of(page, limit);
        return peopleAndPetRepository.findAll(pageable);
    }
}
