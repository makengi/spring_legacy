package com.springlegacy.model.board.impl;

import com.springlegacy.model.board.BoardVO;
import com.springlegacy.model.board.repository.BoardDAOSpring;
import com.springlegacy.model.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

    private BoardDAOSpring boardDAO;

    @Autowired
    public BoardServiceImpl(BoardDAOSpring boardDAO){
        this.boardDAO = boardDAO;
    }

    @Override
    public void insertBoard(BoardVO vo) {
        boardDAO.insert(vo);
        boardDAO.insert(vo);
    }

    @Override
    public void updateBoard(BoardVO vo) {
        boardDAO.update(vo);
    }

    @Override
    public void deleteBoard(BoardVO vo) {
        boardDAO.delete(vo);
    }

    @Override
    public BoardVO getBoard(BoardVO vo) {
        return boardDAO.getBoard(vo);
    }

    @Override
    public List<BoardVO> getBoardList(BoardVO vo) {
        return boardDAO.getBoardList(vo);
    }
}
