package com.sampleproject.sampleproject.dto;

// Spring Boot 2.3 이전 버전에는 spring web starter에 있었지만
// 현재 프로젝트는 2.4.1 이기 때문에 구글링해서 build.gradle에 넣었다.
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserForm {
    
    @NotEmpty(message = "이메일은 필수입니다.")
    @Size(max = 100, message = "이메일은 100자리를 초과할 수 없습니다.")
    private String email;

    @NotEmpty(message = "이름은 필수입니다.")
    @Size(max = 20, message = "이름은 20자리를 초과할 수 없습니다.")
    private String userName;

    @NotEmpty(message = "비밀번호는 필수입니다.")
    @Size(max = 100, message = "비밀번호는 100자리를 초과할 수 없습니다.")
    private String password;
}
