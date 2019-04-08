package com.example.springtesting.DTO.response;

import com.example.springtesting.entity.JavaDeveloper;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JavaDeveloperResponse {

    private Long id;

    private String name;

    public JavaDeveloperResponse(JavaDeveloper javaDeveloper) {
        this.id = javaDeveloper.getId();
        this.name = javaDeveloper.getName();
    }
}
