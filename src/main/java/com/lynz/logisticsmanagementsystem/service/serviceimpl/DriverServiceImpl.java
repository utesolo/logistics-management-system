package com.lynz.logisticsmanagementsystem.service.serviceimpl;

import com.lynz.logisticsmanagementsystem.mapper.DriversMapper;
import com.lynz.logisticsmanagementsystem.pojo.Drivers;
import com.lynz.logisticsmanagementsystem.service.DriverService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author lynz
 */
@Service
public class DriverServiceImpl implements DriverService {
    @Resource
    DriversMapper driversMapper;

    @Override
    public Drivers getDrivers(int userId) {
        return driversMapper.getDrivers(userId);
    }
}
