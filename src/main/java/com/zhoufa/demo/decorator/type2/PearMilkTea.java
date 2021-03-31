package com.zhoufa.demo.decorator.type2;

public class PearMilkTea implements MilkTea{

    @Override
    public String milkTeaName() {
        return "珍珠奶茶";
    }

    @Override
    public int milkTeaPrice() {
        return 8;
    }
}
