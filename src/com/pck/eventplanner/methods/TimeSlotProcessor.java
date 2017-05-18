/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pck.eventplanner.methods;

import com.pck.eventplanner.entity.TimeSlots;
import com.pck.eventplanner.entity.Users;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author G-Kesh
 */
public class TimeSlotProcessor {

    public String[] timeSlotProcessor(List<Users> lst) {
        GetAllTimeSlots gs = new GetAllTimeSlots();
        TimeSlots ts = new TimeSlots();
        ts = gs.getAllTimeSlots(lst);
        String[] timeSlots = ts.getTimeslot();
        String[] days = ts.getDays();
        String result[] = new String[6];
        int timeSlotCount[] = new int[timeSlots.length];
        int dayCount[] = {0,0,0,0,0,0,0};
        for(int i=0;i<timeSlotCount.length;i++){
            timeSlotCount[i]=0;
        }
        //For available TimeSlots
        List<String> availTS = new ArrayList<>();
        String[][] availTs = ts.getAvailabletimeslot();
        for(String[] temp : availTs){
            availTS.addAll(Arrays.asList(temp));
        }
        for(String str: availTS){
            for(int i=0;i<days.length;i++){
                if(days[i].equalsIgnoreCase(str)){
                    dayCount[i]+=1;
                }
            }
        }
        //For Unavailable TimeSlots
        List<String> unavailTS = new ArrayList<>();
        String[][] unavailTs = ts.getUnavilabletimeslot();
        for(String[] temp : unavailTs){
            unavailTS.addAll(Arrays.asList(temp));
        }
        
        
        //For Undecided TimeSlots
        List<String> undecTS = new ArrayList<>();
        String[][] undecTs = ts.getUndecidedtimeslot();
        for(String[] temp : undecTs){
            undecTS.addAll(Arrays.asList(temp));
        }
        
        //To Calculate the most repeated days
        int pos = 0, grt = 0;
        for (int i = 0; i < dayCount.length; i++) {
            if (dayCount[i] > grt) {
                grt = dayCount[i];
                pos = i;
            }
        }
        result[0] = days[pos];
        System.out.println("Most Common day is =>" + result[0]);
        for(String ats : availTS){
            for(int i= 0; i<timeSlots.length;i++){
                if(timeSlots[i].equalsIgnoreCase(ats)){
                    timeSlotCount[i]+=1;
                }
            }
        }
        //To Calculate the most repeated timeSlots
        int counter =1;
        for(int i = 0; i<timeSlotCount.length; i++){
            for(int j = 0; j<timeSlotCount.length;j++){
                if(i==j) {
                    
                }else{
                    if(timeSlotCount[i]<timeSlotCount[j]){
                        break;
                    }
                    if(j==23){
                        result[counter]=timeSlots[i];
                        timeSlotCount[i]=-1;
                        i=0;
                        counter++;
                    }
                }
            }
            if(counter>=6){
                break;
            }
        }
        
        return result;
    }
}