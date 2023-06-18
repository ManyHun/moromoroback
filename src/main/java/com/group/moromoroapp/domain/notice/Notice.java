package com.group.moromoroapp.domain.notice;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noticeId;

    @Column
    private String no_title;

    @Column
    private String no_content;

    @Column
    private LocalDate no_date = LocalDate.now(ZoneId.of("Asia/Seoul"));

    @Column
    private LocalTime no_time = LocalTime.now(ZoneId.of("Asia/Seoul"));

    @Column
    private String no_name;

    public Long getNoticeId(){
        return noticeId;
    }
    public String getNo_title(){
        return no_title;
    }
    public String getNo_content(){
        return no_content;
    }
    public String getNo_name(){
        return no_name;
    }
    public Notice(String no_title,String no_content,String no_name){
        this.no_title = no_title;
        this.no_content = no_content;
        this.no_name = no_name;
    }
    public void updateNotice(String no_title,String no_content, String no_name){
        this.no_title = no_title;
        this.no_content = no_content;
        this.no_name = no_name;
    }

}
