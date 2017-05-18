/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pck.eventplanner.dao;

import com.pck.eventplanner.entity.TimeSlots;

/**
 *
 * @author G-Kesh
 */
public interface TimeSlotDao {
   public TimeSlots availTimeSlot(TimeSlots ts);
   public TimeSlots unavailTimeSlot(TimeSlots ts);
   public TimeSlots undecidedTimeSlot(TimeSlots ts);
}
