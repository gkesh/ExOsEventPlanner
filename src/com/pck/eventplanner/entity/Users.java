/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pck.eventplanner.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
/**
 *
 * @author G-Kesh
 */
public class Users {

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
     */

    private String first_name, last_name, username, password, email_add, phone_no, event_planner;
    private String[][] free_slot = new String[7][25];
    private String[][] busy_slot = new String[7][25];
    private String[][] undecided_slot = new String[7][25];
    private final String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    private final String[] timeslot = {"0-1", "1-2", "2-3", "3-4", "4-5", "5-6", "6-7", "7-8", "8-9", "9-10", "10-11", "11-12", "12-13", "13-14", "14-15", "15-16", "16-17", "17-18", "18-19", "19-20", "20-21", "21-22", "22-23", "23-24"};
    private Timestamp added_date;
    private Date modified_date;
    private int id;
    private String notification;

//Constructor
    public Users() {

    }
//Getter and the setter 

    public String getEvent_planner() {
        return event_planner;
    }

    public void setEvent_planner(String event_planner) {
        this.event_planner = event_planner;
    }
    
    public Timestamp getAdded_date() {
        return added_date;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }
    
    public void setAdded_date(Timestamp added_date) {
        this.added_date = added_date;
    }

    public Date getModified_date() {
        return modified_date;
    }

    public void setModified_date(Date modified_date) {
        this.modified_date = modified_date;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String[] getDays() {
        return days;
    }

    public String[] getTimeslot() {
        return timeslot;
    }

    public String[][] getFree_slot() {
        return free_slot;
    }
    public void setFree_slot(String[][] free_slot) {
        this.free_slot = free_slot;
    }

    public void setBusy_slot(String[][] busy_slot) {
        this.busy_slot = busy_slot;
    }

    public void setUndecided_slot(String[][] undecided_slot) {
        this.undecided_slot = undecided_slot;
    }

    public String[][] getBusy_slot() {
        return busy_slot;
    }

    public String[][] getUndecided_slot() {
        return undecided_slot;
    }

    
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }


    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail_add() {
        return email_add;
    }

    public void setEmail_add(String email_add) {
        this.email_add = email_add;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }
//Returns Arrays in String format
    public String retString(String[][] ar) {
        
        StringBuilder stra = new StringBuilder();
        for (String[] arr : ar) {
            
            for (String str : arr) {
                if(str == null){
                    break;
                }
                stra.append(str).append(",");
            }
            stra.append("\n");
        }
        return stra.toString();
    }
    public String retString(List<String> ar) {
        
        StringBuilder stra = new StringBuilder();
        for (String arr : ar) {
            stra.append(arr).append(",");
            }
        return stra.toString();
    }
    @Override
    public String toString() {
        return "Users{" + "Fisrt name=" + first_name + "Last name=" + last_name + ", username=" + username + ", password=" + password + ", email_add=" + email_add + ", phone_no=" + phone_no + ", Attendee=" +", free_time=" + Arrays.toString(free_slot) + ", busy_time=" + Arrays.toString(busy_slot) + ", undecided_slot=" + Arrays.toString(undecided_slot) + '}';
    }

}
