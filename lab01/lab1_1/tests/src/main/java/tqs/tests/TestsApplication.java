package tqs.tests;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tqs.tests.TqsStack;

@SpringBootApplication
public class TestsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestsApplication.class, args);
		TqsStack stk = new TqsStack();

		stk.push(13);
		
	}

}
