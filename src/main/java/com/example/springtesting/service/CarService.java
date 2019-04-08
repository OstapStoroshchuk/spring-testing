package com.example.springtesting.service;

import com.example.springtesting.entity.Car;
import com.example.springtesting.entity.JavaDeveloper;
import com.example.springtesting.DTO.request.CarRequest;
import com.example.springtesting.DTO.response.CarResponse;
import com.example.springtesting.repository.CarRepository;
import com.example.springtesting.repository.JavaDeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private JavaDeveloperRepository developerRepository;

    @Transactional
    public CarResponse save(CarRequest carRequest) {
        Car car = new Car();
        car.setBrand(carRequest.getBrand());
        car.setModel(carRequest.getModel());
        car.setOwner(findDeveloperById(carRequest.getOwnerId()));
        return new CarResponse(carRepository.save(car));
    }

    @Transactional
    public List<CarResponse> findAllCars() {
        return carRepository.findAll().stream().map(CarResponse::new).collect(Collectors.toList());
    }

    @Transactional
    public JavaDeveloper findDeveloperById(Long id) {
        Optional<JavaDeveloper> developer = developerRepository.findById(id);
        if (developer.isPresent()) {
            return developer.get();
        } else {
            throw new IllegalArgumentException("Developer with id " + id + "was not found");
        }
    }
}
