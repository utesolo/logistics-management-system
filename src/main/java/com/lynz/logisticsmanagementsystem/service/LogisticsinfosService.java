package com.lynz.logisticsmanagementsystem.service;

import com.lynz.logisticsmanagementsystem.pojo.Logisticsinfos;

import java.util.List;

/**
 * @author lynz
 */
public interface LogisticsinfosService {
    /**
     * 获取物流单<用户单>
     * @param id 用户ID
     * @return 用户物流单
     */
    List<Logisticsinfos> getLogisticsinfosById(int id);

    /**
     * 分页模式
     * @param id 用户ID
     * @param limit 分页起始，偏移量
     * @param offset 分页量
     * @return 分页后的参数
     */
    List<Logisticsinfos> getLogisticsinfosByIdLimit(int id, int limit, int offset);

    /**
     * 获取
     * @param userId 用户ID
     * @return 分页总量
     */
    int getTotalLogisticsInfosCount(int userId);

}
