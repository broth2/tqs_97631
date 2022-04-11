package io.cucumber.skeleton;

import java.util.ArrayList;

public class Calculator {
    private ArrayList<Integer> data;
    private double result;

    public Calculator(){
        data = new ArrayList<>();
    }

    public void push(int value){
        data.add(value);
    }
    public void push(String operand){
        if(operand.equals("-")){
            result = data.remove(data.size()-2) - data.remove(data.size()-1);
        }else if (operand.equals("+")){
            result = data.remove(data.size()-2) + data.remove(data.size()-1);
        }
    }
    public double value(){
        return result;
    }
}
