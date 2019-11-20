package top.bcoder.rocketmq.producer.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.bcoder.common.util.util.JacksonUtils;
import top.bcoder.rocketmq.producer.bean.Orders;
import top.bcoder.rocketmq.producer.dao.OrdersMapper;
import top.bcoder.rocketmq.producer.service.OrdersService;

@Slf4j
@Service
@RocketMQTransactionListener(txProducerGroup = "send-order")
public class TransactionListenerImpl implements RocketMQLocalTransactionListener {

    private final OrdersService ordersService;

    @Autowired
    public TransactionListenerImpl(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message msg, Object arg) {
        try {
            log.info("消息发送成功执行本地事务");
            String jsonString = new String((byte[]) msg.getPayload());
            Orders orders = JacksonUtils.json2Bean(jsonString, Orders.class);
            log.info("订单创建");
            ordersService.add(orders);
            return RocketMQLocalTransactionState.COMMIT;
        } catch (Exception e) {
            log.error("本地事务执行失败");
            e.printStackTrace();
            return RocketMQLocalTransactionState.ROLLBACK;
        }
    }
    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message msg) {
        log.info("检查事务执行状态");
        return RocketMQLocalTransactionState.COMMIT;
    }
}