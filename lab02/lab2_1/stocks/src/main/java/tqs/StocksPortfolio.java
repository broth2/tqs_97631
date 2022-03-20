package tqs;

import java.util.*;

public class StocksPortfolio {
    private ArrayList<Stock> stocks;
    private IStockMarketService service;


    //constructor
    public StocksPortfolio(IStockMarketService service){
        this.stocks = new ArrayList<Stock>();
        this.service = service;
    }

    
    //getters and setters
    public ArrayList<Stock> getStocks() {
        return stocks;
    }

    public IStockMarketService getService() {
        return service;
    }

    public void setService(IStockMarketService service) {
        this.service = service;
    }

    //methods
    public void addStock(Stock stk){
        this.stocks.add(stk);
    }

    public double getTotalValue(){
        double value = 0;
        for (Stock stk: this.stocks){
            value += this.service.lookUpPrice(stk.getLabel()) * stk.getQuantity();
        }
        return value;
    }
    
}
