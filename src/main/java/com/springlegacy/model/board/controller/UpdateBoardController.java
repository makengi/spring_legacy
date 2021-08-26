package com.springlegacy.model.board.controller;

import com.springlegacy.model.board.BoardVO;
import com.springlegacy.model.board.repository.BoardDAO;
import org.h2.command.dml.Update;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;

public class UpdateBoardController implements Controller {

    Logger Log = LoggerFactory.getLogger(UpdateBoardController.class);

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        Log.info("@ 글 수정 처리");

        String title = httpServletRequest.getParameter("title");
        String content = httpServletRequest.getParameter("content");
        String seq = httpServletRequest.getParameter("seq");

        // Db 연동
        BoardVO vo = BoardVO.builder().title(title).content(content).seq(Integer.parseInt(seq)).build();
        BoardDAO boardDAO = new BoardDAO();
        boardDAO.updateBoard(vo);

        ModelAndView mav = new ModelAndView();
        mav.setViewName("getBoardList.do");
        return mav;
    }

}
