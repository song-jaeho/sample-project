package com.sampleproject.sampleproject.repository;

import com.sampleproject.sampleproject.domain.BoardUser;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository를 상속받으면 기본적인 CRUD는 자동 생성되며 메소드 이름으로 쿼리를 만들 수 있다.
// 껍데기만 만들어 놓아도 기본적인 save, find, update, delete를 할 수 있다.
public interface UserRepository extends JpaRepository<BoardUser, Long> {
    // JPA가 메소드 이름을 보고 쿼리를 만들어 준다. 쿼리가 틀렸다면 런타임 에러가 발생한다.
    boolean existsByEmail(String email);
}