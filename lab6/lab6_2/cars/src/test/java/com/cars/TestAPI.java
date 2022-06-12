package com.cars;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

@AutoConfigureTestDatabase
public class TestAPI {
    @LocalServerPort
    int randomServerPort;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private CarRepository repository;

    @AfterEach
    public void resetDb() {
        repository.deleteAll();
    }
    
    @Test
     void whenValidInput_thenCreateEmployee() {
        Car nsx = new Car("Honda", "NSX");
        ResponseEntity<Car> entity = restTemplate.postForEntity("/api/cars", nsx, Car.class);

        List<Car> found = repository.findAll();
        assertThat(found).extracting(Car::getModel).containsOnly("NSX");
    }

    @Test
     void givenCars_whenGetCars_thenStatus200()  {
        Car gtr = new Car("nissan", "r34");
		Car rx7 = new Car("mazda", "rx-7");
        repository.saveAndFlush(gtr);
        repository.saveAndFlush(rx7);


        ResponseEntity<List<Car>> response = restTemplate
                .exchange("/api/cars", HttpMethod.GET, null, new ParameterizedTypeReference<List<Car>>() {
                });

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).extracting(Car::getMaker).containsExactly("nissan", "mazda");

    }
}
