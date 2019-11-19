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


}
