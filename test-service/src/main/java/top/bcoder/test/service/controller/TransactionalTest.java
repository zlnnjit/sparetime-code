package top.bcoder.test.service.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.bcoder.test.service.bean.User;
import top.bcoder.test.service.bean.UserRole;
import top.bcoder.test.service.service.UserRoleService;
import top.bcoder.test.service.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionalTest {
    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private UserService userService;

    /**
     * 测试 PROPAGATION_REQUIRED
     */
    @Test
    //@Transactional
    public void test_PROPAGATION_REQUIRED() {
        // 增加用户表
        User user = new User();
        user.setName("用户A");
        user.setPassword("123456");
        userService.add(user);
        // 增加用户角色表
        UserRole userRole = new UserRole();
        userRole.setUserId(user.getId());
        userRole.setRoleId(200);
        userRoleService.add(userRole);
        //抛异常
        throw new RuntimeException();
    }
}

