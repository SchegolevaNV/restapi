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

        long totalElements = myDataPage.getTotalElements();
        int pageSize = myDataPage.getSize();

        myDataPageResource.setPageSize(pageSize);
        myDataPageResource.setPageNumber(myDataPage.getNumber());
        myDataPageResource.setTotal(totalElements);

        long totalPages;
        if ((totalElements % pageSize) == 0) {
            totalPages = totalElements / pageSize;
        } else {
            totalPages = (totalElements / pageSize) + 1;
        }

        myDataPageResource.setPagesTotal(totalPages);

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
