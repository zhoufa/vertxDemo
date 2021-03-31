package com.zhoufa.demo.decorator.type2;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

//奶茶口味decorator
@AllArgsConstructor
public abstract class Taste implements MilkTea {

    MilkTea tea;

}
