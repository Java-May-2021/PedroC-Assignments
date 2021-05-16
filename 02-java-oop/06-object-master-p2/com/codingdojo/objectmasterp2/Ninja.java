package com.codingdojo.objectmasterp2;

public class Ninja extends Human {
    public Ninja() {
        super();
        this.stealth = 10;
    }

    public void steal(Human target) {
        target.setHealth(target.getHealth() - this.stealth);
        this.health = this.health + this.stealth;
    } 

    public void runAway() {
        this.health = this.health - 10;
    } 
}