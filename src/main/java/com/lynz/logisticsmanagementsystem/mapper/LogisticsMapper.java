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

    /**
     * 物流单分页
     * @param id 用户ID
     * @param limit 偏移量
     * @param offset 分页大小
     * @return 分页物流单
     */
    List<Logisticsinfos> getLogisticsinfosByIdLimit(int id, int limit, int offset);

    /**
     * 获取总数
     * @param userId 用户ID
     * @return 物流单总数
     */
    int getTotalLogisticsInfosCount(int userId);
}
