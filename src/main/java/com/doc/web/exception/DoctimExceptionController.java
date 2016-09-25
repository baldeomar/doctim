package com.doc.web.exception;

import com.doc.web.application.PageMapper;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DoctimExceptionController {

    @ExceptionHandler(Exception.class)
    public String getErrorPage(Exception e){
        e.printStackTrace();
        return PageMapper.ERROR;
    }
}
