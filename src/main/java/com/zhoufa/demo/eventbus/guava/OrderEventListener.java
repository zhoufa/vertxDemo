package com.zhoufa.demo.eventbus.guava;

import com.google.common.eventbus.Subscribe;

public class OrderEventListener {

    @Subscribe
    public void dealWithEvent(OrderMessage message) {
        System.out.println("我收到了命令为：" + message.orderContent);
    }
}
