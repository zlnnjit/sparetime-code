package top.bcoder.rocketmq.consumer.mq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author zln
 * @date 2019/11/19
 */
@Slf4j
@Service
@RocketMQMessageListener(topic = "order-topic", consumerGroup = "zln")
public class OrdersListener implements RocketMQListener<String>{

    @Override
    public void onMessage(String s) {
        log.info("收到订单信息，清除当前购物车信息。订单信息为：{}", s);
    }
}
