/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ndh.repository;

import com.ndh.pojo.Chongoi;
import com.ndh.pojo.Phongchieu;
import java.util.List;

/**
 *
 * @author Duc Hung
 */
public interface ChoNgoiRepository {
    List<Chongoi> getSeats();
    List<Chongoi> getSeatsByPhongChieu(Phongchieu phongChieu);
}
