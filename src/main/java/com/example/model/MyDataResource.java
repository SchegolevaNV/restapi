package com.example.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@NoArgsConstructor
public class MyDataResource {

    private String myName;
    private String petName;
    private int age;
}
