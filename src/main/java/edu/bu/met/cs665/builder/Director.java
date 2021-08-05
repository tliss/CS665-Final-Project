package edu.bu.met.cs665.builder;

import edu.bu.met.cs665.SpaceShip;

public class Director {
  private final SpaceShipBuilder spaceShipBuilder;

  public Director(SpaceShipBuilder spaceShipBuilder) {
    this.spaceShipBuilder = spaceShipBuilder;
  }

  public SpaceShip getSpaceShip() {
    return this.spaceShipBuilder.getSpaceShip();
  }

  public void constructSpaceShip() {
    this.spaceShipBuilder.setHull();
    this.spaceShipBuilder.setWeapon();
    this.spaceShipBuilder.setThruster();
  }
}
