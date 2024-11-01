package com.example.assembler;

import com.example.model.PeopleAndPet;
import com.example.model.MyDataPageResource;
import com.example.model.MyDataResource;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class MyDataAssembler {

    public MyDataPageResource toPageResource(final Page<PeopleAndPet> myDataPage) {

        MyDataPageResource myDataPageResource = new MyDataPageResource();
        myDataPageResource.setPageSize(myDataPage.getSize());
        myDataPageResource.setPageNumber(myDataPage.getNumber());
        myDataPageResource.setTotal(myDataPage.getTotalElements());

        myDataPage.getContent()
                .stream()
                .map(this::toMyDataPageResource)
                .forEach(myDataPageResource::add);

        return myDataPageResource;
    }

    private MyDataResource toMyDataPageResource(final PeopleAndPet peopleAndPet) {
        return MyDataResource.builder()
                .age(peopleAndPet.getAge())
                .petName(peopleAndPet.getPetName())
                .myName(peopleAndPet.getMyName())
                .build();
    }
}
