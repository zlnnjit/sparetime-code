package top.bcoder.test.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.bcoder.test.service.bean.User;
import top.bcoder.test.service.dao.UserMapper;

/**
 * @author zln
 * @date 2019/11/17
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;


    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public int add(User user) {
        return userMapper.insert(user);
    }
}
