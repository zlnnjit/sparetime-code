package top.bcoder.rocketmq.producer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("top.bcoder")
@MapperScan("top.bcoder.server.dao")
public class RocketmqProducerApplication {
    public static void main(String[] args) {
        SpringApplication.run(RocketmqProducerApplication.class, args);
    }
}
