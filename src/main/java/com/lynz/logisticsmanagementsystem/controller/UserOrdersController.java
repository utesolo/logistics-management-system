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
    public List<LogOrder> getlogisticsinfo(@RequestParam int userId) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        List<LogOrder> logOrders = new ArrayList<>();
        List<Logisticsinfos> logisticsinfosList = logisticsinfosServiceImpl.getLogisticsinfosById(userId);
        LOGGER.info("\n"+logisticsinfosList.toString());

        for (Logisticsinfos logisticsinfos : logisticsinfosList) {
            LOGGER.info("\n"+logisticsinfos.getLogisticsId());
            Orders orders = ordersServiceImpl.getOrderByLogId(logisticsinfos.getLogisticsId());
            LOGGER.info("\n"+orders.toString());
            LogOrder logOrder = new LogOrder();
            logOrder.setOrderId(orders.getOrderId());
            logOrder.setLogId(logisticsinfos.getLogisticsId());
            logOrder.setSenderName(logisticsinfos.getSenderName());
            logOrder.setReceiverName(logisticsinfos.getReceiverName());
            logOrder.setSenderAddress(logisticsinfos.getSenderAddress());
            logOrder.setReceiverAddress(logisticsinfos.getReceiverAddress());
            logOrder.setStatus(logisticsinfos.getStatus());
            logOrder.setCreateTime(logisticsinfos.getCreatedTime());
            logOrder.setUpdateTime(sdf.format(date));
            logOrder.setDriverName(driverService.getDrivers(orders.getDriverId()).getDriverName());
            logOrder.setShipTime(orders.getShipTime());
            logOrder.setExpTime(orders.getExpectedTime());
            logOrder.setActTime(orders.getActualTime());
            logOrder.setRemark(orders.getRemarks());

            logOrders.add(logOrder);
        }

        return logOrders;
    }

    @GetMapping("/order/userorders")
    public ModelAndView userOrders() {
        return new ModelAndView("order/userorders");
    }

}
