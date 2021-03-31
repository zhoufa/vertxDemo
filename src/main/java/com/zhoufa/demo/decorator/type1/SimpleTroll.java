package com.zhoufa.demo.decorator.type1;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimpleTroll implements Troll{

    @Override
    public void attack() {
        System.out.println("The Troll tries to grab U!!");
    }

    @Override
    public int getAttackPower() {
        return 10;
    }

    @Override
    public void fleeBattle() {
       System.out.println("The troll shrieks in horror and runs away!");
    }
}
