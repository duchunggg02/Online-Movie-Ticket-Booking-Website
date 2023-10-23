/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndh.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ndh.pojo.Rapphim;
import com.ndh.repository.RapPhimRepository;
import com.ndh.service.RapPhimService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Duc Hung
 */
@Service
public class RapPhimServiceImpl implements RapPhimService {

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private RapPhimRepository repository;

    @Override
    public List<Rapphim> getTheaters() {
        return this.repository.getTheaters();
    }

    @Override
    public boolean addOrUpdateTheater(Rapphim r) {
        if (!r.getFile().isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(r.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                r.setAnhRap(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(RapPhimServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return this.repository.addOrUpdateTheater(r);
    }

    @Override
    public Rapphim getTheaterById(int id) {
        return this.repository.getTheaterById(id);
    }

    @Override
    public boolean deleteTheater(int id) {
        return this.repository.deleteTheater(id);
    }

}
