package edu.bu.met.cs665;

public class SpaceShip {
  private Hull hull;
  private Thruster thruster;
  private Weapon weapon;

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

  public void setHull(Hull hull) {
    this.hull = hull;
  }

  public void setThruster(Thruster thruster) {
    this.thruster = thruster;
  }

  public void setWeapon(Weapon weapon) {
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
