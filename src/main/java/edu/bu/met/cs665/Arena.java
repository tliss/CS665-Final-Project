package edu.bu.met.cs665;

import java.util.Arrays;
import org.apache.log4j.Logger;

/**
 * This class is used to create an arena object in which two spaceships can battle. Ships take turns
 * attack eachother until one of them is destroyed.
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
    logger.info("Fighter 1: " + shipA.getName() + " " + Arrays.toString(shipA.getLoadout()));
    logger.info("Fighter 2: " + shipB.getName() + " " + Arrays.toString(shipB.getLoadout()));

    SpaceShip fastestShip = null;
    SpaceShip slowestShip = null;
    if (shipA.getSpeed() > shipB.getSpeed()) {
      fastestShip = shipA;
      slowestShip = shipB;
    } else {
      fastestShip = shipB;
      slowestShip = shipA;
    }
    logger.info(fastestShip.getName() + " has the speed advantage!");

    boolean result = false;
    while (!result) {
      result = exchangeFire(fastestShip, slowestShip);
    }
  }

  /**
   * Fixes names by adding a space in between lowercase and capital letters.
   * @param name the name to fix
   * @return the fixed name
   */
  private String fixName(String name) {
    return name.replaceAll("\\d+", "")
        .replaceAll("(.)([A-Z])", "$1 $2");
  }

  /**
   * Ships take turns shooting at eachother. The ship with the higher thruster speed shoots first.
   * If the ships have the same thruster speed, then shipA shoots first.
   *
   * @return true once one of teh ships has been destroyed.
   */
  private boolean exchangeFire(SpaceShip fastShip, SpaceShip slowShip) {
    String fastShipWeapon = fixName(fastShip.getLoadout()[1]);
    String slowShipWeapon = fixName(slowShip.getLoadout()[1]);
    String fastShipHull = fixName(fastShip.getLoadout()[2]);
    String slowShipHull = fixName(slowShip.getLoadout()[2]);

    fastShip.fireAt(slowShip);
    logger.info(fastShip.getName() + "'s " + fastShipWeapon + " damages " + slowShip.getName()
        + "'s " + slowShipHull + " for " + fastShip.getStrength() + " damage!");
    if (slowShip.isDestroyed()) {
      logger.info(
          shipB.getName() + " has been destroyed! " + fastShip.getName() + " is the winner!");
      return true;
    }
    slowShip.fireAt(fastShip);
    logger.info(slowShip.getName() + "'s " + slowShipWeapon + " damages " + fastShip.getName()
        + "'s " + fastShipHull + " for " + slowShip.getStrength() + " damage!");
    if (fastShip.isDestroyed()) {
      logger.info(fastShip.getName() + " has been destroyed! " + slowShip.getName() + " is the winner!");
      return true;
    }
    return false;
  }
}
