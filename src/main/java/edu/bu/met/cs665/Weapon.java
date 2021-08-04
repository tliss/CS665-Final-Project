package edu.bu.met.cs665;

public abstract class Weapon {
  private int strength;

  public int getStrength() {
    return strength;
  }

  public void setStrength(int strength) {
    this.strength = strength;
  }

  public void fireAt(SpaceShip targetShip) {
    targetShip.takeDamage(this.strength);
  }
}
