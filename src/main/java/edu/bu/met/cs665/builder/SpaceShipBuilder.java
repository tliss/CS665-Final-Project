package edu.bu.met.cs665.builder;

import edu.bu.met.cs665.Hull;
import edu.bu.met.cs665.SpaceShip;
import edu.bu.met.cs665.Thruster;
import edu.bu.met.cs665.Weapon;

public interface SpaceShipBuilder {
  public void setWeapon();
  public void setHull();
  public void setThruster();
  public SpaceShip getSpaceShip();
}
