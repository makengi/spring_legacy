package com.springlegacy.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;

import static java.util.Objects.nonNull;

public class JDBCUtil {
    public static Connection getConnection(){
        try{
            Class.forName("org.h2.Driver");
            return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
        }catch (Exception e){
            e.printStackTrace();

        }
        return null;
    }

    public static void close(PreparedStatement stmt, Connection conn){
        if(nonNull(stmt)){
            try{
                if(!stmt.isClosed()) stmt.close();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                stmt = null;
            }
        }

        if(nonNull(conn)){
            try{
                if(!conn.isClosed()) conn.close();

            }catch (Exception e){
                e.printStackTrace();
            }finally {
                conn = null;
            }
        }
    }

    public static void close(ResultSet rs, PreparedStatement stmt, Connection connection){
        if(nonNull(rs)){
            try{
                if(!rs.isClosed()) rs.close();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                rs = null;
            }
        }
        if(nonNull(stmt)){
            try {
                if (!stmt.isClosed()) stmt.close();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                stmt = null;
            }
        }
        if(nonNull(connection)){
            try {
                if (!connection.isClosed()) connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                connection = null;
            }
        }
}
}
