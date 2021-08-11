package edu.bu.met.cs665;

/**
 * This is the abstract Hull class that all hulls implement.
 */
public abstract class Hull {
  protected int health;

  public int getHealth() {
    return health;
  }

  /**
   * Hulls can take damage from weapons but will never drop below 0 health.
   * @param damage the amount of damage the hull has taken.
   * @return true if the damage equals zero.
   */
  public boolean takeDamage(int damage) {
    health -= damage;
    if (health <= 0) {
      health = 0;
      return true;
    }
    return false;
  }
}
