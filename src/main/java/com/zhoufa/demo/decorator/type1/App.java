package com.zhoufa.demo.decorator.type1;

import lombok.extern.slf4j.Slf4j;
import lombok.var;

@Slf4j
public class App {

    public static void main(String[] args) {

        System.out.println("A simple looking troll approaches.");

        var troll = new SimpleTroll();
        troll.attack();
        troll.fleeBattle();
        System.out.println("Simple troll power ：" + troll.getAttackPower());

        System.out.println("A troll with huge club surprises u.");
        var clubTroll = new ClubbedTroll(troll);
        clubTroll.attack();
        clubTroll.fleeBattle();
        System.out.println("Clubbed troll power " +clubTroll.getAttackPower());


    }
}
