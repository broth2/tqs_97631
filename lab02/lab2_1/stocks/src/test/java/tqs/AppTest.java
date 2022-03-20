package tqs;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.Matchers.closeTo;


import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.MockitoAnnotations;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.beans.Transient;

/**
 * Unit test for simple App.
 */

@ExtendWith(MockitoExtension.class)
public class AppTest 
{

    @Mock
    private IStockMarketService service;

    @InjectMocks
    private StocksPortfolio portfolio;  //inject instance with mock

    
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this); //create instanced
    }

    @Test 
	void zeroInitValue(){
		//StocksPortfolio stkp = new StocksPortfolio(new IStockMarketService());
		Assertions.assertEquals(0, portfolio.getTotalValue());
	}

    @Test 
    void valueTest(){
        portfolio.addStock(new Stock("icb", 2));
        portfolio.addStock(new Stock("cbd", 1));
        portfolio.addStock(new Stock("pmc", 1));

        //stub
        when(service.lookUpPrice(anyString())).thenReturn(2.5);

        //assert
        Assertions.assertEquals(10, portfolio.getTotalValue());

        //verify that it was called 3 times
        verify(service, times(3)).lookUpPrice(anyString());
    }

    @Test 
    void hamcrestValueTest(){
        portfolio.addStock(new Stock("cbd", 1));
        portfolio.addStock(new Stock("pmc", 1));

        when(service.lookUpPrice(anyString())).thenReturn(2.0);
        assertThat(portfolio.getTotalValue(), closeTo(4.0, 0.1));
        assertThat(4.0, is(portfolio.getTotalValue()));


    }
}
