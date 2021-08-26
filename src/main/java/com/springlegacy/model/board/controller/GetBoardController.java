package com.springlegacy.model.board.controller;

import com.springlegacy.model.board.BoardVO;
import com.springlegacy.model.board.repository.BoardDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetBoardController implements Controller {

    private static Logger Log = LoggerFactory.getLogger(GetBoardController.class);

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        Log.info("@ 글 상세 조회 처리 ");

        //1. extract board seq for searching
        String seq = httpServletRequest.getParameter("seq");

        //2. DB 연동 처리
        BoardVO vo = BoardVO.builder().seq(Integer.parseInt(seq)).build();


        BoardDAO boardDAO = new BoardDAO();
        BoardVO board = boardDAO.getBoard(vo);

        ModelAndView mav = new ModelAndView();
        mav.addObject("board", board);
        mav.setViewName("getBoard");
        return mav;
    }
}
