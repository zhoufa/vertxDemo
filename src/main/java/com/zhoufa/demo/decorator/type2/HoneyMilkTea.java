package com.zhoufa.demo.decorator.type2;

public class HoneyMilkTea implements MilkTea{
    @Override
    public String milkTeaName() {
        return "蜂蜜奶茶";
    }

    @Override
    public int milkTeaPrice() {
        return 15;
    }
}
