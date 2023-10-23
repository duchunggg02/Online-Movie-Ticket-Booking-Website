/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndh.service.impl;

import com.ndh.pojo.Nguoidung;
import com.ndh.pojo.Phanhoi;
import com.ndh.repository.NguoiDungRepository;
import com.ndh.repository.PhanHoiRepository;
import com.ndh.service.PhanHoiService;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Duc Hung
 */
@Service
public class PhanHoiServiceImpl implements PhanHoiService {

    @Autowired
    private PhanHoiRepository repository;
    
    @Autowired
    private NguoiDungRepository userRepository;

    @Override
    public List<Phanhoi> getFeedbacks() {
        return this.repository.getFeedbacks();
    }

    @Override
    public boolean addOrUpdateFeedback(Phanhoi p) {
        p.setNgayTao(new Date());
        return this.repository.addOrUpdateFeedback(p);
    }

    @Override
    public Phanhoi getFeedbackById(int id) {
        return this.repository.getFeedbackById(id);
    }

    @Override
    public boolean deleteFeedback(int id) {
        return this.repository.deleteFeedback(id);
    }

    @Override
    public List<Phanhoi> getFeedbackByPhimId(int id) {
        return this.repository.getFeedbackByPhimId(id);
    }

    @Override
    public Phanhoi addFeedback(Phanhoi p) {
        p.setNgayTao(new Date());
        return this.repository.addFeedback(p);
    }

}
