package com.zhoufa.demo.eventbus.custom;

import lombok.AllArgsConstructor;

import java.lang.reflect.Method;

@AllArgsConstructor
public class Subscriber {

    private final Object target;

    private final Method method;


}
