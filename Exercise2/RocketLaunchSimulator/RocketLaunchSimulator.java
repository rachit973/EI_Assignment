package RocketLaunchSimulator;



import RocketLaunchSimulator.model.Rocket;


import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Main class that runs the Rocket Launch Simulator.
 * It accepts user commands to start checks, launch the rocket, and fast-forward the simulation.
 */
public class RocketLaunchSimulator {
    private static final Logger logger = Logger.getLogger(RocketLaunchSimulator.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Rocket rocket = new Rocket();
        boolean checksCompleted = false;

        while (true) {
            System.out.println("Enter command (start_checks, launch, fast_forward X): ");
            String input = scanner.nextLine().trim();

            try {
                if (input.equalsIgnoreCase("start_checks")) {
                    // Perform pre-launch checks
                    rocket.handle();
                    checksCompleted = true;
                } else if (input.equalsIgnoreCase("launch")) {
                    if (!checksCompleted) {
                        System.out.println("Please complete pre-launch checks first.");
                    } else {
                        // Simulate the rocket launch step-by-step
                        while (rocket.getAltitude() < 100 && rocket.getFuel() > 0) {
                            rocket.handle();
                        }
                    }
                } else if (input.startsWith("fast_forward")) {
                    if (!checksCompleted) {
                        System.out.println("Please complete pre-launch checks first.");
                    } else {
                        // Parse the fast forward command
                        String[] parts = input.split(" ");
                        if (parts.length == 2) {
                            try {
                                int seconds = Integer.parseInt(parts[1]);
                                // Fast forward by X seconds
                                rocket.fastForward(seconds);
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid fast forward time.");
                            }
                        } else {
                            System.out.println("Invalid fast forward command. Usage: fast_forward X");
                        }
                    }
                } else {
                    System.out.println("Invalid command. Try again.");
                }
            } catch (Exception e) {
                logger.severe("Error occurred: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
