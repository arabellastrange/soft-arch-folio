package model;

import model.web.NoSuchTickerException;
import model.web.WebsiteDataException;
import javax.naming.InvalidNameException;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

class Folio implements IFolio {

    private String name;
    private Set<Stock> stocks;

    Folio(String name) {
        this.name = name;
        stocks = new HashSet<>();
    }

    Folio(Folio f) {
        name = f.name;
        stocks = f.stocks
                .stream()
                .map(stock -> new Stock(stock))
                .collect(Collectors.toSet());
    }

    void refresh() throws WebsiteDataException, NoSuchTickerException {
        for (Stock s : stocks) {
            s.refresh();
        }
    }

    @Override
    public boolean createStock(String ticker, String name, int shares) throws InvalidNameException, NegativeShares, NoSuchTickerException, WebsiteDataException {
        if (name == null || name.isEmpty()) throw new InvalidNameException("name is empty or null");
        if (shares <= 0) throw new NegativeShares();
        Stock s = new Stock(ticker, name, shares);
        return stocks.add(s);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Folio folio = (Folio) o;

        if (!name.equals(folio.name)) return false;
        return stocks.equals(folio.stocks);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + stocks.hashCode();
        return result;
    }

    @Override
    public boolean deleteStock(IStock stock) {
        return stocks.remove(stock);
    }

    @Override
    public Set<IStock> getStocks() {
        Set<IStock> set = new HashSet<>();
        stocks.forEach(stock -> set.add(new Stock(stock)));
        return set;
    }

    @Override
    public double getValue() {
        int value = 0;
        for (Stock stock : stocks)
            value += stock.getHoldingValue();
        return value;
    }

}
