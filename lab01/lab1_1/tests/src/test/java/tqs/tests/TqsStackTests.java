package tqs.tests;

import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class TqsStackTests {
    TqsStack tqs;

    @BeforeEach
    void createStack(){
        this.tqs = new TqsStack();
    }

    @Test
    void emptyOnConstruct(){
        Assertions.assertTrue(this.tqs.isEmpty());
    }

    @Test
    void zeroOnConstruct(){
        Assertions.assertEquals(0,this.tqs.size());
    }

    @Test
    void pushTest(){
        Random r = new Random();
        int num_pushes = r.nextInt(10) + 1;
        for(int i=0; i<num_pushes; i++ ){
            this.tqs.push(5);
        }
        Assertions.assertFalse(this.tqs.isEmpty());
        Assertions.assertEquals(num_pushes,this.tqs.size());
    }

    @Test
    void popTest(){
        int x = 20;
        this.tqs.push(x);
        Assertions.assertEquals(x, this.tqs.pop());
    }

    @Test
    void peekTest(){
        int x = 20;
        this.tqs.push(x);
        int prev_size = this.tqs.size();
        Assertions.assertEquals(x, this.tqs.peek());
        Assertions.assertEquals(prev_size, this.tqs.size());
    }

    @Test
    void purgeTest(){
        Random r = new Random();
        int num_pushes = r.nextInt(10) + 1;
        for(int i=0; i<num_pushes; i++ ){
            this.tqs.push(5);
        }

        int prev_size = this.tqs.size();

        for (int j=0; j<prev_size;j++){
            this.tqs.pop();
        }

        Assertions.assertTrue(this.tqs.isEmpty());
        Assertions.assertEquals(0,this.tqs.size());
    }

    @Test
    void emptyPopTest(){
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            this.tqs.pop();
        });
    }

    @Test
    void emptyPeekTest(){
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            this.tqs.peek();
        });
    }

    @Test
    void fullPushTest(){
        Assertions.assertThrows(IllegalStateException.class, () -> {
            this.tqs.setBoundary(3);
            this.tqs.push(1);
            this.tqs.push(2);
            this.tqs.push(3);
            this.tqs.push(4);
        });
    }


}
