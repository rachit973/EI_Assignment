// Observer Pattern
import java.util.ArrayList;
import java.util.List;

/**
 * Subject class that maintains a list of observers and notifies them of changes.
 */
class WeatherStation {
    private List<WeatherObserver> observers = new ArrayList<>();
    private int temperature;

    /**
     * Adds an observer to the list of observers.
     * @param observer The observer to be added.
     */
    public void addObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    /**
     * Removes an observer from the list of observers.
     * @param observer The observer to be removed.
     */
    public void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
    }

    /**
     * Sets the temperature and notifies all observers of the change.
     * @param temperature The new temperature value.
     */
    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    /**
     * Notifies all observers of the temperature change.
     */
    public void notifyObservers() {
        for (WeatherObserver observer : observers) {
            observer.update(temperature);
        }
    }
}

/**
 * Observer interface that defines the update method for observers.
 */
interface WeatherObserver {
    /**
     * Called when the observed temperature changes.
     * @param temperature The updated temperature value.
     */
    void update(int temperature);
}

/**
 * Concrete Observer class that implements the WeatherObserver interface.
 */
class PhoneDisplay implements WeatherObserver {
    @Override
    public void update(int temperature) {
        System.out.println("Phone Display: Temperature updated to " + temperature);
    }
}

/**
 * Main class to demonstrate the Observer pattern.
 */
public class observer {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        PhoneDisplay phoneDisplay = new PhoneDisplay();
        station.addObserver(phoneDisplay);
        station.setTemperature(30);
    }
}

