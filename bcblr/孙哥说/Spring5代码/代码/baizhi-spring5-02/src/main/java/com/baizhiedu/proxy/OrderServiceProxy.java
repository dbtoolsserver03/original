package com.baizhiedu.proxy;

public class OrderServiceProxy implements OrderService {

    private OrderServiceImpl orderService  = new OrderServiceImpl();

    @Override
    public void showOrder() {
        System.out.println("----log----");
        orderService.showOrder();
    }
}
