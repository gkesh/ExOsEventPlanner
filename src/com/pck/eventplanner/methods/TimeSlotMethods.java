/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pck.eventplanner.methods;

import com.pck.eventplanner.dao.TimeSlotDao;
import com.pck.eventplanner.entity.TimeSlots;
import com.pck.eventplanner.entity.Users;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author G-Kesh
 */
public class TimeSlotMethods implements TimeSlotDao{
    List<Users> usrLst = new ArrayList<>();
    public TimeSlotMethods(List<Users> usrLst){
        this.usrLst = usrLst;
    }
    @Override
    public TimeSlots availTimeSlot(TimeSlots tm) {
       int arraySizeCount = 0;
        for(Users usr : usrLst){
              arraySizeCount+= usr.getFree_slot().length;
          
       }
       String[][] availTimeSlot = new String[arraySizeCount][];
       int count=0;
       for(Users usr : usrLst){
              for(String[] str : usr.getFree_slot()){
                  availTimeSlot[count]= str;
                  count++;
              }
       }
       tm.setAvailabletimeslot(availTimeSlot);
       return tm;
    }

    @Override
    public TimeSlots unavailTimeSlot(TimeSlots tm) {
        int arraySizeCount = 0;
        for(Users usr : usrLst){
              arraySizeCount+= usr.getBusy_slot().length;
       }
        String[][] unavailTimeSlot = new String[arraySizeCount][];
        int count=0;
       for(Users usr : usrLst){
              for(String[] str : usr.getBusy_slot()){
                  unavailTimeSlot[count]= str;
                  count++;
              }
       }
       tm.setUnavilabletimeslot(unavailTimeSlot);
       return tm;
    }

    @Override
    public TimeSlots undecidedTimeSlot(TimeSlots tm) {
        int arraySizeCount = 0;
        for(Users usr : usrLst){
              arraySizeCount+= usr.getUndecided_slot().length;
       }
        String[][] undecidedTimeSlot = new String[arraySizeCount][];
         int count=0;
       for(Users usr : usrLst){
              for(String[] str : usr.getUndecided_slot()){
                  undecidedTimeSlot[count]= str;
                  count++;
              }
       }
       tm.setUndecidedtimeslot(undecidedTimeSlot);
       return tm;
    }

    
}
