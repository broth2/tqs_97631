package com.cars;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;
// import org.junit.jupiter.api.AfterEach;
// import org.junit.jupiter.api.BeforeEach;

// import org.mockito.InjectMocks;
// import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.is;
// import static org.hamcrest.MatcherAssert.assertThat;
// import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;
import static org.hamcrest.Matchers.hasSize;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.*;

@WebMvcTest(CarController.class)
class TestController {

	@Autowired
  	private MockMvc mvc;

	@MockBean
	private CarManagerService service;

	@Test
    void whenPostCar_thenCreateCar( ) throws Exception {
		Car supra = new Car("Toyota", "Supra");
		when(service.save(Mockito.any())).thenReturn(supra);

        mvc.perform(
                post("/api/cars").contentType(MediaType.APPLICATION_JSON).content(JsonUtils.toJson(supra)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.model", is("Supra")));

        verify(service, times(1)).save(Mockito.any());

    }

    @Test
    void givenManyCars_whenGetCars_thenReturnJsonArray() throws Exception {
		Car fiesta = new Car("ford", "fiesta");
		Car gtr = new Car("nissan", "r34");
		Car rx7 = new Car("mazda", "rx-7");



        List<Car> allCars = Arrays.asList(fiesta, gtr, rx7);

        when( service.getAllCars()).thenReturn(allCars);

        mvc.perform(
                get("/api/cars").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].maker", is(fiesta.getMaker())))
                .andExpect(jsonPath("$[1].maker", is(gtr.getMaker())))
                .andExpect(jsonPath("$[2].model", is(rx7.getModel())));
        verify(service, times(1)).getAllCars();
    }

}
