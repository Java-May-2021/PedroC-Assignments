package com.codingdojo.objectmasterp1;

public class Human {
    private int strength;
    private int stealth;
    private int intelligence;
    private int health;

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