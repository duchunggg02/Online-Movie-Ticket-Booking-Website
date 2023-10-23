/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndh.service.impl;

import com.ndh.pojo.Chongoi;
import com.ndh.pojo.Phongchieu;
import com.ndh.repository.ChoNgoiRepository;
import com.ndh.service.ChoNgoiService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Duc Hung
 */
@Service
public class ChoNgoiServiceImpl implements ChoNgoiService {
    
    @Autowired
    private ChoNgoiRepository repository;
    
    @Override
    public List<Chongoi> getSeats() {
        return this.repository.getSeats();
    }
    
    @Override
    public List<Chongoi> getSeatsByPhongChieu(Phongchieu phongChieu) {
        return this.repository.getSeatsByPhongChieu(phongChieu);
    }
    
}
