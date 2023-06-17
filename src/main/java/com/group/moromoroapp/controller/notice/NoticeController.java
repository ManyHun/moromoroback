package com.group.moromoroapp.controller.notice;

import com.group.moromoroapp.domain.notice.Notice;
import com.group.moromoroapp.dto.notice.NoticeCreateRequest;
import com.group.moromoroapp.dto.notice.NoticeUpdateRequest;
import com.group.moromoroapp.service.notice.NoticeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://192.168.110.22:8080/")
public class NoticeController {
    private final NoticeService noticeService;

    public NoticeController(NoticeService noticeService){
        this.noticeService = noticeService;
    }

    @PostMapping("/notice")
    public void saveNotice(@RequestBody NoticeCreateRequest request){
        noticeService.saveNotice(request);
    }

    @GetMapping("/notice")
    public List<Notice> getNotice(@RequestParam Long noticeId){
        return noticeService.getNotice(noticeId);
    }

    @PutMapping("/noticeUpdate")
    public void updateNotice(@RequestBody NoticeUpdateRequest request){
        noticeService.updateNotice(request);
    }

    @DeleteMapping("/noticeDelete")
    public void noticeDelete(@RequestParam Long noticeId){
        noticeService.noticeDelete(noticeId);
    }

}
