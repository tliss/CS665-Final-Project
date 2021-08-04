package edu.bu.met.cs665;

public abstract class Weapon {
  protected int strength;

  public void fireAt(SpaceShip targetShip) {
    targetShip.takeDamage(this.strength);
  }
}
