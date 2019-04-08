package com.example.springtesting.repository;

import com.example.springtesting.entity.JavaDeveloper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JavaDeveloperRepository extends JpaRepository<JavaDeveloper, Long> {
}
