package com.lynz.logisticsmanagementsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

// 车辆表
public class Vehicles {
    private int vehicleId; // 车辆id
    private String plateNo; // 车牌号
    private String type; // 车辆类型
    private int status; // 车辆状态 0发车，1在库，2维修
    private String createTime; // 创建时间
    private String updateTime; // 更新时间
}
