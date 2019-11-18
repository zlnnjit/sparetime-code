package top.bcoder.rocketmq.consumer.bean;

import lombok.Builder;
import lombok.Data;

/**
 * @author zln
 * @date 2019/11/18
 */
@Data
@Builder
public class User {
    private Integer age;
    private String name;
    private String content;
}
