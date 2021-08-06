package edu.bu.met.cs665;

import java.util.Arrays;

public class Arena {
  private SpaceShip shipA;
  private SpaceShip shipB;

  public Arena(SpaceShip shipA, SpaceShip shipB) {
    this.shipA = shipA;
    this.shipB = shipB;
  }

  public void Battle() {
    System.out.println(shipA.getName() + " " + Arrays.toString(shipA.getLoadout()));
    System.out.println("vs");
    System.out.println(shipB.getName() + " " + Arrays.toString(shipB.getLoadout()));
  }
}
