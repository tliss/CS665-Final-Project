package edu.bu.met.cs665.builder;

import edu.bu.met.cs665.ExperimentalThruster;
import edu.bu.met.cs665.HeavyHull;
import edu.bu.met.cs665.MissileWeapon;
import edu.bu.met.cs665.SpaceShip;

public class HeavyFighterBuilder implements SpaceShipBuilder{

    private SpaceShip spaceShip;

    @Override
    public void reset() {
        this.spaceShip = new SpaceShip();
    }

    public HeavyFighterBuilder() {
        this.spaceShip = new SpaceShip();
    }

    @Override
    public void setWeapon() {
        spaceShip.setWeapon(new MissileWeapon());
    }

    @Override
    public void setHull() {
        spaceShip.setHull(new HeavyHull());
    }

    @Override
    public void setThruster() {
        spaceShip.setThruster(new ExperimentalThruster());
    }

    @Override
    public SpaceShip getSpaceShip() {
        return this.spaceShip;
    }
}
