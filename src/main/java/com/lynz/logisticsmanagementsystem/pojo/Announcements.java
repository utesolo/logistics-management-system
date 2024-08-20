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


public class Announcements {
    /** 公告id*/
    private int announcementId;
    /** 标题*/
    private String title;
    /** 内容*/
    private String content;
    /** 开始时间*/
    private String startTime;
    /** 结束时间*/
    private String endTime;
    /** 用户群体：0管理员，1用户，2司机*/
    private int targetGroup;
    /** 状态*/
    private String status;
    /** 创建时间*/
    private String createTime;
    /** 更新时间*/
    private String updateTime;
}
