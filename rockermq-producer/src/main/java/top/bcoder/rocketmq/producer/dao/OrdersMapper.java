package top.bcoder.rocketmq.producer.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import top.bcoder.rocketmq.producer.bean.Orders;

/**
 * @author zln
 * @date 2019/11/19
 */
@Repository
public interface OrdersMapper extends BaseMapper<Orders> {
}
