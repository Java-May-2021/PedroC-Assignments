package com.codingdojo.objectmasterp2;

public class Wizard extends Human {
    public Wizard() {
        super();
        this.intelligence = 8;
        this.health = 50;
    }

    public void heal(Human target) {
        target.setHealth(target.getHealth() + this.intelligence);
    } 

    public void fireball(Human target) {
        target.setHealth(target.getHealth() - (this.intelligence * 3));
    } 
}