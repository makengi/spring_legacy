package com.springlegacy.model.board.controller.annotaion;

import com.springlegacy.model.board.BoardVO;
import com.springlegacy.model.board.repository.BoardDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {

    Logger Log = LoggerFactory.getLogger(BoardController.class);

    @RequestMapping(value = "/boardForm.do")
    public String getBoardForm(){
        return "boardForm";
    }

    @RequestMapping(value = "/newGetBoard.do")
    public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav){
        mav.addObject("board", boardDAO.getBoard(vo));
        mav.setViewName("getBoard");
        return mav;
    };

    @RequestMapping(value = "/newGetBoardList.do")
    public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav){
        Log.info("@ getBoardList method!");
        mav.addObject("boardList", boardDAO.getBoardList(vo));
        mav.setViewName("getBoardList");
        return mav;
    };

    @RequestMapping(value = "/newInsertBoard.do")
    public String insertBoard(BoardVO vo, BoardDAO boardDAO){
        boardDAO.insertBoard(vo);
        return "redirect:newGetBoardList.do";
    }

    @RequestMapping(value = "/newUpdateBoard.do")
    public String updateBoard(BoardVO vo, BoardDAO boardDAO){
        Log.info("@ update Board method!");
        Log.info("@ boardVo: {} ", vo.toString());
        boardDAO.updateBoard(vo);
        return "redirect:newGetBoardList.do";
    }



}
