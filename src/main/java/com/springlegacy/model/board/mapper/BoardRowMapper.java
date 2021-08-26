package com.springlegacy.model.board.mapper;

import com.springlegacy.model.board.BoardVO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class BoardRowMapper implements RowMapper<BoardVO> {

    @Override
    public BoardVO mapRow(ResultSet resultSet, int i) throws SQLException {
        BoardVO board = BoardVO.builder().seq(resultSet.getInt("SEQ"))
                .title(resultSet.getString("TITLE"))
                .writer(resultSet.getString("WRITER"))
                .content(resultSet.getString("CONTENT"))
                .regDate(resultSet.getDate("REGDATE"))
                .cnt(resultSet.getInt("CNT"))
                .build();
        return board;
    }
}
