package com.lynz.logisticsmanagementsystem.service.serviceimpl;

import com.lynz.logisticsmanagementsystem.mapper.OrdersMapper;
import com.lynz.logisticsmanagementsystem.pojo.Orders;
import com.lynz.logisticsmanagementsystem.service.OrdersService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author lynz
 */
@Service
public class OrdersServiceImpl implements OrdersService {
    @Resource
    OrdersMapper ordersMapper;

    @Override
    public Orders getOrderByLogId(int id) {
        return ordersMapper.getOrderByLogId(id);
    }
}
