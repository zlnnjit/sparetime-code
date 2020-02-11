/*
 * Copyright © 2019 fnii and others.  All rights reserved.
 */

package top.bcoder.algorithm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zln
 * @date 2019/7/23
 */
@SpringBootApplication
@ComponentScan("top.bcoder")
public class AlgorithmApplication {
    public static void main(String[] args) {
        SpringApplication.run(AlgorithmApplication.class, args);
    }

}
