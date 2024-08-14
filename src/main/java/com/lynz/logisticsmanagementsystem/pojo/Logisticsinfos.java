package com.lynz.logisticsmanagementsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

// 物流信息表
public class Logisticsinfos {
    private int logisticsId; // 物流信息id
    private String senderName; // 发货人姓名
    private String senderAddress; // 发货人地址
    private String receiverName; // 收货人姓名
    private String receiverAddress; // 收货人地址
    private String status; // 物流状态 0发货，1运输，2签收
    private String createdTime; // 创建时间
    private String updatedTime; // 更新时间
}
