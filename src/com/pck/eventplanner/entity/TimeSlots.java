/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pck.eventplanner.entity;


/**
 *
 * @author G-Kesh
 */
public class TimeSlots {
    private final String[] days={"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
    private final String[] timeslot ={"0-1","1-2","2-3","3-4","4-5","5-6","6-7","7-8","8-9","9-10","10-11","11-12","12-13","13-14","14-15","15-16","16-17","17-18","18-19","19-20","20-21","21-22","22-23","23-24"};
    private String[][] availabletimeslot;
    private String[][] unavilabletimeslot;
    private String[][] undecidedtimeslot;
    public TimeSlots(){
        
    }
    //Getter and the setter

    public String[][] getUnavilabletimeslot() {
        return unavilabletimeslot;
    }

    public void setUnavilabletimeslot(String[][] unavailabletimeslot) {
        this.unavilabletimeslot= unavailabletimeslot;
    }
    public String[][] getUndecidedtimeslot() {
        return undecidedtimeslot;
    }
    public void setUndecidedtimeslot(String[][] undecidedtimeslot) {
        this.undecidedtimeslot = undecidedtimeslot;
    }
    public String[][] getAvailabletimeslot() {
        return availabletimeslot;
    }

    public void setAvailabletimeslot(String[][] availabletimeslot) {
      this.availabletimeslot = availabletimeslot;  
    }

    public String[] getDays() {
        return days;
    }

    public String[] getTimeslot() {
        return timeslot;
    }
}
