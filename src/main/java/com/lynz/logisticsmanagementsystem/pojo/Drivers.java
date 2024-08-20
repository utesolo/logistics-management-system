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

public class Drivers {
    /**
     * 司机id
     */
    private int driverId;
    /**
     * 司机名字
     */
    private String driverName;
    /**
     * 电话
     */
    private String driverPhone;
    /**
     * 驾驶证号码
     */
    private String licenseNo;
    /**
     * 创建时间
     */
    private String createTime;
}
