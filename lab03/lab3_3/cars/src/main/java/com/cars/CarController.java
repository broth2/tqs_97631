package com.cars;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CarController {
    @Autowired
    private CarManagerService service;

    @PostMapping("/cars")
    public ResponseEntity<Car> createCar(@RequestBody Car car){
        return new ResponseEntity<>(service.save(car), HttpStatus.CREATED);
    }

    @GetMapping("/cars")
    public List<Car> getAllCars(){
        return service.getAllCars();
    }


    @GetMapping("/cars/{id}")
    public ResponseEntity<Car> getCarById(long id){
        Car car = service.getCarDetails(id);

        if (car == null) return new ResponseEntity<Car>(car, HttpStatus.NOT_FOUND);
        else return new ResponseEntity<Car>(car, HttpStatus.OK);
    }
}
