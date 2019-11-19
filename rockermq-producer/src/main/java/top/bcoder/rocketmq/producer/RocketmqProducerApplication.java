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
@MapperScan("top.bcoder.rocketmq.producer.dao")
public class RocketmqProducerApplication{


    public static void main(String[] args){
        SpringApplication.run(RocketmqProducerApplication.class, args);
    }

}