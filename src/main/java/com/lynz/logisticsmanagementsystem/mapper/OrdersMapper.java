package com.lynz.logisticsmanagementsystem.mapper;

import com.lynz.logisticsmanagementsystem.pojo.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author lynz
 */

@Mapper
@Repository
public interface OrdersMapper {
    /**
     * 获取物流运输情况
     * @param id 用户ID
     * @return 物流运输情况
     */
    Orders getOrderByLogId(int id);
}
