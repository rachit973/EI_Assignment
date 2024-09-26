package RocketLaunchSimulator.stages;



import RocketLaunchSimulator.model.Rocket;
import RocketLaunchSimulator.model.RocketState;

import java.util.logging.Logger;

/**
 * StageOneState represents the first stage of the rocket launch.
 * It consumes fuel, increases altitude and speed, and transitions to Stage 2 after reaching a certain altitude.
 */
public class StageOneState implements RocketState {
    private static final Logger logger = Logger.getLogger(StageOneState.class.getName());

    private static final double FUEL_CONSUMPTION = 10.0;
    private static final double ALTITUDE_INCREASE = 10.0;
    private static final double SPEED_INCREASE = 1000.0;
    private static final double STAGE_COMPLETION_ALTITUDE = 50.0;

    @Override
    public void handle(Rocket rocket) {
        if (rocket.getFuel() < FUEL_CONSUMPTION) {
            rocket.failMission("Mission Failed due to insufficient fuel.");
            return;
        }
        rocket.decreaseFuel(FUEL_CONSUMPTION);
        rocket.increaseAltitude(ALTITUDE_INCREASE);
        rocket.increaseSpeed(SPEED_INCREASE);
        
        System.out.printf("Stage: 1, Fuel: %.2f%%, Altitude: %.2f km, Speed: %.2f km/h%n",
                rocket.getFuel(), rocket.getAltitude(), rocket.getSpeed());

        if (rocket.getAltitude() >= STAGE_COMPLETION_ALTITUDE) {
            logger.info("Stage 1 complete. Entering Stage 2.");
            System.out.println("Stage 1 complete. Separating stage. Entering Stage 2.");
            rocket.setState(new StageTwoState());
        }
    }
}
