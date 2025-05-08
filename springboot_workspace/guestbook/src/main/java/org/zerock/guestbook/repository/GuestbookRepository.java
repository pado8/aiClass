package org.zerock.guestbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.zerock.guestbook.entity.Guestbook;

public interface GuestbookRepository  extends JpaRepository<Guestbook,Long>, QuerydslPredicateExecutor<Guestbook> {
    //1. save(), findById(), deleteById(), FindAll() 등 기본제공 메서드 사용 가능

}
