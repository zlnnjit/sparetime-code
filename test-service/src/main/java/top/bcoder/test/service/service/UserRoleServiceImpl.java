package top.bcoder.test.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.bcoder.test.service.bean.UserRole;
import top.bcoder.test.service.dao.UserRoleMapper;

/**
 * @author zln
 * @date 2019/11/17
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleMapper userRoleMapper;

    @Autowired
    public UserRoleServiceImpl( UserRoleMapper userRoleMapper) {
        this.userRoleMapper = userRoleMapper;
    }

    /**
     * 增加用户角色
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public int add(UserRole userRole) {
        //int i = 1 / 0;
        return userRoleMapper.insert(userRole);
    }
}
