package model;

class Stock implements IStock {

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
        totalCost = sharePrice * amount;
        totalValueSold = 0;
    }

    @Override
    public String getTicker() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public double getShares() {
        return 0;
    }

    @Override
    public double getPricePerShare() {
        return 0;
    }

    @Override
    public double getHoldingValue() {
        return 0;
    }

    @Override
    public void buy(double amount) {
        this.amount += amount;
        totalCost += amount * sharePrice; //Ensure sharePrice is price when bought
    }

    @Override
    public void sell(double amount) {
        this.amount -= amount;
        totalValueSold += amount * sharePrice; //Ensure sharePrice is price when sold
    }

    @Override
    public double netGainPercentage() {
        return ((sharePrice * amount + totalValueSold) / totalCost) * 100;
    }

}
