package com.springlegacy.model.board.service;

import com.springlegacy.model.board.BoardVO;

import java.util.List;

public interface BoardService {

    //Board CRUD
    void insertBoard(BoardVO vo);
    void updateBoard(BoardVO vo);
    void deleteBoard(BoardVO vo);
    BoardVO getBoard(BoardVO vo);
    List<BoardVO> getBoardList(BoardVO vo);
}
