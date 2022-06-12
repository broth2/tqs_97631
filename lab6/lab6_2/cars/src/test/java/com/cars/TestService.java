package com.cars;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.mockito.junit.jupiter.MockitoExtension;
// import static org.hamcrest.MatcherAssert.assertThat;
// import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class TestService {
    @Mock( lenient = true)
    private CarRepository repository;

    @InjectMocks
    private CarManagerService service;

    @BeforeEach
    public void setUp(){
        Car corolla = new Car("Toyota", "Corolla");
        corolla.setCarId(500L);

		Car gtr = new Car("nissan", "r34");
		Car rx7 = new Car("mazda", "rx-7");

        List<Car> allCars = Arrays.asList(corolla, gtr, rx7);

        Mockito.when(repository.findByCarId(corolla.getCarId())).thenReturn(corolla);
        Mockito.when(repository.findByCarId(gtr.getCarId())).thenReturn(gtr);
        Mockito.when(repository.findByCarId(rx7.getCarId())).thenReturn(rx7);
        Mockito.when(repository.findByCarId(400L)).thenReturn(null);
        Mockito.when(repository.findById(rx7.getCarId())).thenReturn(Optional.of(rx7));
        Mockito.when(repository.findAll()).thenReturn(allCars);
        Mockito.when(repository.findById(-99L)).thenReturn(Optional.empty());
    }

    @Test
     void whenSearchValidId_thenCarShouldBeFound() {
        long id = 500L;
        Car found = service.getCarDetails(id);

        assertThat(found.getCarId()).isEqualTo(id);
    }

    @Test
     void whenSearchInvalidId_thenCarShouldNotBeFound() {
        Car fromDb = service.getCarDetails(6L);
        assertThat(fromDb).isNull();

        verifyFindByCarIdIsCalledOnce(6L);
    }



    @Test
     void given3Employees_whengetAll_thenReturn3Records() {

		Car gtr = new Car("nissan", "r34");
		Car rx7 = new Car("mazda", "rx-7");
        Car corolla = new Car("Toyota", "Corolla");


        List<Car> allCars = service.getAllCars();
        verifyFindAllCarsIsCalledOnce();
        assertThat(allCars).hasSize(3).extracting(Car::getMaker).contains(gtr.getMaker(), rx7.getMaker(), corolla.getMaker());
    }

    private void verifyFindByCarIdIsCalledOnce(Long id) {
        Mockito.verify(repository, VerificationModeFactory.times(1)).findByCarId(id);
    }

    private void verifyFindAllCarsIsCalledOnce() {
        Mockito.verify(repository, VerificationModeFactory.times(1)).findAll();
    }
    
}
