package com.zhoufa.demo.decorator.type2;

import cn.hutool.core.util.StrUtil;

public class CoffeeTaste extends Taste{

    public CoffeeTaste(MilkTea tea) {
        super(tea);
    }

    @Override
    public String milkTeaName() {
        return StrUtil.concat(true, tea.milkTeaName(), " " , "加咖啡");
    }

    @Override
    public int milkTeaPrice() {
        return tea.milkTeaPrice() + 10;
    }
}
