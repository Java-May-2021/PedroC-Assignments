package com.codingdojo.zookeeperpart1;

public class Mammal {
    private int energyLevel;

    public int getEnergyLevel() {
        return this.energyLevel;
    }

    public void setEnergyLevel(int energyLevel) {
        this.energyLevel = energyLevel;
    }

    public Mammal() {
        this.energyLevel = 100;
    }

    public void displayEnergy() {
        System.out.println(this.energyLevel);
    } 
}