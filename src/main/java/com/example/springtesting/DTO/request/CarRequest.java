package com.example.springtesting.DTO.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarRequest {

    private String brand;

    private String model;

    private Long ownerId;
}
