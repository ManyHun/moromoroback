package com.group.moromoroapp.domain.notice;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
    Optional<Notice> findByNoticeId(long noticeId);

    List<Notice> findAllByNoticeId(long noticeId);
}
