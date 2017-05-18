/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pck.eventplanner.jdbe;

import com.pck.eventplanner.dao.EventDao;
import com.pck.eventplanner.entity.Events;
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
public class EventDBMethods implements EventDao {
   

    @Override
    public Boolean addEvent(Events evt) {
        try {

            DatabaseConnection con = new DatabaseConnection();
            con.openConnection();
            String sql = "INSERT INTO tbl_event (event_name, event_location, event_description, invited_attendes, min_attendees, minthreshold) values (?,?,?,?,?,?)";
            PreparedStatement stmt = con.initComp(sql);

            stmt.setString(1, evt.getName());
            stmt.setString(2, evt.getLocation());
            stmt.setString(3, evt.getDescription());
            stmt.setString(4, evt.getAttendeeString());
            stmt.setInt(5, evt.getMinAttendees());
            stmt.setDouble(6, evt.getMinThres());
            
            int res = con.execute();
            return res > 0;
        } catch (ClassNotFoundException | SQLException sql) {
            System.out.println(sql.getMessage());
        }
        return false;
    }

    @Override
    public Boolean editEvent(Events evt) {
        try {
            
            DatabaseConnection con = new DatabaseConnection();
            con.openConnection();

            String sql = "Update tbl_event SET event_name = ?, event_location = ?, event_description = ?, invited_attendes = ?, min_attendees = ?, minthreshold = ?, modified_date = ? where event_id=?";

            PreparedStatement stmt = con.initComp(sql);

            stmt.setString(1, evt.getName());
            stmt.setString(2, evt.getLocation());
            stmt.setString(3, evt.getDescription());
            stmt.setString(4, evt.getAttendeeString());
            stmt.setInt(5, evt.getMinAttendees());
            stmt.setDouble(6, evt.getMinThres());
            stmt.setDate(7, evt.getModifiedDate());
            stmt.setInt(8, evt.getId());
            
            int rs = con.execute();
            if(rs>0){
                return true;
            }
            
        } catch (ClassNotFoundException | SQLException sql) {
            System.out.println(sql.getMessage());
        }
        return false;
    }

    @Override
    public List<Events> showAll() {
        List<Events> evtLst = new ArrayList<>();
        try {
            DatabaseConnection con = new DatabaseConnection();

            con.openConnection();
            String sql = "Select * from tbl_event";
            con.initComp(sql);

            ResultSet rs = con.executeQuery();
            while (rs.next()) {
                Events evt = new Events();
                evt.setId(rs.getInt("event_id"));
                evt.setName(rs.getString("event_name"));
                evt.setLocation(rs.getString("event_location"));
                evt.setDescription(rs.getString("event_description"));
                evt.setAddedDate(rs.getTimestamp("added_date"));
                evt.setModifiedDate(rs.getDate("modified_date"));
                evt.setMinAttendees(rs.getInt("min_attendees"));
                evt.setMinThres(rs.getDouble("minthreshold"));
                String sDate = rs.getString("selected_date");
                if(sDate!=null){
                    String[]selDate = sDate.split(",");
                    evt.setSelDate(selDate);
                }
                
                List<String> usr = new ArrayList<>();
                String attendees = rs.getString("invited_attendes");
                if(attendees!=null){
                    
                    String[] temp = attendees.split(",");
                    usr.addAll(Arrays.asList(temp));
                    
                }
                evt.setAttendees(usr);
                evtLst.add(evt);
            }
        } catch (ClassNotFoundException | SQLException sql) {
            System.out.println(sql.getMessage());
        }

        return evtLst;
    }

    @Override
    public Boolean delEvents(Events evt) {
        try {
            DatabaseConnection con = new DatabaseConnection();

            con.openConnection();
            String sql = "DELETE FROM tbl_event where event_name = ?";
            PreparedStatement stmt = con.initComp(sql);
            stmt.setString(1, evt.getName());
            int res = con.execute();
            
            
            return res > 0;
        } catch (ClassNotFoundException | SQLException sql) {
            System.out.println(sql.getMessage());
        }
        return true;
    }

    @Override
    public Boolean selTimeSlot(String[] selDate, String name) {
        Events evt = new Events();
        try{
            DatabaseConnection con = new DatabaseConnection();
            con.openConnection();
            
            String sql = "Update tbl_event SET selected_date = ? where event_name =?";
            
            PreparedStatement stmt = con.initComp(sql);
            stmt.setString(1, evt.retString(selDate));
            stmt.setString(2, name);
            
            int res = con.execute();
            if(res > 0){
               return true; 
            }
        }catch(ClassNotFoundException | SQLException sql){
            System.out.println(sql.getMessage());
        }  
        return false;
    }

}
