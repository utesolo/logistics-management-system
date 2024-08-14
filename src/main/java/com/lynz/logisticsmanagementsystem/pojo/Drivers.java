package com.lynz.logisticsmanagementsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
// 司机表
public class Drivers {
    private int driverId;
    private String driverName; // 姓名
    private String driverPhone; // 电话
    private String licenseNo; // 驾驶证号码
    private String createTime; // 创建时间
}
