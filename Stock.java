import java.util.*;

// Observer interface
interface Observer {
    void update(String stockName, double price);
}

// Subject (Observable)
class Stock {
    private String name;
    private double price;
    private final List<Observer> observers = new ArrayList<>();

    public Stock(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(name, price);
        }
    }
}

// Concrete Observers
class MobileApp implements Observer {
    private String user;

    public MobileApp(String user) {
        this.user = user;
    }

    @Override
    public void update(String stockName, double price) {
        System.out.println("MobileApp (" + user + "): " 
            + stockName + " updated to " + price);
    }
}

class WebApp implements Observer {
    private String dashboard;

    public WebApp(String dashboard) {
        this.dashboard = dashboard;
    }

    @Override
    public void update(String stockName, double price) {
        System.out.println("WebApp (" + dashboard + "): " 
            + stockName + " updated to " + price);
    }
}

// Main class
public class StockObserverDemo {
    public static void main(String[] args) {
        Stock stock = new Stock("Tesla", 750.00);

        Observer user1 = new MobileApp("Alice");
        Observer user2 = new MobileApp("Bob");
        Observer webDashboard = new WebApp("Investor Dashboard");

        stock.addObserver(user1);
        stock.addObserver(user2);
        stock.addObserver(webDashboard);

        // Simulate stock price updates
        stock.setPrice(760.50);
        stock.setPrice(770.25);
    }
}
