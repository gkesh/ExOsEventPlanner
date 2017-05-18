/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pck.eventplanner.jdbe;

import com.pck.eventplanner.dao.UserDao;
import com.pck.eventplanner.entity.Users;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author G-Kesh
 */
public class UserDBMethods implements UserDao {

    public static String[][] retArray(String str) {
        String[] arr = str.split("\n");
        String[][] res = new String[arr.length][10];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i].split(",");
        }
        return res;
    }
    public static List<String> retList(String str) {
        List<String> res = Arrays.asList(str.split(","));
        return res;
    }

    @Override
    public Boolean addUser(Users usr) {
        try {
            DatabaseConnection con = new DatabaseConnection();
            con.openConnection();
            String sql = "INSERT INTO tbl_user (first_name, last_name, username, password, email_add, phone_number, free_slot, busy_slot, undecided_slot, event_planner, added_date) values (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = con.initComp(sql);

            stmt.setString(1, usr.getFirst_name());
            stmt.setString(2, usr.getLast_name());
            stmt.setString(3, usr.getUsername());
            stmt.setString(4, usr.getPassword());
            stmt.setString(5, usr.getEmail_add());
            stmt.setString(6, usr.getPhone_no());
            stmt.setString(7, usr.retString(usr.getFree_slot()));
            stmt.setString(8, usr.retString(usr.getBusy_slot()));
            stmt.setString(9, usr.retString(usr.getUndecided_slot()));
            stmt.setString(10, usr.getEvent_planner());
            stmt.setTimestamp(11, usr.getAdded_date());

            int res = con.execute();
            return res > 0;
        } catch (ClassNotFoundException | SQLException exp) {
            System.out.println(exp.getMessage());
        }
        return false;
    }

    @Override
    public Boolean editProfile(Users usr) {
        try {
            DatabaseConnection con = new DatabaseConnection();
            con.openConnection();
            String sql = "Update tbl_user SET first_name = ?, last_name = ?, username = ?, password = ?, email_add = ?, phone_number = ?, free_slot = ?, busy_slot = ?, undecided_slot = ?, event_planner = ?, modified_date = ?, notification = ? where user_id = ?";
            PreparedStatement stmt = con.initComp(sql);

            stmt.setString(1, usr.getFirst_name());
            stmt.setString(2, usr.getLast_name());
            stmt.setString(3, usr.getUsername());
            stmt.setString(4, usr.getPassword());
            stmt.setString(5, usr.getEmail_add());
            stmt.setString(6, usr.getPhone_no());
            stmt.setString(7, usr.retString(usr.getFree_slot()));
            stmt.setString(8, usr.retString(usr.getBusy_slot()));
            stmt.setString(9, usr.retString(usr.getUndecided_slot()));
            stmt.setString(10, usr.getEvent_planner());
            stmt.setDate(11, usr.getModified_date());
            stmt.setString(12, usr.getNotification());
            stmt.setInt(13, usr.getId());
           
            int res = con.execute();
            return res > 0;
        } catch (ClassNotFoundException | SQLException exp) {
            System.out.println(exp.getMessage());
        }
        return false;
    }

    @Override
    public Boolean removeUser(Users usr) {
        try {
            DatabaseConnection con = new DatabaseConnection();

            con.openConnection();
            String sql = "DELETE FROM tbl_user where user_id = ?";
            PreparedStatement stmt = con.initComp(sql);
            stmt.setInt(1, usr.getId());
            int res = con.execute();
            
            return res > 0;
        } catch (ClassNotFoundException | SQLException sql) {
            System.out.println(sql.getMessage());
        }
        return false;
    }

    @Override
    public List<Users> showAll() {
        List<Users> usrLst = new ArrayList<>();
        try {
            DatabaseConnection con = new DatabaseConnection();
            con.openConnection();
            String sql = "Select * from tbl_user";
            con.initComp(sql);

            ResultSet rs = con.executeQuery();
            while (rs.next()) {
                Users usr = new Users();
                usr.setId(rs.getInt("user_id"));
                usr.setFirst_name(rs.getString("first_name"));
                usr.setLast_name(rs.getString("last_name"));
                usr.setUsername(rs.getString("username"));
                usr.setPassword(rs.getString("password"));
                usr.setEmail_add(rs.getString("email_add"));
                usr.setPhone_no(rs.getString("phone_number"));
                usr.setFree_slot(retArray(rs.getString("free_slot")));
                usr.setBusy_slot(retArray(rs.getString("busy_slot")));
                usr.setUndecided_slot(retArray(rs.getString("undecided_slot")));
                if(rs.getString("event_planner")!=null){
                    usr.setEvent_planner(rs.getString("event_planner"));
                }
                if(rs.getString("notification")!= null){
                    usr.setNotification(rs.getString("notification"));
                }
                if(rs.getString("event_planner")!=null){
                    usr.setEvent_planner(rs.getString("event_planner"));
                }
                usr.setAdded_date(rs.getTimestamp("added_date"));
                usrLst.add(usr);
            }
        } catch (ClassNotFoundException | SQLException sql) {
            System.out.println(sql.getMessage());
        }

        return usrLst;
    }

}
