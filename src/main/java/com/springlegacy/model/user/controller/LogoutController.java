package com.springlegacy.model.user.controller;

import com.springlegacy.model.board.controller.GetBoardController;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
public class LogoutController {

    private static Logger Log = LoggerFactory.getLogger(LogoutController.class);

    @RequestMapping(value = "/logout.do")
    public String logout(HttpSession httpSession){
        httpSession.invalidate();
        return "login";
    }
}
