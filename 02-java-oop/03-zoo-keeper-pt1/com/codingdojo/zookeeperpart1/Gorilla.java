package com.codingdojo.zookeeperpart1;

public class Gorilla extends Mammal {
    public void throwSomething() {
        this.setEnergyLevel(this.getEnergyLevel() - 5);
        System.out.println("The gorilla has thrown something, and decreased its energy level by 5");
    }

    public void eatBananas() {
        this.setEnergyLevel(this.getEnergyLevel() + 10);
        System.out.println("The gorilla has eaten bananas and is satisfied, its energry level increased by 10");
    }

    public void climb() {
         this.setEnergyLevel(this.getEnergyLevel() - 10);
        System.out.println("The gorilla has climbed a tree and decreased its energy by 10");
   }

}