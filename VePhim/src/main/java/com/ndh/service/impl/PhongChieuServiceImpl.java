/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndh.service.impl;

import com.ndh.pojo.Phongchieu;
import com.ndh.repository.PhongChieuRepository;
import com.ndh.service.PhongChieuService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Duc Hung
 */
@Service
public class PhongChieuServiceImpl implements PhongChieuService {

    @Autowired
    private PhongChieuRepository repository;

    @Override
    public List<Phongchieu> getRooms() {
        return this.repository.getRooms();
    }

    @Override
    public boolean addOrUpdateRoom(Phongchieu p) {
        return this.repository.addOrUpdateRoom(p);
    }

    @Override
    public Phongchieu getRoomById(int id) {
        return this.repository.getRoomById(id);
    }

    @Override
    public boolean deleteRoom(int id) {
        return this.repository.deleteRoom(id);
    }

}
