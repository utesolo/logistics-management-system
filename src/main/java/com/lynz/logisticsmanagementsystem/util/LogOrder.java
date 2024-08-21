package com.lynz.logisticsmanagementsystem.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lynz
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogOrder {
    private int logId;
    private int orderId;
    private String senderName;
    private String receiverName;
    private String senderAddress;
    private String receiverAddress;
    private int status;
    private String createTime;
    private String updateTime;
    private String driverName;
    private String shipTime;
    private String expTime;
    private String actTime;
    private String remark;
}
