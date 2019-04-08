package com.example.springtesting.service;

import com.example.springtesting.entity.JavaDeveloper;
import com.example.springtesting.DTO.request.JavaDeveloperRequest;
import com.example.springtesting.DTO.response.JavaDeveloperResponse;
import com.example.springtesting.repository.JavaDeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JavaDeveloperService {

    @Autowired
    private JavaDeveloperRepository developerRepository;

    public Long save(JavaDeveloperRequest javaDeveloperRequest) {
        JavaDeveloper javaDeveloper = new JavaDeveloper();
        javaDeveloper.setName(javaDeveloperRequest.getName());

        javaDeveloper = developerRepository.save(javaDeveloper);
        System.out.println("Developer " + javaDeveloper.getName() + " added.");
        return javaDeveloper.getId();
    }

    public List<JavaDeveloperResponse> findAll() {
        return developerRepository.findAll().stream()
                .map(JavaDeveloperResponse::new)
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        developerRepository.deleteById(id);
    }

    @Transactional
    public JavaDeveloperResponse findOne(Long id) {
        Optional<JavaDeveloper> personOptional = developerRepository.findById(id);
        if (personOptional.isPresent()) {
            return new JavaDeveloperResponse(personOptional.get());
        } else {
            throw new IllegalArgumentException("Person with id " + id + "was not found");
        }
    }

}
