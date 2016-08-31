package com.doc.web.controller;

import com.doc.web.application.ApplicationUrl;
import com.doc.web.application.PageMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {

    @RequestMapping(value = ApplicationUrl.HOME)
    public String getHeader(){
        return PageMapper.HOME;
    }
}
