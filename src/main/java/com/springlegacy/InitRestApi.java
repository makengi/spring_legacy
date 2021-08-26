package com.springlegacy;

import com.springlegacy.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class InitRestApi {

    @RequestMapping(value = "/helloApi", method = RequestMethod.GET)
    public Message greet(){
        return new Message("hello");
    }
}
