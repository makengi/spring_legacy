package com.springlegacy.model.user.controller;

import com.springlegacy.model.user.UserVO;
import com.springlegacy.model.user.repository.UserDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static java.util.Objects.nonNull;

@Controller
public class LoginController {

    private static Logger Log = LoggerFactory.getLogger(LoginController.class);
    private UserDAO userDAO;
    @Autowired
    public LoginController(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    @RequestMapping(value = "/login.do", method = RequestMethod.GET)
    public String loginView(UserVO vo){
        Log.info("@ 로그인 화면으로 이동!");
        return "login";
    }

    @RequestMapping(value = "/login.do",method = RequestMethod.POST)
    public String login(UserVO vo, HttpSession httpSession){
        Log.info("@ 로그인 인증 처리");
        UserVO user = userDAO.get(vo);
        if(nonNull(user)){
            Log.info("@ user.name: {}", user.getId());
            httpSession.setAttribute("userName", user.getId());
            return "getBoardList";
        } else {
            return "login";
        }
    }
}
