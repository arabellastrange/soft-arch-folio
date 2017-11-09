package model;

public class Stock {

    private String ticker;
    private String name; //no way of getting the name from provided classes
    private double sharePrice;
    private double amount;
    private double totalCost;
    private double totalValueSold;

    private Stock(String ticker, double sharePrice, double amount) {
        this.ticker = ticker;
        this.sharePrice = sharePrice;
        this.amount = amount;
        totalCost = sharePrice*amount;
        totalValueSold = 0;
    }

    private void buy(double amount){
        this.amount += amount;
        totalCost += amount*sharePrice; //Ensure sharePrice is price when bought
    }

    private void sell(double amount){
        this.amount -= amount;
        totalValueSold += amount*sharePrice; //Ensure sharePrice is price when sold
    }

    //Returns net gain as a percentage
    private double netGainPercentage(){
        return ((sharePrice*amount+totalValueSold)/totalCost)*100;
    }

}
