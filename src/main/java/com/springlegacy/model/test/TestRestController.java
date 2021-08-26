package com.springlegacy.model.test;

import com.springlegacy.model.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {


    @GetMapping(value = "/test/test.do")
    public Message test(){
        return new Message("hello jiyoung");
    }
}
