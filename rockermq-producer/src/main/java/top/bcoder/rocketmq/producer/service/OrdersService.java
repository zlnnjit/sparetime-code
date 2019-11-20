package top.bcoder.rocketmq.producer.service;

import top.bcoder.rocketmq.producer.bean.Orders;

/**
 * @author zln
 * @date 2019/11/19
 */
public interface OrdersService {
    String addOrder();

    void add(Orders orders);
}
