package edu.bu.met.cs665;

import org.apache.log4j.Logger;

/**
 * This abstract class is the one from which all thrusters are implemented. Faster thrusters
 * mean that your ship will get to go first in the arena.
 */
public abstract class Thruster {
  private static final Logger logger = Logger.getLogger(Thruster.class);

  private int speed = 0;
  // When thrusters are on, their speed is set to their max speed.
  protected int maxSpeed;

  // Thrusters are created with their power off.
  private boolean powered = false;

  public int getSpeed() {
    return speed;
  }

  public boolean isPowered() {
    return powered;
  }

  /**
   * Just a flavor method to show whether the thruster is powered or not.
   */
  public void toggle() {
    if (this.powered) {
      logger.info("Disengaging thrusters.");
      this.powered = false;
      this.speed = 0;
    } else {
      logger.info("Engaging thrusters!");
      this.powered = true;
      this.speed = maxSpeed;
    }
  }
}
