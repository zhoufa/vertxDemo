package com.zhoufa.testDemo.eventbus;

import com.google.common.eventbus.EventBus;
import com.zhoufa.demo.eventbus.guava.OrderEventListener;
import com.zhoufa.demo.eventbus.guava.OrderMessage;
import org.junit.Test;

public class EventBusTest {

    @Test
    public void register() {
        EventBus eventBus = new EventBus();
        eventBus.register(new OrderEventListener());
        eventBus.post(OrderMessage.builder().orderContent("二〇二一年四月一日 星期四 李四订单").build());
    }
}
