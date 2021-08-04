package edu.bu.met.cs665.builder;

import edu.bu.met.cs665.BasicThruster;
import edu.bu.met.cs665.LaserWeapon;
import edu.bu.met.cs665.LightHull;
import javafx.util.Builder;

public class Director {
  private SpaceShipBuilder builder;

  public void setBuilder(SpaceShipBuilder builder) {
    this.builder = builder;
  }

  public void constructLightFighter(SpaceShipBuilder builder) {
    builder.reset();
    builder.setThruster(new BasicThruster());
    builder.setWeapon(new LaserWeapon());
    builder.setHull(new LightHull());
  }
}
