package com.group.moromoroapp.service.notice;

import com.group.moromoroapp.domain.notice.Notice;
import com.group.moromoroapp.domain.notice.NoticeRepository;
import com.group.moromoroapp.dto.notice.NoticeCreateRequest;
import com.group.moromoroapp.dto.notice.NoticeUpdateRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class NoticeService {
    private final NoticeRepository noticeRepository;

    public NoticeService(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }
    @Transactional
    public void saveNotice(NoticeCreateRequest request){
        noticeRepository.save(new Notice(request.getNo_title(),request.getNo_content(), request.getNo_name()));
    }

    public List<Notice> getNotice(long noticeId){
        return noticeRepository.findAllByNoticeId(noticeId);
    }
    @Transactional
    public void updateNotice(NoticeUpdateRequest request){
        System.out.println(request.getNoticeId());
        Notice notice = noticeRepository.findByNoticeId(request.getNoticeId())
                .orElseThrow(IllegalArgumentException::new);
        notice.updateNotice(request.getNo_title(),request.getNo_content(), request.getNo_name());
    }

    public void noticeDelete(long noticeId){
        Notice notice = noticeRepository.findByNoticeId(noticeId)
                .orElseThrow(IllegalArgumentException::new);

        noticeRepository.delete(notice);
    }


}
