package com.springlegacy.model.user.repository;



import com.springlegacy.common.JDBCUtil;
import com.springlegacy.model.user.UserVO;
import org.h2.engine.User;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Repository(value = "userDAO")
public class UserDAO {
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    private final String USER_GET = "select * from user where id=? and password=?";

    public UserVO get(UserVO vo){
        UserVO user = null;
        try{
            System.out.println("@ JDBC Get User() ");
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(USER_GET);
            stmt.setString(1, vo.getId());
            stmt.setString(2, vo.getPassword());
            rs = stmt.executeQuery();
            if(rs.next()){
                user = UserVO.builder().id(rs.getString("ID"))
                        .password(rs.getString("PASSWORD"))
                        .name(rs.getString("NAME"))
                        .role(rs.getString("ROLE")).build();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(stmt,conn);
        }
        return user;
    }
}
