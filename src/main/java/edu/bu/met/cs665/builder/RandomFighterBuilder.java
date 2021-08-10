package edu.bu.met.cs665.builder;

import edu.bu.met.cs665.AdvancedThruster;
import edu.bu.met.cs665.BasicThruster;
import edu.bu.met.cs665.CannonWeapon;
import edu.bu.met.cs665.ExperimentalThruster;
import edu.bu.met.cs665.HeavyHull;
import edu.bu.met.cs665.LaserWeapon;
import edu.bu.met.cs665.LightHull;
import edu.bu.met.cs665.MediumHull;
import edu.bu.met.cs665.MissileWeapon;
import edu.bu.met.cs665.SpaceShip;
import java.util.Random;

/**
 * This builder builds a spaceship using randomly selected components.
 */
public class RandomFighterBuilder implements SpaceShipBuilder {
  private SpaceShip spaceShip;
  private Random random;

  public RandomFighterBuilder() {
    this.spaceShip = new SpaceShip();
    random = new Random();
  }

  @Override
  public void reset() {
    this.spaceShip = new SpaceShip();
    random = new Random();
  }

  @Override
  public void setWeapon() {
    int randInt = random.nextInt(3);
    switch (randInt) {
      case 0:
        spaceShip.setWeapon(new LaserWeapon());
        break;
      case 1:
        spaceShip.setWeapon(new CannonWeapon());
        break;
      case 2:
        spaceShip.setWeapon(new MissileWeapon());
      default:
        break;
    }
  }

  @Override
  public void setHull() {
    int randInt = random.nextInt(3);
    switch (randInt) {
      case 0:
        spaceShip.setHull(new LightHull());
        break;
      case 1:
        spaceShip.setHull(new MediumHull());
        break;
      case 2:
        spaceShip.setHull(new HeavyHull());
      default:
        break;
    }
  }

  @Override
  public void setThruster() {
    int randInt = random.nextInt(3);
    switch (randInt) {
      case 0:
        spaceShip.setThruster(new BasicThruster());
        break;
      case 1:
        spaceShip.setThruster(new AdvancedThruster());
        break;
      case 2:
        spaceShip.setThruster(new ExperimentalThruster());
      default:
        break;
    }
  }

  @Override
  public SpaceShip getSpaceShip() {
    return this.spaceShip;
  }
}
