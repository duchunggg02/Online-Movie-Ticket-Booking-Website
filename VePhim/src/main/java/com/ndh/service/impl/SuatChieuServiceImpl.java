/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndh.service.impl;

import com.ndh.pojo.Suatchieu;
import com.ndh.repository.SuatChieuRepository;
import com.ndh.service.SuatChieuService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Duc Hung
 */
@Service
public class SuatChieuServiceImpl implements SuatChieuService {

    @Autowired
    private SuatChieuRepository repository;

    @Override
    public List<Suatchieu> getShowtimes(Map<String, String> params) {
        return this.repository.getShowtimes(params);
    }

    @Override
    public boolean addOrUpdateShowtime(Suatchieu sc) {
        return this.repository.addOrUpdateShowtime(sc);
    }

    @Override
    public Suatchieu getShowtimeById(int id) {
        return this.repository.getShowtimeById(id);
    }

    @Override
    public boolean deteleShowtime(int id) {
        return this.repository.deteleShowtime(id);
    }

    @Override
    public List<Suatchieu> getShowtimeByPhimId(int id) {
        return this.repository.getShowtimeByPhimId(id);
    }

}
