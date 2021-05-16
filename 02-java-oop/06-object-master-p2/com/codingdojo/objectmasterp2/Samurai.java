package com.codingdojo.objectmasterp2;

public class Samurai extends Human {
    public static int samuraiCount = 0;

    public Samurai() {
        super();
        this.health = 200;
        samuraiCount++;
    }

    public void deathBlow(Human target) {
        target.setHealth(0);
        this.health = this.health / 2;
    } 

    public void meditate() {
        this.health = this.health * 2;
    } 

    public static int howMany() {
        return samuraiCount;
    } 
}