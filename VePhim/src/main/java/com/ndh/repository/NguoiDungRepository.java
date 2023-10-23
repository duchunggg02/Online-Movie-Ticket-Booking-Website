/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ndh.repository;

import com.ndh.pojo.Nguoidung;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Duc Hung
 */
public interface NguoiDungRepository {

    List<Nguoidung> getUsers(Map<String, String> params);

    boolean addOrUpdateUser(Nguoidung n);

    Nguoidung getUserById(int id);

    boolean deleteUser(int id);

    Nguoidung getUserByUsername(String username);

    boolean registerUser(Nguoidung n);

    boolean authUser(String username, String password);
    
    Nguoidung addUser(Nguoidung n);
    
    boolean isExistUsername(String username);
}
