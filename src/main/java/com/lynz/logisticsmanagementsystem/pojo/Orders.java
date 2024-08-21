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

public class Orders {
    /**
     * 物流表单id
     */
    private int orderId;
    /**
     * 用户ID
     */
    private int userId;
    /**
     * 物流信息id
     */
    private int logisticsId;
    /**
     * 司机id
     */
    private int driverId;
    /**
     * 发货时间
     */
    private String shipTime;
    /**
     * 预计到达时间
     */
    private String expectedTime;
    /**
     * 实际到达时间
     */
    private String actualTime;
    /**
     * 备注
     */
    private String remarks;

}
