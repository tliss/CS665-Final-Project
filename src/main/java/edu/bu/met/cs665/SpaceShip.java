package edu.bu.met.cs665;

public class SpaceShip {
  private final Hull hull;
  private final Thruster thruster;
  private final Weapon weapon;

  public SpaceShip() {
    this.hull = null;
    this.thruster = null;
    this.weapon = null;
  }

  public SpaceShip(Hull hull, Thruster thruster, Weapon weapon) {
    this.hull = hull;
    this.thruster = thruster;
    this.weapon = weapon;
  }

  public void fireAt(SpaceShip targetShip) {
    this.weapon.fireAt(targetShip);
  }

  public void takeDamage(int damage) {
    this.hull.takeDamage(damage);
  }

  public int getHealth() {
    return this.hull.getHealth();
  }

  public void toggleThrusterPower() {
    this.thruster.toggle();
  }

  public boolean thrustersOnline()  {
    return this.thruster.isPowered();
  }

  public int getSpeed() {
    return this.thruster.getSpeed();
  }
}
