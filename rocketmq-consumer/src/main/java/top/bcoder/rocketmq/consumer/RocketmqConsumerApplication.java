package top.bcoder.rocketmq.consumer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("top.bcoder")
@MapperScan("top.bcoder.")
public class RocketmqConsumerApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(RocketmqConsumerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
