/*
 * Copyright © 2019 fnii and others.  All rights reserved.
 */

package top.bcoder.test.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zln
 * @date 2019/7/23
 */
@SpringBootApplication
@ComponentScan("top.bcoder")
@MapperScan("top.bcoder.service1.dao")
public class TestServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestServiceApplication.class, args);
    }

}
