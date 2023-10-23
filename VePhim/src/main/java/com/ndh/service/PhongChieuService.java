/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ndh.service;

import com.ndh.pojo.Phongchieu;
import java.util.List;

/**
 *
 * @author Duc Hung
 */
public interface PhongChieuService {
    List<Phongchieu> getRooms();
    boolean addOrUpdateRoom(Phongchieu p);
    Phongchieu getRoomById(int id);
    boolean deleteRoom(int id);
}
