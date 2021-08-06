package edu.bu.met.cs665.builder;

import edu.bu.met.cs665.SpaceShip;

public interface SpaceShipBuilder {
  void setWeapon();
  void setHull();
  void setThruster();
  SpaceShip getSpaceShip();
  void reset();
}
