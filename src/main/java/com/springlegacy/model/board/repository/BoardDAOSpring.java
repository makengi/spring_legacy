package com.springlegacy.model.board.repository;

import ch.qos.logback.core.db.DataSourceConnectionSource;
import com.springlegacy.model.board.BoardVO;
import com.springlegacy.model.board.mapper.BoardRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class BoardDAOSpring extends JdbcDaoSupport {

    private static Logger Log = LoggerFactory.getLogger(BoardDAOSpring.class);
    //Sql Commands
//    private final String BOARD_INSERT = "insert into board(seq,title,writer,content) values((select nvl(max(seq),0)+1 from board),?,?,?)";
        private final String BOARD_INSERT = "insert into board(seq,title,writer,content) values(?,?,?,?)";
    private final String BOARD_UPDATE = "update board set title=?, content=?, where seq=?";
    private final String BOARD_DELETE = "delete from board where seq=?";
    private final String BOARD_GET = "select * from board where seq=?";
    private final String BOARD_LIST = "select * from board order by seq desc";

    @Autowired
    public void setSuperDataSource(DataSource dataSource){
        super.setDataSource(dataSource);
    }

    // Board Crud
    public void insert(BoardVO vo){
        Log.info("@ Spring JDBC insertBoard()");
//        getJdbcTemplate().update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
        getJdbcTemplate().update(BOARD_INSERT,vo.getSeq(),vo.getTitle(), vo.getWriter(), vo.getContent());
    }

    public void update(BoardVO vo){
        Log.info("@ Spring JDBC updateBoard()");
        getJdbcTemplate().update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
    }

    public void delete(BoardVO vo){
        Log.info("@ Spring JDBC delete()");
        getJdbcTemplate().update(BOARD_DELETE, vo.getSeq());
    }

    public BoardVO getBoard(BoardVO vo){
        Log.info("@ Spring jdbc getBoard()");
        Object[] args = {vo.getSeq()};
        return getJdbcTemplate().queryForObject(BOARD_GET, args, new BoardRowMapper());
    }

    public List<BoardVO> getBoardList(BoardVO vo){
        Log.info("@ Spring getBoardList() ");
        return getJdbcTemplate().query(BOARD_LIST, new BoardRowMapper());
    }


}
