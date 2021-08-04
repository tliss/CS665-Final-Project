package edu.bu.met.cs665;

public abstract class Hull {
  protected int health;

  public int getHealth() {
    return health;
  }

  public void takeDamage(int damage) {
    health -= damage;
    if (health <= 0) {
      health = 0;
    }
  }
}
