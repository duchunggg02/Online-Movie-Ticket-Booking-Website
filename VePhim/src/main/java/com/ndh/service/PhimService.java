/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ndh.service;

import com.ndh.pojo.Phim;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Duc Hung
 */
public interface PhimService {
    
    List<Phim> getMovies(Map<String, String> params);
    boolean addOrUpdateMovie(Phim p);
    Phim getMovieById(int id);
    boolean deleteMovie(int id);
}
