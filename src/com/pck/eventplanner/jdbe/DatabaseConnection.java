/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pck.eventplanner.jdbe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author G-Kesh
 */
public class DatabaseConnection {
   private Connection con;
   private PreparedStatement st; 
    public void openConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/socialtime", "root", "");
    }
    public PreparedStatement initComp(String sql) throws SQLException{
        st = con.prepareStatement(sql);
        return st;
    }
    public int execute() throws SQLException{
        return st.executeUpdate();
    }
    public ResultSet executeQuery() throws SQLException{
        return st.executeQuery();
    }
    public void closeConnection() throws SQLException{
        if(con!=null && !con.isClosed()){
            con=null;
            con.close();
        }
    }
}
