package com.example.springtesting.entity;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class JavaDeveloper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "owner")
    private List<Car> cars;

}
