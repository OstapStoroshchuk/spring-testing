package com.example.springtesting.controller;

import com.example.springtesting.DTO.request.CarRequest;
import com.example.springtesting.DTO.response.CarResponse;
import com.example.springtesting.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping
    public List<CarResponse> getAllCars() {
        System.out.println("Get all cars");
        return carService.findAllCars();
    }

    @PostMapping
    public void createCar(@RequestBody CarRequest carRequest) {
        System.out.println("Car " + carRequest.getBrand() + " " + carRequest.getModel() + " added.");
        carService.save(carRequest);
    }


}
