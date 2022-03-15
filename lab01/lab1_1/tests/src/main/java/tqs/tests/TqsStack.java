package tqs.tests;

import java.util.*;

public class TqsStack {
    private ArrayList<Integer> stk;
    private int boundary;

    public TqsStack(){
        this.stk = new ArrayList<Integer>();
        this.boundary=0;
    }

    
    public void push(Integer x){
        if(this.boundary!=0 && stk.size()+1>this.boundary)
            throw new IllegalStateException("stack is full error");
        this.stk.add(x);
    }

    public int pop(){
        if (stk.size()==0)
            throw new NoSuchElementException("empty stack error");
        return stk.remove(stk.size()-1);
    }

    public Integer peek(){
        if (stk.size()==0)
            throw new NoSuchElementException("empty list error");
        return stk.get(stk.size()-1);
    }

    public Integer size(){
        return stk.size();
    }

    public Boolean isEmpty(){
        if (stk.size()>0) return false;
        return true;
    }

    public void deBUG(){
        for(Integer i: this.stk){
            System.out.println(i);        
        }
    }

    public void setBoundary(int b){
        this.boundary=b;
    }
}
