package edu.bu.met.cs665;

import java.util.Arrays;
import org.apache.log4j.Logger;

/**
 * This class is used to create an arena object in which two spaceships can battle. Ships take
 * turns attack eachother until one of them is destroyed.
 */
public class Arena {
  private static final Logger logger = Logger.getLogger(Arena.class);

  private SpaceShip shipA;
  private SpaceShip shipB;

  public Arena(SpaceShip shipA, SpaceShip shipB) {
    this.shipA = shipA;
    this.shipB = shipB;
  }

  /**
   * Has the two ships take shots at eachother until one is destroyed.
   */
  public void battle() {
    System.out.println(shipA.getName() + " " + Arrays.toString(shipA.getLoadout()));
    System.out.println("vs");
    System.out.println(shipB.getName() + " " + Arrays.toString(shipB.getLoadout()));

    boolean result = false;
    while (!result) {
      result = exchangeFire();
    }
  }

  /**
   * Ships take turns shooting at eachother. The ship with the higher thruster speed shoots
   * first. If the ships have the same thruster speed, then shipA shoots first.
   * @return true if one of the ships has been destroyed.
   */
  private boolean exchangeFire() {
    if (shipA.getSpeed() > shipB.getSpeed()) {
      shipA.fireAt(shipB);
      logger.info(shipA.getName() + "'s " + shipA.getLoadout()[1] + " damages " + shipB.getName()
        + "'s " + shipB.getLoadout()[2] + " for " + shipA.getStrength() + " damage!");
      if (shipB.isDestroyed()) {
        logger.info(shipB.getName() + " has been destroyed! " + shipA.getName() + " is the winner!");
        return true;
      }
      shipB.fireAt(shipA);
      logger.info(shipB.getName() + "'s " + shipB.getLoadout()[1] + " damages " + shipA.getName()
          + "'s " + shipA.getLoadout()[2] + " for " + shipB.getStrength() + " damage!");
      if (shipA.isDestroyed()) {
        logger.info(shipA.getName() + " has been destroyed! " + shipB + " is the winner!");
        return true;
      }
    } else {
      shipB.fireAt(shipA);
      logger.info(shipB.getName() + "'s " + shipB.getLoadout()[1] + " damages " + shipA.getName()
          + "'s " + shipA.getLoadout()[2] + " for " + shipB.getStrength() + " damage!");
      if (shipA.isDestroyed()) {
        logger.info(shipA.getName() + " has been destroyed! " + shipB.getName() + " is the winner!");
        return true;
      }
      shipA.fireAt(shipB);
      logger.info(shipA.getName() + "'s " + shipA.getLoadout()[1] + " damages " + shipB.getName()
          + "'s " + shipB.getLoadout()[2] + " for " + shipA.getStrength() + " damage!");
      if (shipB.isDestroyed()) {
        logger.info(shipB.getName() + " has been destroyed! " + shipA + " is the winner!");
        return true;
      }
    }
    return false;
  }
}
