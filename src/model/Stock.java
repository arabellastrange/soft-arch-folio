package model;

import model.web.NoSuchTickerException;
import model.web.StrathQuoteServer;
import model.web.WebsiteDataException;

class Stock implements IStock {

    private String ticker;
    private String name; //no way of getting the name from provided classes
    private double sharePrice;
    private double amount;
    private double totalCost;
    private double totalValueSold;

    Stock(String ticker, String name, double amount) {
        this.ticker = ticker;
        this.name = name;
        this.amount = amount;
        totalCost = sharePrice * amount;
        totalValueSold = 0;
        update();
    }

    boolean update() {
        String s;
        try {
            s = StrathQuoteServer.getLastValue(ticker);
            sharePrice = Double.parseDouble(s.trim());
        } catch (WebsiteDataException | NoSuchTickerException | NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public String getTicker() {
        return ticker;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getShares() {
        return amount;
    }

    @Override
    public double getPricePerShare() {
        return sharePrice;
    }

    @Override
    public double getHoldingValue() {
        return amount*sharePrice;
    }

    @Override
    public void buy(double amount) {
        this.amount += amount;
        totalCost += amount * sharePrice;
    }

    @Override
    public void sell(double amount) {
        this.amount -= amount;
        totalValueSold += amount * sharePrice;
    }

    @Override
    public double netGainPercentage() {
        return ((sharePrice * amount + totalValueSold) / totalCost) * 100;
    }

}
