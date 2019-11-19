package top.bcoder.rocketmq.producer.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.bcoder.rocketmq.producer.bean.Orders;
import top.bcoder.rocketmq.producer.dao.OrdersMapper;

import java.util.UUID;

/**
 * @author zln
 * @date 2019/11/19
 */
@Service
@Slf4j
public class OrdersServiceImpl implements OrdersService {

    private final OrdersMapper ordersMapper;

    private final RocketMQTemplate rocketMQTemplate;

    @Autowired
    public OrdersServiceImpl(OrdersMapper ordersMapper, RocketMQTemplate rocketMQTemplate) {
        this.ordersMapper = ordersMapper;
        this.rocketMQTemplate = rocketMQTemplate;
    }




    @Override
    @Transactional
    public String addOrder() {
        log.info("创建订单");
        Orders orders = Orders.builder().name(UUID.randomUUID().toString()).piece(12.0).build();
        ordersMapper.insert(orders);

        log.info("订单消息发送给rocketmq");
        rocketMQTemplate.convertAndSend("order-topic", orders);

        log.info("异常了");
        int i = 1 / 0;
        return "创建成功";
    }
}
