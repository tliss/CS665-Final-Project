package edu.bu.met.cs665.builder;

import edu.bu.met.cs665.SpaceShip;

/**
 * This is the interface that all spaceshipbuilders implement.
 */
public interface SpaceShipBuilder {
  void setWeapon();

  void setHull();

  void setThruster();

  SpaceShip getSpaceShip();

  /**
   * Should reset the spaceship object held by the builder.
   */
  void reset();
}
