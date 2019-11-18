/*
 * Copyright © 2019 fnii and others.  All rights reserved.
 */

package top.bcoder.test.service.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zln
 * @date 2019/11/11
 */
@RestController
@Slf4j
@Api(tags = {"方法测试接口"})
public class TestController {


    @Autowired
    public TestController() {

    }

    @ApiOperation(value = "方法测试接口", notes = "仅用于代码测试")
    @CrossOrigin
    @GetMapping("/test")
    public void listRouters() {

    }
}
