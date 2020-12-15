package com.sampleproject.sampleproject.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice // @Controller에서 발생할 수 있는 예외를 잡아 처리
@ResponseBody
public class GlobalException {
    // ExceptionHandler로 등록된 예외만 처리된다.
    @ExceptionHandler(DuplicateEmailException.class)
    public String duplicateEmailException() {
        return ErrorResponse.jsonErrorResponse(400, "중복된 이메일입니다.");
    }
}
