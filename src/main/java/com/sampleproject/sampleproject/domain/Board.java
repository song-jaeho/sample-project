package com.sampleproject.sampleproject.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

// Entity를 붙임으로써 JPA의 entity로 등록한다.
@Entity
// 롬복의 기능, 필드들의 Getter를 생성해준다.
@Getter
public class Board {

    // 해당 컬럼이 pk라는 것을 의미한다. 모든 엔티티에 반드시 id가 지정되어 있어야 한다.
    @Id
    // pk를 어떤 전략으로 생성할 것인지 설정, AUTO는 특정 DB에 맞게 자동으로 생성
    @GeneratedValue(strategy = GenerationType.AUTO)
    // DB 컬럼으로 등록
    @Column(name = "board_id")
    private Long id;
    
    @Column(length = 50, nullable = false)
    private String title;

    // 크기 제한 없도록 설정
    @Lob
    private String content;

    private LocalDateTime createdDate;

    // 유저와의 연관관계 생성
    @ManyToOne(fetch = FetchType.LAZY)
    // Board 스키마에서 user_id를 FK로 들고있게 한다.
    @JoinColumn(name = "user_id")
    private BoardUser user;
}
