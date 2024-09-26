package RocketLaunchSimulator.stages;


import RocketLaunchSimulator.model.Rocket;
import RocketLaunchSimulator.model.RocketState;

import java.util.logging.Logger;

/**
 * PreLaunchState handles the pre-launch checks.
 * Once completed, it transitions the rocket to Stage 1.
 */
public class PreLaunchState implements RocketState {
    private static final Logger logger = Logger.getLogger(PreLaunchState.class.getName());

    @Override
    public void handle(Rocket rocket) {
        System.out.println("All systems are 'Go' for launch.");
        logger.info("Pre-Launch checks completed.");
        rocket.setState(new StageOneState());
    }
}
