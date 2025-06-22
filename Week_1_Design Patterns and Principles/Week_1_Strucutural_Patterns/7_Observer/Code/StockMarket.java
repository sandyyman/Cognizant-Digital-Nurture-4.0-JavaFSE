import java.util.ArrayList;
import java.util.List;

public class StockMarket implements Stock {
    private List<Observer> observers;
    private String stockName;
    private double stockPrice;

    public StockMarket(String stockName, double initialPrice) {
        this.stockName = stockName;
        this.stockPrice = initialPrice;
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(stockName, stockPrice);
        }
    }

    public void setStockPrice(double newPrice) {
        System.out.println("Updating stock price for " + stockName + " to " + newPrice);
        this.stockPrice = newPrice;
        notifyObservers();
    }
}
