/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pck.eventplanner.methods;

import com.pck.eventplanner.entity.TimeSlots;
import com.pck.eventplanner.entity.Users;
import java.util.List;

/**
 *
 * @author G-Kesh
 */
public class GetAllTimeSlots {
    public TimeSlots getAllTimeSlots(List<Users> lst){
       TimeSlotMethods tm = new TimeSlotMethods(lst);
       TimeSlots ts = new TimeSlots();
       ts = tm.availTimeSlot(ts);
       ts = tm.unavailTimeSlot(ts);
       ts = tm.undecidedTimeSlot(ts);
       return ts;
    }
}
