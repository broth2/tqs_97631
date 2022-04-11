package io.cucumber.skeleton;

public class Belly {
    public void eat(int cukes) {
        
        System.out.printf("%d cukes eaten\n", cukes);
    }
    public void wait(int hour){

        System.out.printf("%d hours waited\n", hour);
    }
    public void growl(){

        System.out.println("Belly: *growls*");
    }

}
