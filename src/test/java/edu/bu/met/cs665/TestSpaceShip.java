package edu.bu.met.cs665;

import org.apache.log4j.Logger;
import org.junit.Test;

public class TestSpaceShip {
  private static final Logger logger = Logger.getLogger(TestSpaceShip.class);

  @Test
  public void testHullConstruction() {
    LightHull testLightHull = new LightHull();
    logger.info("Health created with " + testLightHull.getHealth());
    testLightHull.takeDamage(2);
    logger.info("Health is " + testLightHull.getHealth());
  }
}
