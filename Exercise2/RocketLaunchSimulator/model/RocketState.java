package RocketLaunchSimulator.model;


/**
 * RocketState interface represents different states the rocket can be in during the launch process.
 */
public interface RocketState {
    void handle(Rocket rocket);
}

