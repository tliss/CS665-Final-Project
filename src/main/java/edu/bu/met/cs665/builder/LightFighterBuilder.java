package edu.bu.met.cs665.builder;

import edu.bu.met.cs665.*;

/**
 * This builder builds a spaceship using lowest-tier components.
 */
public class LightFighterBuilder implements SpaceShipBuilder{

    private SpaceShip spaceShip;

    @Override
    public void reset() {
        this.spaceShip = new SpaceShip();
    }

    public LightFighterBuilder() {
        this.spaceShip = new SpaceShip();
    }

    @Override
    public void setWeapon() {
        spaceShip.setWeapon(new LaserWeapon());
    }

    @Override
    public void setHull() {
        spaceShip.setHull(new LightHull());
    }

    @Override
    public void setThruster() {
        spaceShip.setThruster(new BasicThruster());
    }

    @Override
    public SpaceShip getSpaceShip() {
        return this.spaceShip;
    }
}
