package RocketLaunchSimulator.stages;


import RocketLaunchSimulator.model.Rocket;
import RocketLaunchSimulator.model.RocketState;

import java.util.logging.Logger;

/**
 * StageTwoState represents the second stage of the rocket launch.
 * It consumes less fuel, increases altitude and speed, and transitions to orbit after reaching a certain altitude.
 */
public class StageTwoState implements RocketState {
    private static final Logger logger = Logger.getLogger(StageTwoState.class.getName());

    private static final double FUEL_CONSUMPTION = 5.0;
    private static final double ALTITUDE_INCREASE = 20.0;
    private static final double SPEED_INCREASE = 1500.0;
    private static final double ORBIT_ALTITUDE = 100.0;

    @Override
    public void handle(Rocket rocket) {
        if (rocket.getFuel() < FUEL_CONSUMPTION) {
            rocket.failMission("Mission Failed due to insufficient fuel.");
            return;
        }
        rocket.decreaseFuel(FUEL_CONSUMPTION);
        rocket.increaseAltitude(ALTITUDE_INCREASE);
        rocket.increaseSpeed(SPEED_INCREASE);

        System.out.printf("Stage: 2, Fuel: %.2f%%, Altitude: %.2f km, Speed: %.2f km/h%n",
                rocket.getFuel(), rocket.getAltitude(), rocket.getSpeed());

        if (rocket.getAltitude() >= ORBIT_ALTITUDE) {
            logger.info("Orbit achieved. Mission successful.");
            System.out.println("Orbit achieved! Mission Successful.");
            rocket.setState(new OrbitState());
        }
    }
}
