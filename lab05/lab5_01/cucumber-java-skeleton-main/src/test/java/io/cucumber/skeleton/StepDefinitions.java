package io.cucumber.skeleton;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitions {
    private Belly belly;
    private Calculator calc;


    @Given("I have {int} cuke(s) in my belly")
    public void I_have_cukes_in_my_belly(int cukes) {
        belly = new Belly();
        belly.eat(cukes);
    }

    @When("I wait {int} hour(s)")
    public void I_wait(int hour){
        belly = new Belly();
        belly.wait(hour);
    }
    
    @Then("my belly should growl")
    public void my_belly_should_growl() {
        belly = new Belly();
        belly.growl();
    }

    
    @Given("A calculator I just turned on")
    public void setup() {
        calc = new Calculator();
    }

    @When("I add {int} and {int}")
    public void add(int arg1, int arg2) {
        calc.push(arg1);
        calc.push(arg2);
        calc.push("+");
    }

    @When("I substract {int} to {int}")
    public void substract(int arg1, int arg2) {
        calc.push(arg1);
        calc.push(arg2);
        calc.push("-");
    }

    @Then("the result is {double}")
    public void the_result_is(double expected) {
        assertEquals(expected, calc.value());
    }
}
