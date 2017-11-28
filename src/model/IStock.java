package model;

import javax.naming.InvalidNameException;
import java.util.Observer;

public interface IStock {

    /**
     * @return ticker
     */
    public String getTicker();

    /**
     * @return name
     */
    public String getName();

    /**
     * @return shares
     */
    public double getShares();

    /**
     * @return price of share
     */
    public double getPricePerShare();

    /**
     * @return total stock value
     */
    public double getHoldingValue();

    /**
     * @require
     * @modifies this
     * @effects this.shares' = this.shares + shares
     *          totalcost' = totalcost + shares * pricePerShare
     */
    public void buy(int shares) throws NegativeSharesException;

    /**
     * @require
     * @modifies this
     * @effects this.shares' = this.shares - shares
     * totalcost' = totalcost - shares * pricePerShare
     */
    public void sell(double shares) throws NegativeSharesException;


    /**
     *  @return loss/profit
     */
    public double lossProfit();

    /**
     *@modifies this
     */
    public void setName(String name) throws InvalidNameException, EmptyNameException;


    public void registerObserver(Observer o);
}
