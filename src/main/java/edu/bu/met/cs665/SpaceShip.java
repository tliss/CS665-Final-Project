package edu.bu.met.cs665;

import com.oblac.nomen.Casing;
import com.oblac.nomen.Nomen;
import java.util.Random;

/**
 * aeaeaaa
 */
public class SpaceShip {
  private Hull hull;
  private Thruster thruster;
  private Weapon weapon;
  private String name;
  private boolean destroyed;

  public SpaceShip() {
    this.hull = null;
    this.thruster = null;
    this.weapon = null;
    this.name = generateName();
    this.destroyed = false;
  }

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

  public void fireAt(SpaceShip targetShip) {
    this.weapon.fireAt(targetShip);
  }

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
