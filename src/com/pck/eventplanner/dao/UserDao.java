/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pck.eventplanner.dao;

import com.pck.eventplanner.entity.Users;
import java.util.List;

/**
 *
 * @author G-Kesh
 */
public interface UserDao {
    public Boolean addUser(Users usr);
    public Boolean editProfile(Users usr);
    public Boolean removeUser(Users usr);
    public List<Users> showAll();
}
