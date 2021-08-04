package edu.bu.met.cs665;

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
}
