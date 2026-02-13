import dev.robocode.tankroyale.botapi.*;
import dev.robocode.tankroyale.botapi.events.*;
import dev.robocode.tankroyale.botapi.graphics.Color;


public class Ben extends Bot {

    boolean peek; 
    double moveAmount; 

    // The main method starts our bot
    public static void main(String[] args) {
        new Ben().start();
    }

    // Called when a new round is started -> initialize and do some movement
    @Override
    public void run() {
        // Set colors
        setBodyColor(Color.BLACK);
        setTurretColor(Color.PURPLE);
        setRadarColor(Color.PURPLE);
        setBulletColor(Color.PURPLE);
        setScanColor(Color.PURPLE);

        // Initialize moveAmount to the maximum possible for the arena
        moveAmount = Math.max(getArenaWidth(), getArenaHeight());
        // Initialize peek to false
        peek = false;

        // turn to face a wall.
        // `getDirection() % 90` means the remainder of getDirection() divided by 90.
        turnRight(getDirection() % 90);
        forward(moveAmount);

        // Turn the gun to turn right 90 degrees.
        peek = true;
        turnGunLeft(90);
        turnLeft(90);

        // Main loop
        while (isRunning()) {
            // Peek before we turn when forward() completes.
            peek = true;
            // Move up the wall
            forward(moveAmount);
            // Don't peek now
            peek = false;
            // Turn to the next wall
            turnLeft(90);
        }
    }

   
    @Override
    public void onHitBot(HitBotEvent e) {
        // If he's in front of us, get him
        var bearing = bearingTo(e.getX(), e.getY());
        if (bearing > -90 && bearing < 90) {
            forward(100);
            fire(3);
        } else { //back up
            back(100);
        }
    }

    // We scanned another bot -> fire!
    @Override
    public void onScannedBot(ScannedBotEvent e) {
        fire(2);
    }
}
