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

// 运货单信息表
public class orders {
    // 物流单id
    private int orderId;
    // 物流信息id
    private int logisticsId;
    // 司机id
    private int driverId;
    // 发货时间
    private String shipTime;
    // 预计到达时间
    private String expectedTime;
    // 实际到达时间
    private String actualTime;
    // 备注
    private String remarks;

}
