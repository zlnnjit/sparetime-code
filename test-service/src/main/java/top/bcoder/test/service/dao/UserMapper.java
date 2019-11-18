package top.bcoder.test.service.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import top.bcoder.test.service.bean.User;

/**
 * @author zln
 * @date 2019/11/17
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
}
