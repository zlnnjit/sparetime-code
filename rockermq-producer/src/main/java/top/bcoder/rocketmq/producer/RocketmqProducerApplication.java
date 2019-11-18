package top.bcoder.rocketmq.producer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.io.Serializable;
import java.math.BigDecimal;

@Slf4j
@SpringBootApplication
@ComponentScan("top.bcoder")
//@MapperScan("top.bcoder")
public class RocketmqProducerApplication  implements CommandLineRunner {
    @Resource
    private RocketMQTemplate rocketMQTemplate;

    public static void main(String[] args){
        SpringApplication.run(RocketmqProducerApplication.class, args);
    }

    public void run(String... args) throws Exception {
        log.error("===============");
//        rocketMQTemplate.convertAndSend("test-topic-1", "Hello, World!");
//        rocketMQTemplate.send("test-topic-1", MessageBuilder.withPayload("Hello, World! I'm from spring message").build());
//        rocketMQTemplate.convertAndSend("test-topic-2", new OrderPaidEvent("T_001", new BigDecimal("88.00")));

//        rocketMQTemplate.destroy(); // notes:  once rocketMQTemplate be destroyed, you can not send any message again with this rocketMQTemplate
    }

    @Data
    @AllArgsConstructor
    public class OrderPaidEvent implements Serializable {
        private String orderId;

        private BigDecimal paidMoney;
    }
}