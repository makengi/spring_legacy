package com.springlegacy.model.board.controller;

import com.springlegacy.model.board.BoardVO;
import com.springlegacy.model.board.repository.BoardDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteBoardController implements Controller {
    Logger Log = LoggerFactory.getLogger(UpdateBoardController.class);

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        Log.info("@ 글삭제 처리");

        String seq = httpServletRequest.getParameter("seq");

        BoardVO vo = BoardVO.builder().seq(Integer.parseInt(seq)).build();

        BoardDAO boardDAO = new BoardDAO();
        boardDAO.deleteBoard(vo);

        ModelAndView mav = new ModelAndView();
        mav.setViewName("getBoardList.do");
        return mav;
    }
}
