package com.zhoufa.demo.decorator.type2;

import cn.hutool.core.util.StrUtil;

//加冰
public class IceTaste extends Taste{

    public IceTaste(MilkTea tea) {
        super(tea);
    }

    @Override
    public String milkTeaName() {
        return StrUtil.concat(true, tea.milkTeaName(), " " , "加冰");
    }

    @Override
    public int milkTeaPrice() {
        return tea.milkTeaPrice() + 5;
    }
}
