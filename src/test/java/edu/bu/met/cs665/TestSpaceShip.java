package edu.bu.met.cs665;

import edu.bu.met.cs665.builder.Director;
import edu.bu.met.cs665.builder.HeavyFighterBuilder;
import edu.bu.met.cs665.builder.LightFighterBuilder;
import edu.bu.met.cs665.builder.MediumFighterBuilder;
import edu.bu.met.cs665.builder.RandomFighterBuilder;
import edu.bu.met.cs665.builder.SpaceShipBuilder;
import java.util.Arrays;
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
    SpaceShip testSpaceShip = new SpaceShip(new LightHull(), new BasicThruster(), new LaserWeapon(), "Taylor's Test Ship");
    SpaceShip testEnemySpaceShip = new SpaceShip(new LightHull(), new BasicThruster(), new LaserWeapon(), "Taylor's Test Ship");

    testSpaceShip.fireAt(testEnemySpaceShip);
    Assert.assertEquals(3, testEnemySpaceShip.getHealth());
  }

  @Test
  public void testShipThrusters() {
    SpaceShip testSpaceShip = new SpaceShip(new LightHull(), new BasicThruster(), new LaserWeapon(), "Taylor's Test Ship");
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
  public void testBuildFighters() {
    SpaceShipBuilder lightFighterBuilder = new LightFighterBuilder();
    Director director = new Director(lightFighterBuilder);
    director.constructSpaceShip();
    SpaceShip lightFighter = director.getSpaceShip();
    lightFighter.toggleThrusterPower();

    Assert.assertTrue(lightFighter.thrustersOnline());

    SpaceShipBuilder mediumFighterBuilder = new MediumFighterBuilder();
    director.switchBuilder(mediumFighterBuilder);
    director.constructSpaceShip();
    SpaceShip mediumFighter = director.getSpaceShip();
    mediumFighter.toggleThrusterPower();

    Assert.assertTrue(mediumFighter.thrustersOnline());

    SpaceShipBuilder heavyFighterBuilder = new HeavyFighterBuilder();
    director.switchBuilder(heavyFighterBuilder);
    director.constructSpaceShip();
    SpaceShip heavyFighter = director.getSpaceShip();
    heavyFighter.toggleThrusterPower();

    Assert.assertTrue(heavyFighter.thrustersOnline());
  }

  @Test
  public void testRandomFighter() {
    SpaceShipBuilder randomFighterBuilder = new RandomFighterBuilder();
    Director director = new Director(randomFighterBuilder);
    director.constructSpaceShip();
    SpaceShip randomFighter = director.getSpaceShip();
    System.out.println(Arrays.toString(randomFighter.getLoadout()));
  }

  @Test
  public void testArenaFight() {
    SpaceShipBuilder randomFighterBuilder = new RandomFighterBuilder();
    Director director = new Director(randomFighterBuilder);
    director.constructSpaceShip();
    SpaceShip fighterA = director.getSpaceShip();
    director.constructSpaceShip();
    SpaceShip fighterB = director.getSpaceShip();

    Arena arena = new Arena(fighterA, fighterB);
    arena.battle();
  }
}
