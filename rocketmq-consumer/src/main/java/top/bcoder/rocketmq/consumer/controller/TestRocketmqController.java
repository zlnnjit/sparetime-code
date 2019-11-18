package top.bcoder.rocketmq.consumer.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.bcoder.common.util.util.JacksonUtils;
import top.bcoder.rocketmq.consumer.bean.User;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author zln
 * @date 2019/11/18
 */
@RestController
@Slf4j
public class TestRocketmqController {

    private final RocketMQTemplate rocketMQTemplate;

    @Autowired
    public TestRocketmqController(RocketMQTemplate rocketMQTemplate) {
        this.rocketMQTemplate = rocketMQTemplate;
    }

    @GetMapping(name = "/test1")
    public Object testSendMessageBasic(@RequestParam String content) {
        log.info("rocketMQTemplate:", JacksonUtils.bean2Json(rocketMQTemplate));
        rocketMQTemplate.convertAndSend("test-topic-1", "Hello, World!");
        rocketMQTemplate.send("test-topic-1", MessageBuilder.withPayload("Hello, World! I'm from spring message").build());
        List<User> users = Lists.newArrayList();
        users.add(User.builder().age(11).name("同学A").content("我是同学A").build());
        users.add(User.builder().age(11).name("同学B").content("我是同学B").build());
        users.add(User.builder().age(11).name("同学C").content("我是同学C").build());
        rocketMQTemplate.convertAndSend("test-topic-2", users);
        return null;
    }

}
