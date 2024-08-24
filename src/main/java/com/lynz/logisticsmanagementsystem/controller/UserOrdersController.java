package com.lynz.logisticsmanagementsystem.controller;

import com.lynz.logisticsmanagementsystem.pojo.Logisticsinfos;
import com.lynz.logisticsmanagementsystem.pojo.Orders;
import com.lynz.logisticsmanagementsystem.service.DriverService;
import com.lynz.logisticsmanagementsystem.service.serviceimpl.LogisticsinfosServiceImpl;
import com.lynz.logisticsmanagementsystem.service.serviceimpl.OrdersServiceImpl;
import com.lynz.logisticsmanagementsystem.util.LogOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author lynz
 */

@RestController
@SuppressWarnings("all")
public class UserOrdersController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private final LogisticsinfosServiceImpl logisticsinfosServiceImpl;
    private final OrdersServiceImpl ordersServiceImpl;
    private final DriverService driverService;

    @Autowired
    public UserOrdersController(LogisticsinfosServiceImpl logisticsinfosServiceImpl, OrdersServiceImpl ordersServiceImpl, DriverService driverService) {
        this.logisticsinfosServiceImpl = logisticsinfosServiceImpl;
        this.ordersServiceImpl = ordersServiceImpl;
        this.driverService = driverService;
    }

    @GetMapping("/order/getlogisticsinfo")
    public List<LogOrder> getlogisticsinfo(@RequestParam int userId,@RequestParam int limit,@RequestParam int offset) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        List<LogOrder> logOrders = new ArrayList<>();
        List<Logisticsinfos> logisticsinfosList = logisticsinfosServiceImpl.getLogisticsinfosByIdLimit(userId,limit,offset);
        LOGGER.info("\n用户ID："+userId+"\tlimit："+limit+"\toffset："+offset);

        for (Logisticsinfos logisticsinfos : logisticsinfosList) {
            Orders orders = ordersServiceImpl.getOrderByLogId(logisticsinfos.getLogisticsId());

            LogOrder logOrder = new LogOrder();
            logOrder.setOrderId(orders.getOrderId());
            logOrder.setLogId(logisticsinfos.getLogisticsId());
            logOrder.setSenderName(logisticsinfos.getSenderName());
            logOrder.setReceiverName(logisticsinfos.getReceiverName());
            logOrder.setSenderAddress(logisticsinfos.getSenderAddress());
            logOrder.setReceiverAddress(logisticsinfos.getReceiverAddress());
            logOrder.setStatus(logisticsinfos.getStatus());
            logOrder.setCreateTime(logisticsinfos.getCreateTime());
            logOrder.setUpdateTime(sdf.format(date));
            logOrder.setDriverName(driverService.getDrivers(orders.getDriverId()).getDriverName());
            logOrder.setShipTime(orders.getShipTime());
            logOrder.setExpTime(orders.getExpectedTime());
            if (orders.getActualTime() == null){
                logOrder.setActTime("未到达");
            }else {
                logOrder.setActTime(orders.getActualTime());
            }
            logOrder.setRemark(orders.getRemarks());
            LOGGER.info("\n"+logOrder.toString());
            logOrders.add(logOrder);
        }

        return logOrders;
    }

    @GetMapping("/order/getTotalPages")
    public int getTotalPages(@RequestParam int userId, @RequestParam int limit) {
        // 计算总页数
        int totalRecords = logisticsinfosServiceImpl.getTotalLogisticsInfosCount(userId);
        LOGGER.info("\n总订单数："+String.valueOf(totalRecords)+"\t总页数"+Math.ceil((double) totalRecords / limit));
        return (int) Math.ceil((double) totalRecords / limit);

    }

    @GetMapping("/order/userorders")
    public ModelAndView userOrders() {
        return new ModelAndView("userOrders");
    }

}
