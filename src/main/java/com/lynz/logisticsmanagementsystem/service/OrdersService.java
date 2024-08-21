package com.lynz.logisticsmanagementsystem.service;

import com.lynz.logisticsmanagementsystem.pojo.Orders;

/**
 * @author lynz
 */
public interface OrdersService {
    /**
     * 获取物流信息 <运送单>
     * @param id 用户ID
     * @return 物流信息
     */
    Orders getOrderByLogId(int id);
}
