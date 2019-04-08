package com.example.springtesting.controller;

import com.example.springtesting.DTO.request.JavaDeveloperRequest;
import com.example.springtesting.DTO.response.JavaDeveloperResponse;
import com.example.springtesting.service.JavaDeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/developer")
public class JavaDeveloperController {

    @Autowired
    private JavaDeveloperService javaDeveloperService;

    @GetMapping
    public List<JavaDeveloperResponse> getAllDevelopers() {
        System.out.println("Get all developers");
        return javaDeveloperService.findAll();
    }

    @PostMapping
    public void createJavaDeveloper(@RequestBody JavaDeveloperRequest javaDeveloperRequest) {
        System.out.println("Developer " + javaDeveloperRequest.getName() + " added.");
        javaDeveloperService.save(javaDeveloperRequest);

    }

}
