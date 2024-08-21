package com.lynz.logisticsmanagementsystem.mapper;

import com.lynz.logisticsmanagementsystem.pojo.Logisticsinfos;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lynz
 */
@Mapper
@Repository
public interface LogisticsMapper{
    /**
     * 获取物流单
     * @param id 用户ID
     * @return 物流单
     */
    List<Logisticsinfos> getLogisticsinfosById(int id);
}
