package com.codingdojo.objectmasterp2;

public class Human {
    protected int strength;
    protected int stealth;
    protected int intelligence;
    protected int health;

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Human() {
        this.strength = 3;
        this.stealth = 3;
        this.intelligence = 3;
        this.health = 100;
    }

    public void attack(Human target) {
        target.setHealth(target.getHealth() - this.strength);
    }
}