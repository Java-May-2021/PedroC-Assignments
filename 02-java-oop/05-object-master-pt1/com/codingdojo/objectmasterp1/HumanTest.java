package com.codingdojo.objectmasterp1;

public class HumanTest {
    public static void main(String[] args) {
        Human attacker = new Human();
        Human target = new Human();
        attacker.attack(target);
        System.out.println(target.getHealth());
    }
}