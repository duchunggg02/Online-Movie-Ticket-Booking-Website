/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ndh.service;

import com.ndh.pojo.ChongoiSuatchieu;
import com.ndh.pojo.Suatchieu;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Duc Hung
 */
public interface ChoNgoiSuatChieuService {

    List<ChongoiSuatchieu> getBookSeatsBySuatChieu(Suatchieu suatChieu);
    ChongoiSuatchieu getBookSeatsById(int id);
    List<ChongoiSuatchieu> getBookSeatsByTicketId(int id);
    List<ChongoiSuatchieu> getBookSeatsBySuatChieuId(int id);
    List<ChongoiSuatchieu> getBookSeats(Map<String, String> params);
}
