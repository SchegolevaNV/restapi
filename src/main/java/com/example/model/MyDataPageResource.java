package com.example.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class MyDataPageResource {

    private List<MyDataResource> myDataResources = new ArrayList<>();
    private int pageNumber;
    private int pageSize;
    private long total;

    public void add(final MyDataResource myDataResource) {
        myDataResources.add(myDataResource);
    }
}
