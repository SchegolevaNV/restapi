package com.example.controller;

import com.example.assembler.MyDataAssembler;
import com.example.model.PeopleAndPet;
import com.example.model.MyDataPageResource;
import com.example.model.MyDataResource;
import com.example.service.MyDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MyController {

    private final MyDataService myDataService;
    private final MyDataAssembler myDataAssembler;

    @GetMapping("/all")
    @Transactional
    public MyDataPageResource getAllJson(@RequestParam(defaultValue = "0", required = false) int offset,
                                      @RequestParam(defaultValue = "25", required = false) int limit) {

        Page<PeopleAndPet> myDataPage = myDataService.getMyData(offset, limit);

        return myDataAssembler.toPageResource(myDataPage);
    }

    @GetMapping("")
    @Transactional
    public MyDataPageResource getJson(@RequestParam(defaultValue = "0", required = false) int offset,
                                      @RequestParam(defaultValue = "1", required = false) int limit) {

        Page<PeopleAndPet> myDataPage = myDataService.getMyData(offset, limit);

        return myDataAssembler.toPageResource(myDataPage);
    }

    @PostMapping(
            value = "",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public MyDataResource postJson(@RequestBody final MyDataResource myDataResource) {

        return myDataResource;
    }
}
