/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndh.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ndh.pojo.Phim;
import com.ndh.repository.PhimRepository;
import com.ndh.service.PhimService;
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
public class PhimServiceImpl implements PhimService {

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private PhimRepository repository;

    @Override
    public List<Phim> getMovies(Map<String, String> params) {
        return this.repository.getMovies(params);
    }

    @Override
    public boolean addOrUpdateMovie(Phim p) {
        if (!p.getFile().isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(p.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                p.setAnhPhim(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(PhimServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return this.repository.addOrUpdateMovie(p);
    }

    @Override
    public Phim getMovieById(int id) {
        return this.repository.getMovieById(id);
    }

    @Override
    public boolean deleteMovie(int id) {
        return this.repository.deleteMovie(id);
    }

}
