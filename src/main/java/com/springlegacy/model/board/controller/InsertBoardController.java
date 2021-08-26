package com.springlegacy.model.board.controller;

import com.springlegacy.model.board.BoardVO;
import com.springlegacy.model.board.repository.BoardDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertBoardController implements Controller {

    Logger Log = LoggerFactory.getLogger(InsertBoardController.class);

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        Log.info("@ 글 등록 처리");

        String title = httpServletRequest.getParameter("title");
        String writer = (String)httpServletRequest.getSession().getAttribute("user");
        String content = httpServletRequest.getParameter("content");
        Log.info("@ title: {} , writer: {}, content: {}", title, writer, content);

        // DB 연동
        BoardVO vo = BoardVO.builder().title(title).writer(writer).content(content).build();
        BoardDAO boardDAO = new BoardDAO();
        boardDAO.insertBoard(vo);

        ModelAndView mav = new ModelAndView();
        mav.setViewName("getBoardList");
        return mav;
    }
}
