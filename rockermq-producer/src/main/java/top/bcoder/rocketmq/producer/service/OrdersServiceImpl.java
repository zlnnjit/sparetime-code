package top.bcoder.rocketmq.producer.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.bcoder.common.util.util.JacksonUtils;
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


    private final RocketMQTemplate rocketMQTemplate;

    private final OrdersMapper ordersMapper;

    @Autowired
    public OrdersServiceImpl(RocketMQTemplate rocketMQTemplate, OrdersMapper ordersMapper) {
        this.rocketMQTemplate = rocketMQTemplate;
        this.ordersMapper = ordersMapper;
    }

    @Override
    @Transactional
    public String addOrder() {
        log.info("创建订单");
        Orders orders = Orders.builder().name(UUID.randomUUID().toString()).piece(12.0).build();
        Message<String> message = MessageBuilder.withPayload(JacksonUtils.bean2Json(orders)).build();
        rocketMQTemplate.sendMessageInTransaction("send-order", "order-topic", message, null);
        return "创建成功";
    }

    @Transactional
    @Override
    public void add(Orders orders) {
        int i = 1 / 0;
        ordersMapper.insert(orders);
    }

}
