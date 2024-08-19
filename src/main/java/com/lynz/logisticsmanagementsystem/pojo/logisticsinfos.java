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

// 物流信息表
public class logisticsinfos {
    // 物流信息id
    private int logisticsId;
    // 发货人姓名
    private String senderName;
    // 发货人地址
    private String senderAddress;
    // 收货人姓名
    private String receiverName;
    // 收货人地址
    private String receiverAddress;
    // 物流状态 0发货，1运输，2签收
    private String status;
    // 创建时间
    private String createdTime;
    // 更新时间
    private String updatedTime;
}
