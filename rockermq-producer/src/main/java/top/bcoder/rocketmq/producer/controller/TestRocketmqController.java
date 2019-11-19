package top.bcoder.rocketmq.producer.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.bcoder.common.util.util.JacksonUtils;
import top.bcoder.rocketmq.producer.service.RocketmqTestService;

/**
 * @author zln
 * @date 2019/11/18
 */
@RestController
@Slf4j
public class TestRocketmqController {


    private final RocketmqTestService rocketmqTestService;

    private final RocketMQTemplate rocketMQTemplate;

    @Autowired
    public TestRocketmqController(RocketmqTestService rocketmqTestService, RocketMQTemplate rocketMQTemplate) {
        this.rocketmqTestService = rocketmqTestService;
        this.rocketMQTemplate = rocketMQTemplate;
    }


    @GetMapping("/test1")
    public Object testSendMessageBasic() {
        rocketmqTestService.test();
        log.info("rocketMQTemplate:", JacksonUtils.bean2Json(rocketMQTemplate));
        rocketMQTemplate.convertAndSend("test-topic-1", "Hello, World!");
        rocketMQTemplate.send("test-topic-1", MessageBuilder.withPayload("Hello, World! I'm from spring message").build());
        return null;
    }

}
