package com.lynz.logisticsmanagementsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

// 运货单信息表
public class Orders {
    private int orderId; // 物流单id
    private int logisticsId; // 物流信息id
    private int driverId; // 司机id
    private String shipTime; // 发货时间
    private String expectedTime; // 预计到达时间
    private String actualTime; // 实际到达时间
    private String remarks; // 备注

}
