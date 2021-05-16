package com.codingdojo.zookeeperpart2;

public class Bat extends Mammal {
    public Bat() {
        this.setEnergyLevel(300);
    }

    public void fly() {
        this.setEnergyLevel(this.getEnergyLevel() - 50);
        System.out.println("Sound of the bat taking off, energy level decreased by 50");
    }

    public void eatHumans() {
        this.setEnergyLevel(this.getEnergyLevel() + 25);
    }

    public void attackTown() {
         this.setEnergyLevel(this.getEnergyLevel() - 100);
        System.out.println("Sound of a town on fire, energy level decreased by 100");
   }

}