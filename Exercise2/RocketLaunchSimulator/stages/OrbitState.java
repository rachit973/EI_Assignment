package RocketLaunchSimulator.stages;



import RocketLaunchSimulator.model.Rocket;
import RocketLaunchSimulator.model.RocketState;

/**
 * OrbitState represents the state where the rocket has successfully reached orbit.
 * The mission is complete at this stage.
 */
public class OrbitState implements RocketState {
    @Override
    public void handle(Rocket rocket) {
        System.out.println("Rocket is now in orbit. Mission complete.");
    }
}
