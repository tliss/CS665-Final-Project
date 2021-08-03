package edu.bu.met.cs665;

public abstract class Hull {
  private int health;

  public int getHealth() {
    return health;
  }

  protected void setHealth(int health) {
    this.health = health;
  }

  public void takeDamage(int damage) {
    health -= damage;
    if (health <= 0) {
      health = 0;
    }
  }
}
