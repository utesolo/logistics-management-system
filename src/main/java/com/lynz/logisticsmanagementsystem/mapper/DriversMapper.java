package com.lynz.logisticsmanagementsystem.mapper;

import com.lynz.logisticsmanagementsystem.pojo.Drivers;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author lynz
 */
@Mapper
@Repository
public interface DriversMapper {
    Drivers getDrivers(int userId);
}
