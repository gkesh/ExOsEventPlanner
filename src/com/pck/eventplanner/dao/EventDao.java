/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pck.eventplanner.dao;

import com.pck.eventplanner.entity.Events;
import java.util.List;

/**
 *
 * @author G-Kesh
 */
public interface EventDao {

    public Boolean addEvent(Events evt);

    public Boolean editEvent(Events evt);

    public List<Events> showAll();

    public Boolean delEvents(Events evt);

    public Boolean selTimeSlot(String[] selDate, String name);
    

}
