package edu.bu.met.cs665;

import com.oblac.nomen.Casing;
import com.oblac.nomen.Nomen;
import java.util.Random;

/**
 * This class defines the components of a spaceship and what a spaceship can do. Builders build
 * a spaceship by creating a new object and assigning it a hull, thrusters, and a weapon.
 */
public class SpaceShip {
  private Hull hull;
  private Thruster thruster;
  private Weapon weapon;
  private final String name;
  private boolean destroyed; //when a ship's hull reaches 0 health, this is flipped to true

  /**
   * Creates a spaceship with no components defined. Auto-generates a random name.
   */
  public SpaceShip() {
    this.hull = null;
    this.thruster = null;
    this.weapon = null;
    this.name = generateName();
    this.destroyed = false;
  }

  /**
   * Creates a spaceship with the provided components.
   * @param hull The hull of the ship
   * @param thruster The thruster of the ship
   * @param weapon The weapon of the ship
   * @param name The name of the ship
   */
  public SpaceShip(Hull hull, Thruster thruster, Weapon weapon, String name) {
    this.hull = hull;
    this.thruster = thruster;
    this.weapon = weapon;
    this.name = name;
    this.destroyed = false;
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

  /**
   * Uses this ship's weapon to damage another ship's hull.
   * @param targetShip the target ship
   */
  public void fireAt(SpaceShip targetShip) {
    this.weapon.fireAt(targetShip);
  }

  /**
   * Used to take damage to the ship. If the hull reaches 0, then the destroyed flag is switched
   * to true.
   * @param damage the amount of damage to the hull
   */
  public void takeDamage(int damage) {
    if (this.hull.takeDamage(damage)) {
      this.destroyed = true;
    }
  }

  public boolean isDestroyed() {
    return this.destroyed;
  }

  public int getHealth() {
    return this.hull.getHealth();
  }

  /**
   * Used just for fun. Does't affect combat.
   */
  public void toggleThrusterPower() {
    this.thruster.toggle();
  }

  public boolean thrustersOnline()  {
    return this.thruster.isPowered();
  }

  public int getSpeed() {
    return this.thruster.getSpeed();
  }

  public int getStrength() {
    return this.weapon.getStrength();
  }

  /**
   * Used to print what the ship is equipped with.
   * @return A string array with the spaceship's weapon, thruster, and hull.
   */
  public String[] getLoadout() {
    return new String[] {
        this.thruster.getClass().getSimpleName(),
        this.weapon.getClass().getSimpleName(),
        this.hull.getClass().getSimpleName()
    };
  }

  public String getName() {
    return this.name;
  }

  /**
   * Randomly generates a name for the spaceship.
   * @return a randomly generated string used for the ship's name
   */
  private String generateName() {
    String name = "";
    Random rand = new Random();
    int nextInt = rand.nextInt(2);
    if (nextInt == 0) {
      Nomen nomen = new Nomen().withSpace(" ").withSeparator(" ").withCasing(Casing.CAPITALIZE);
      name = "The " + nomen.adjective().noun().get();
    } else {
      Nomen nomen = new Nomen().withSpace(" ").withSeparator("").withCasing(Casing.CAPITALIZE);
      name = nomen.person().literal("'s ").noun().get();
    }
    return name;
  }
}
