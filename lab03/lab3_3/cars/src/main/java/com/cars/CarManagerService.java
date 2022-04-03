package com.cars;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarManagerService {
    @Autowired
    private CarRepository repository;

    public Car save(Car car){
        return repository.save(car);
    }    

    public List<Car> getAllCars(){
        return repository.findAll();
    }

    public Car getCarDetails(Long id){
        return repository.findByCarId(id);
    }
}
