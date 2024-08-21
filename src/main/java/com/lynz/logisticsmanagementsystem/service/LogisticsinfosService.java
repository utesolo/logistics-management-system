package com.lynz.logisticsmanagementsystem.service;

import com.lynz.logisticsmanagementsystem.pojo.Logisticsinfos;

import java.util.List;

/**
 * @author lynz
 */
public interface LogisticsinfosService {
    /**
     * 获取物流单<用户单>
     * @param id
     * @return
     */
    List<Logisticsinfos> getLogisticsinfosById(int id);
}
