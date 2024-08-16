package com.lynz.logisticsmanagementsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lynz
 */

@Data
@AllArgsConstructor
@NoArgsConstructor

// 车辆表
public class Vehicles {
    // 车辆id
    private int vehicleId;
    // 车牌号
    private String plateNo;
    // 车辆类型
    private String type;
    // 车辆状态 0发车，1在库，2维修
    private int status;
    // 创建时间
    private String createTime;
    // 更新时间
    private String updateTime;
}
