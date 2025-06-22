public class ObserverTest {
    public static void main(String[] args) {
        StockMarket infy = new StockMarket("INFY", 1700.00);

        Observer mobileObserver = new MobileApp("User1");
        Observer webObserver = new WebApp("User2");

        infy.registerObserver(mobileObserver);
        infy.registerObserver(webObserver);

        infy.setStockPrice(1710.25);
        infy.setStockPrice(1725.00);
    }
}
