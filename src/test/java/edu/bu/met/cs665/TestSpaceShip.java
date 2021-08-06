package edu.bu.met.cs665;

import edu.bu.met.cs665.builder.Director;
import edu.bu.met.cs665.builder.LightFighterBuilder;
import edu.bu.met.cs665.builder.SpaceShipBuilder;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

public class TestSpaceShip {
  private static final Logger logger = Logger.getLogger(TestSpaceShip.class);

  @Test
  public void testHullConstructionAndDamage() {
    logger.info("Testing creation of hull and hull damage.");
    LightHull testLightHull = new LightHull();
    Assert.assertEquals(5, testLightHull.getHealth());
    testLightHull.takeDamage(2);
    Assert.assertEquals(3, testLightHull.getHealth());
  }

  @Test
  public void testShipReceivingDamage() {
    logger.info("Testing one ship firing at another.");
    SpaceShip testSpaceShip = new SpaceShip(new LightHull(), new BasicThruster(), new LaserWeapon());
    SpaceShip testEnemySpaceShip = new SpaceShip(new LightHull(), new BasicThruster(), new LaserWeapon());

    testSpaceShip.fireAt(testEnemySpaceShip);
    Assert.assertEquals(3, testEnemySpaceShip.getHealth());
  }

  @Test
  public void testShipThrusters() {
    SpaceShip testSpaceShip = new SpaceShip(new LightHull(), new BasicThruster(), new LaserWeapon());
    Assert.assertEquals(0, testSpaceShip.getSpeed());
    Assert.assertFalse(testSpaceShip.thrustersOnline());
    testSpaceShip.toggleThrusterPower();
    Assert.assertEquals(10, testSpaceShip.getSpeed());
    Assert.assertTrue(testSpaceShip.thrustersOnline());
    testSpaceShip.toggleThrusterPower();
    Assert.assertEquals(0, testSpaceShip.getSpeed());
    Assert.assertFalse(testSpaceShip.thrustersOnline());
  }

  @Test
  public void testBuildLightFighter() {
    SpaceShipBuilder lightFighterBuilder = new LightFighterBuilder();
    Director director = new Director(lightFighterBuilder);
    director.constructSpaceShip();
    SpaceShip spaceShip = director.getSpaceShip();
    spaceShip.toggleThrusterPower();
  }
}
