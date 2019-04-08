package com.example.springtesting.DTO.response;

import com.example.springtesting.entity.Car;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarResponse {

    private Long id;

    private String brand;

    private String model;

    private JavaDeveloperResponse javaDeveloperResponse;

    public CarResponse(Car car) {
        this.id = car.getId();
        this.brand = car.getBrand();
        this.model = car.getModel();
        this.javaDeveloperResponse = new JavaDeveloperResponse(car.getOwner());
    }
}
