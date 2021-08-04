package edu.bu.met.cs665;

import org.apache.log4j.Logger;

public abstract class Thruster {
  private static final Logger logger = Logger.getLogger(Thruster.class);

  private int speed = 0;
  protected int maxSpeed;
  // Thrusters are created with their power off.
  private boolean powered = false;

  public int getSpeed() {
    return speed;
  }

  public boolean isPowered() {
    return powered;
  }

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
