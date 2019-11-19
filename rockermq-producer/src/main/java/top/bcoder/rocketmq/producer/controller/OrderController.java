package top.bcoder.rocketmq.producer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.bcoder.rocketmq.producer.service.OrdersService;

/**
 * @author zln
 * @date 2019/11/19
 */
@RestController
@Slf4j
public class OrderController {

    private final OrdersService orderService;

    @Autowired
    public OrderController(OrdersService orderService) {

        this.orderService = orderService;
    }

    @GetMapping("/add/order")
    public String addOrder() {
        return orderService.addOrder();
    }
}
