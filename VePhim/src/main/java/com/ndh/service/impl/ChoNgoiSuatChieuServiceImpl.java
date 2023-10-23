/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndh.service.impl;

import com.ndh.pojo.ChongoiSuatchieu;
import com.ndh.pojo.Suatchieu;
import com.ndh.repository.ChoNgoiSuatChieuRepository;
import com.ndh.service.ChoNgoiSuatChieuService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Duc Hung
 */
@Service
public class ChoNgoiSuatChieuServiceImpl implements ChoNgoiSuatChieuService {

    @Autowired
    private ChoNgoiSuatChieuRepository repository;

    @Override
    public List<ChongoiSuatchieu> getBookSeatsBySuatChieu(Suatchieu suatChieu) {
        return this.repository.getBookSeatsBySuatChieu(suatChieu);
    }

    @Override
    public ChongoiSuatchieu getBookSeatsById(int id) {
        return this.repository.getBookSeatsById(id);
    }

    @Override
    public List<ChongoiSuatchieu> getBookSeatsByTicketId(int id) {
        return this.repository.getBookSeatsByTicketId(id);
    }

    @Override
    public List<ChongoiSuatchieu> getBookSeatsBySuatChieuId(int id) {
        return this.repository.getBookSeatsBySuatChieuId(id);
    }

    @Override
    public List<ChongoiSuatchieu> getBookSeats(Map<String, String> params) {
        return this.repository.getBookSeats(params);
    }

}
