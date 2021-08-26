package com.springlegacy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InitController {

    Logger Log = LoggerFactory.getLogger(InitController.class);

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String initView(){
        Log.info("initView()");
        return "redirect:login.do";
    }

    @RequestMapping(value = "/hello.do",method = RequestMethod.GET)
    public String helloView(){return "hello";}

}
