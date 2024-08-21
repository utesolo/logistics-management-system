package com.lynz.logisticsmanagementsystem.service.serviceimpl;

import com.lynz.logisticsmanagementsystem.mapper.LogisticsMapper;
import com.lynz.logisticsmanagementsystem.pojo.Logisticsinfos;
import com.lynz.logisticsmanagementsystem.service.LogisticsinfosService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lynz
 */
@Service
public class LogisticsinfosServiceImpl implements LogisticsinfosService {
    @Resource
    LogisticsMapper logisticsMapper;

    @Override
    public List<Logisticsinfos> getLogisticsinfosById(int id) {
        return logisticsMapper.getLogisticsinfosById(id);
    }


}
