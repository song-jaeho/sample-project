package com.sampleproject.sampleproject.service;

import com.sampleproject.sampleproject.domain.BoardUser;
import com.sampleproject.sampleproject.dto.UserForm;
import com.sampleproject.sampleproject.exception.DuplicateEmailException;
import com.sampleproject.sampleproject.repository.UserRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
// 초기화 되지 않은 final 필드나, @NonNull 이 붙은 필드의 생성자를 생성해 준다.
// 주로 의존성 주입 편의성을 위해서 사용된다.
// @Autowired 없이 의존성 주입이 가능하다.
@RequiredArgsConstructor
public class UserService {
    
    private final UserRepository userRepository;

    @Transactional
    public void signUpUser(UserForm userForm) throws Exception {
        validateDuplicateEmail(userForm.getEmail());
        userRepository.save(BoardUser.createUser(userForm));
    }

    private void validateDuplicateEmail(String email) throws Exception {
        if(userRepository.existsByEmail(email)){
            throw new DuplicateEmailException();
        }
    }
}
