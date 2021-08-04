package edu.bu.met.cs665;

public class SpaceShip {
  private Hull hull;
  private Thruster thruster;
  private Weapon weapon;

  SpaceShip(Hull hull, Thruster thruster, Weapon weapon) {
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
}
