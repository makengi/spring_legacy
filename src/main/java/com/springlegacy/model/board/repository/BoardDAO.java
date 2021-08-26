package com.springlegacy.model.board.repository;

import com.springlegacy.common.JDBCUtil;
import com.springlegacy.model.board.BoardVO;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository("boardDAO")
public class BoardDAO {
    private Connection conn = null;
    private PreparedStatement stmt= null;
    private ResultSet rs = null;

    //Sql Commands
    private final String BOARD_INSERT = "insert into board(seq,title,writer,content) values((select nvl(max(seq),0)+1 from board),?,?,?)";
    private final String BOARD_UPDATE = "update board set title=?, content=? where seq=?";
    private final String BOARD_DELETE = "delete from board where seq=?";
    private final String BOARD_GET = "select * from board where seq=?";
    private final String BOARD_LIST = "select * from board order by seq desc";

    //write board
    public void insertBoard(BoardVO vo){
        System.out.println("@ JDBC insertBoard()");
        try{
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_INSERT);
            stmt.setString(1, vo.getTitle());
            stmt.setString(2,vo.getWriter());
            stmt.setString(3, vo.getContent());
            stmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(stmt,conn);
        }
    }
    public void updateBoard(BoardVO vo){
        System.out.println("@ JDBC updateBoard()");
        try{
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_UPDATE);
            stmt.setString(1, vo.getTitle());
            stmt.setString(2, vo.getContent());
            stmt.setInt(3, vo.getSeq());
            stmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(stmt,conn);
        }
    }

    public void deleteBoard(BoardVO vo){
        System.out.println("@ JDBC DeleteBoard()");
        try{
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_DELETE);
            stmt.setInt(1, vo.getSeq());
            stmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(stmt,conn);
        }
    }
    public BoardVO getBoard(BoardVO vo){
        System.out.println("@ JDBC getBoard()");
        BoardVO boardVO = null;
        try{
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_GET);
            stmt.setInt(1,vo.getSeq());
            rs = stmt.executeQuery();
            if(rs.next()){
                boardVO = BoardVO.builder().seq(rs.getInt("SEQ"))
                                .title(rs.getString("TITLE"))
                                .writer(rs.getString("WRITER"))
                                .content(rs.getString("CONTENT"))
                                .regDate(rs.getDate("REGDATE"))
                                .cnt(rs.getInt("CNT")).build();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(rs,stmt,conn);
        }
        return boardVO;
    }

    public List<BoardVO> getBoardList(BoardVO vo){
        System.out.println("@ JDBC getBoardList()");
        List<BoardVO> boardVOList = new ArrayList<>();
        BoardVO boardVO = null;
        try{
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_LIST);
            rs = stmt.executeQuery();
            while(rs.next()){
                boardVO = BoardVO.builder().seq(rs.getInt("SEQ"))
                        .title(rs.getString("TITLE"))
                        .writer(rs.getString("WRITER"))
                        .content(rs.getString("CONTENT"))
                        .regDate(rs.getDate("REGDATE"))
                        .cnt(rs.getInt("CNT")).build();
                boardVOList.add(boardVO);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(rs,stmt,conn);
        }
        return boardVOList;
    }
}
