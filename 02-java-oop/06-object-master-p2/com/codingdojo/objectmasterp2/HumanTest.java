package com.codingdojo.objectmasterp2;

public class HumanTest {
    public static void main(String[] args) {
        Wizard w = new Wizard();
        Ninja n = new Ninja();
        Samurai s = new Samurai();

        w.fireball(n);
        w.heal(n);

        n.steal(w);
        n.runAway();

        s.deathBlow(w);
        s.meditate();

        System.out.println(w.getHealth());
        System.out.println(n.getHealth());
        System.out.println(s.getHealth());
        System.out.println(Samurai.howMany());
    }
}