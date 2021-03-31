package com.zhoufa.demo.decorator.type2;

public class App {

    public static void main(String[] args) {
        MilkTea tea = new CoffeeTaste(new HoneyMilkTea());
        System.out.println(tea.milkTeaPrice() + "   " + tea.milkTeaName());
    }
}
