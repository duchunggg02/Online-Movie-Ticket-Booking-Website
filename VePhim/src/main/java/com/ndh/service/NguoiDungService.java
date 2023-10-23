/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ndh.service;

import com.ndh.pojo.Nguoidung;
import java.util.List;
import java.util.Map;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Duc Hung
 */
public interface NguoiDungService extends UserDetailsService {

    List<Nguoidung> getUsers(Map<String, String> params);

    boolean addOrUpdateUser(Nguoidung n);

    Nguoidung getUserById(int id);

    boolean deleteUser(int id);

    boolean registerUser(Nguoidung n);
    
    boolean authUser(String username, String password);
    
    Nguoidung getUserByUsername(String username);
    
    Nguoidung addUser(Map<String, String> params, MultipartFile avatar);
    
    boolean isExistUsername(String username);
}
