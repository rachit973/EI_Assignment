package RocketLaunchSimulator.model;


import java.util.logging.Logger;

/**
 * Rocket class represents the context for the Rocket launch simulation.
 * It maintains its current state and provides methods to update its fuel, altitude, and speed.
 */
public class Rocket {
    private RocketState state;
    private double fuel;
    private double altitude;
    private double speed;

    private static final Logger logger = Logger.getLogger(Rocket.class.getName());

    public Rocket() {
        this.state = new RocketLaunchSimulator.stages.PreLaunchState();  // Initial state
        this.fuel = 100.0;
        this.altitude = 0.0;
        this.speed = 0.0;
    }

    public void setState(RocketState newState) {
        this.state = newState;
    }

    public void decreaseFuel(double amount) {
        this.fuel = Math.max(0, this.fuel - amount);  // Ensures fuel doesn't go below 0
    }

    public void increaseAltitude(double amount) {
        this.altitude += amount;
    }

    public void increaseSpeed(double amount) {
        this.speed += amount;
    }

    public double getFuel() {
        return fuel;
    }

    public double getAltitude() {
        return altitude;
    }

    public double getSpeed() {
        return speed;
    }

    public void handle() {
        state.handle(this);
    }

    public void failMission(String message) {
        System.out.println(message);
        logger.severe(message);
        System.exit(0);  // End the simulation
    }

    public void fastForward(int seconds) {
        for (int i = 0; i < seconds; i++) {
            handle();  // Simulate each second
        }
    }
}
