package edu.bu.met.cs665.builder;

import edu.bu.met.cs665.SpaceShip;

/**
 * This class instantiates a director who is responsible for building
 * building Spaceship objects using a provided SpaceShipBuilder.
 */
public class Director {
  private SpaceShipBuilder spaceShipBuilder;

  public Director(SpaceShipBuilder spaceShipBuilder) {
    this.spaceShipBuilder = spaceShipBuilder;
  }

  /**
   * Switches the active spaceship.builder.
   * @param spaceShipBuilder The new spaceshipbuilder.
   */
  public void switchBuilder(SpaceShipBuilder spaceShipBuilder) {
    this.spaceShipBuilder = spaceShipBuilder;
  }

  public SpaceShip getSpaceShip() {
    return this.spaceShipBuilder.getSpaceShip();
  }

  /**
   * Builds a spaceship using the provided spaceshipbuilder.
   */
  public void constructSpaceShip() {
    this.spaceShipBuilder.reset();
    this.spaceShipBuilder.setHull();
    this.spaceShipBuilder.setWeapon();
    this.spaceShipBuilder.setThruster();
  }
}
