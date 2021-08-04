package edu.bu.met.cs665.builder;

import edu.bu.met.cs665.Hull;
import edu.bu.met.cs665.SpaceShip;
import edu.bu.met.cs665.Thruster;
import edu.bu.met.cs665.Weapon;

public abstract class SpaceShipBuilder {
  private SpaceShip spaceShip;
  private Weapon weapon;
  private Hull hull;
  private Thruster thruster;

  public SpaceShipBuilder() {
    this.reset();
  }

  public void reset() {
    this.spaceShip = new SpaceShip();
  }

  public void setWeapon(Weapon weapon) {
    this.weapon = weapon;
  }

  public void setHull(Hull hull) {
    this.hull = hull;
  }

  public void setThruster(Thruster thruster) {
    this.thruster = thruster;
  }

  public SpaceShip getProduct() {
    SpaceShip product = this.spaceShip;
    this.reset();
    return product;
  }
}
