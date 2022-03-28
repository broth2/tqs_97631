# a) Identify a couple of examples on the use of AssertJ expressive methods chaining.

####  From file A_EmployeeRepositoryTest.java line 75:
``` 
assertThat(allEmployees).hasSize(3).extracting(Employee::getName).containsOnly(alex.getName(), ron.getName(), bob.getName());
```

####  From file B_EmployeeService_UnitTest.java line 115:
```
assertThat(allEmployees).hasSize(3).extracting(Employee::getName).contains(alex.getName(), john.getName(), bob.getName());
```
# b) Identify an example in which you mock the behavior of the repository (and avoid involving a database). 
####  From file B_EmployeeService_UnitTest.java, we mock the repository
    @Mock( lenient = true)
    private EmployeeRepository employeeRepository;
### Then stub the it's methods to have a simulated return value
    Mockito.when(employeeRepository.findByName(john.getName())).thenReturn(john);

# c) What is the difference between standard @Mock and @MockBean?
### The @Mock annotation makes it so you can mock an object of a class or an interface, the @MockBean annotation adds mock'ed objects to the Spring application context as a bean, it is therefore used in mocking entities from the Spring context

# d) What is the role of the file “application-integrationtest.properties”? In which conditions will it be used?
### Sometimes, in testing, we want separate enviorments from our production, for that we use this file to override Spring Boot proprieties and proceed with "isolated" tests



# e) The sample project demonstrates three test strategies to assess an API (C, D and E) developed with SpringBoot. Which are the main/key differences?
C - WebMvcTest simulates a web environment for testing, no need to have an actual repository since the service is mocked
D - The Spring Boot application runs in the normal context, through @MockMvc we use the entry point for server-side Spring MVC test support 
E - Uses a real database, also runs the Spring Boot application in the normal context but there is a explicit HTTP client, TestRestTemplate as the REST client