package top.bcoder.rocketmq.producer.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RocketMQTransactionListener
public  class TransactionListenerImpl implements RocketMQLocalTransactionListener {
          @Override
          public RocketMQLocalTransactionState executeLocalTransaction(Message msg, Object arg) {
              log.error("executeLocalTransaction....");
            // ... local transaction process, return bollback, commit or unknown
            return RocketMQLocalTransactionState.UNKNOWN;
          }

          @Override
          public RocketMQLocalTransactionState checkLocalTransaction(Message msg) {
              log.error("checkLocalTransaction....");
              // ... check transaction status and return bollback, commit or unknown
            return RocketMQLocalTransactionState.COMMIT;
          }
    }