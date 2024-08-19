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

// 公告

public class announcements {
    private int announcementId;
    private String title;
    private String content;
    private String startTime;
    private String endTime;
    private int targetGroup;
    private String status;
    private String createTime;
    private String updateTime;
}
