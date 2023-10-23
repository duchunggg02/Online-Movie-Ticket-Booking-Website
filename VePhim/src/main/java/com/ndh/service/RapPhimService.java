/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ndh.service;

import com.ndh.pojo.Rapphim;
import java.util.List;

/**
 *
 * @author Duc Hung
 */
public interface RapPhimService {

    List<Rapphim> getTheaters();

    boolean addOrUpdateTheater(Rapphim r);

    Rapphim getTheaterById(int id);
    
    boolean deleteTheater(int id);
}
