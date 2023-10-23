/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ndh.repository;

import com.ndh.pojo.Suatchieu;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Duc Hung
 */
public interface SuatChieuRepository {

    List<Suatchieu> getShowtimes(Map<String, String> params);

    boolean addOrUpdateShowtime(Suatchieu sc);

    Suatchieu getShowtimeById(int id);

    boolean deteleShowtime(int id);
    
    List<Suatchieu> getShowtimeByPhimId(int id);

}
