/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pck.eventplanner.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author G-Kesh
 */
public class Events {

    private String name, location, description;
    private int id, minAttendees, voteCount[] = new int[5];
    private double minThres;
    private String selDate[];
    private Timestamp addedDate;
    private Date  modifiedDate;
    private List<String> attendees;
//Constructor 
    public Events() {

    }
//getter and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int[] getVoteCount() {
        return voteCount;
    }

    public Timestamp getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Timestamp addedDate) {
        this.addedDate = addedDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
    public void setVoteCount(int[] voteCount) {
        this.voteCount = voteCount;
    }

    public List<String> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<String> attendees) {
        this.attendees = attendees;
    }

    public String[] getSelDate() {
        return selDate;
    }

    public void setSelDate(String[] selDate) {
        this.selDate = new String[6];
        this.selDate = selDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMinAttendees() {
        return minAttendees;
    }

    public void setMinAttendees(int minAttendees) {
        this.minAttendees = minAttendees;
    }

    public double getMinThres() {
        return minThres;
    }

    public void setMinThres(double minThres) {
        this.minThres = minThres;
    }
//Returns arrays in a string format
    public String retString(String[] arr) {
        StringBuilder stra = new StringBuilder();
        for (String str : arr) {
            stra.append(str).append(",");
        }
        return stra.toString();
    }
//Returns attendee list in a String format
    public String getAttendeeString(){
        StringBuilder str = new StringBuilder();
        for(String usr : attendees){
            str.append(usr).append(",");
        }
        return str.toString();
    }
//Returns objects in String format
    @Override
    public String toString() {
        return "Events{" + "name=" + name + ", location=" + location + ", description=" + description + ", minAttendees=" + minAttendees + ", minThres=" + minThres + '}'+"\n";
    }

}
