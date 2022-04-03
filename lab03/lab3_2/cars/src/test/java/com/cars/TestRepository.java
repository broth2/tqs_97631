package com.cars;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.*;
import static org.assertj.core.api.Assertions.assertThat;

//import static org.hamcrest.MatcherAssert.assertThat;

@DataJpaTest
public class TestRepository {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CarRepository repository;

    @Test
    void whenFindById_thenReturnCar() {
        Car supra = new Car("Toyota", "Supra");
        entityManager.persistAndFlush(supra); 
        
        Car found = repository.findByCarId(supra.getCarId());
        assertThat(found).isNotNull();
        assertThat(found.getModel()).isEqualTo(supra.getModel());
        assertThat( found ).isEqualTo(supra);
    }

    @Test
    void whenInvalidCarId_thenReturnNull() {
        Car fromDb = repository.findByCarId(12L);
        assertThat(fromDb).isNull();
    }

    @Test
    void givenSetOfCars_whenFindAll_thenReturnAllCars() {

        Car gtr = new Car("nissan", "r34");
		Car rx7 = new Car("mazda", "rx-7");
        Car corolla = new Car("Toyota", "Corolla");

        entityManager.persist(gtr);
        entityManager.persist(rx7);
        entityManager.persist(corolla);
        entityManager.flush();

        List<Car> allCars = repository.findAll();

        assertThat(allCars).hasSize(3).extracting(Car::getModel).containsOnly(gtr.getModel(), rx7.getModel(), corolla.getModel());
    }
    
}
