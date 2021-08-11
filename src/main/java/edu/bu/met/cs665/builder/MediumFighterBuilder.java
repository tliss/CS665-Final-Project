package edu.bu.met.cs665.builder;

import edu.bu.met.cs665.AdvancedThruster;
import edu.bu.met.cs665.CannonWeapon;
import edu.bu.met.cs665.MediumHull;
import edu.bu.met.cs665.SpaceShip;

/**
 * This builder builds a spaceship using medium-tier components.
 */
public class MediumFighterBuilder implements SpaceShipBuilder {

  private SpaceShip spaceShip;

  public MediumFighterBuilder() {
    this.spaceShip = new SpaceShip();
  }

  @Override
  public void reset() {
    this.spaceShip = new SpaceShip();
  }

  @Override
  public void setWeapon() {
    spaceShip.setWeapon(new CannonWeapon());
  }

  @Override
  public void setHull() {
    spaceShip.setHull(new MediumHull());
  }

  @Override
  public void setThruster() {
    spaceShip.setThruster(new AdvancedThruster());
  }

  @Override
  public SpaceShip getSpaceShip() {
    return this.spaceShip;
  }
}
