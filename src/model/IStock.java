package model;

public interface IStock {

    /**
     * @return
     */
    public String getTicker();

    /**
     * @return
     */
    public String getName();

    /**
     * @return
     */
    public double getShares();

    /**
     * @return
     */
    public double getPricePerShare();

    /**
     * @return
     */
    public double getHoldingValue();

    /**
     * @param shares
     * @require shares > 0
     * @modifies this
     * @effects this.shares' = this.shares + shares
     * totalcost' = totalcost + shares * pricePerShare
     */
    public void buy(int shares) throws NegativeShares;

    /**
     * @param shares
     * @require shares > 0 && shares <= this.shares
     * @modifies this
     * @effects this.shares' = this.shares - shares
     * totalValueSold' = totalValuesSold + shares * pricePerShare
     */
    public void sell(double shares) throws NegativeShares;


    /**
     * @return gain/loss percentage
     */
    public double netGainPercentage();

}
