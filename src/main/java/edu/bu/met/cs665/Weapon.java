package edu.bu.met.cs665;

/**
 * This is the abstract class that all weapons implement.
 */
public abstract class Weapon {
  protected int strength;

  /**
   * Deal damage to another ship based on the strength of the weapon.
   * @param targetShip the ship you are targeting
   */
  public void fireAt(SpaceShip targetShip) {
    targetShip.takeDamage(this.strength);
  }

  public int getStrength() {
    return strength;
  }
}
