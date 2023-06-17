package com.group.moromoroapp.dto.notice;

import lombok.Getter;

@Getter
public class NoticeUpdateRequest {
    private Long noticeId;
    private String no_title;
    private String no_content;
    private String no_name;
}
