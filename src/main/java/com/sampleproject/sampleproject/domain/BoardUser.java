package com.sampleproject.sampleproject.domain;

import lombok.Getter;
import javax.persistence.*;

import com.sampleproject.sampleproject.dto.UserForm;

/* 
Entity를 붙임으로써 JPA의 entity로 등록한다.
예약어를 사용할 경우에는 `` 를 붙여서 사용하면 된다고 한다. @Column(name="`user`") 
*/
@Entity
@Getter // 롬복의 기능, 필드들의 Getter를 생성해준다.
public class BoardUser {
    
    // default 생성자는 JPA가 필요로 하기 떄문에 만들어 놓아야 함
    public BoardUser(){}
    public BoardUser(UserForm userForm) {
        this.email = userForm.getEmail();
        this.userName = userForm.getUserName();
        this.password = userForm.getPassword();
    }
    // 정적 팩토리 메소드를 통해 생성자를 호출한다.
    public static BoardUser createUser(UserForm userForm) {
        return new BoardUser(userForm);
    }

    @Id // 해당 컬럼이 pk라는 것을 의미한다. 모든 엔티티에 반드시 id가 지정되어 있어야 한다.
    @GeneratedValue(strategy = GenerationType.AUTO) // pk를 어떤 전략으로 생성할 것인지 설정, AUTO는 특정 DB에 맞게 자동으로 생성
    @Column(name = "user_id") // DB 컬럼으로 등록
    private Long id;
    
    @Column(length = 50, nullable = false)
    private String email;

    @Column(length = 50, nullable = false)
    private String userName;

    @Column(length = 50, nullable = false)
    private String password;
}
