/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndh.service.impl;

import com.ndh.pojo.Nguoidung;
import com.ndh.pojo.Suatchieu;
import com.ndh.pojo.Ve;
import com.ndh.repository.NguoiDungRepository;
import com.ndh.repository.VeRepository;
import com.ndh.service.SuatChieuService;
import com.ndh.service.VeService;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Duc Hung
 */
@Service
public class VeServiceImpl implements VeService {

    @Autowired
    private VeRepository repository;

    @Autowired
    private NguoiDungRepository userRepository;
    
    @Autowired
    private SuatChieuService scService;

    @Override
    public List<Ve> getTickets() {
        return this.repository.getTickets();
    }

    @Override
    public boolean addOrUpdateTicket(Ve v, List<Integer> selectedSeatIds) {
        Suatchieu sc = this.scService.getShowtimeById(v.getSuatChieuID().getSuatChieuID());
       
        v.setGia(selectedSeatIds.size() * sc.getGiaTien());
       
        return this.repository.addOrUpdateTicket(v, selectedSeatIds);
    }

    @Override
    public Ve getTicketById(int id) {
        return this.repository.getTicketById(id);
    }

    @Override
    public boolean deleteTicket(int id) {
        return this.repository.deleteTicket(id);
    }

    @Override
    public Ve addTicket(Ve v, List<Integer> selectedSeatIds) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Nguoidung n = this.userRepository.getUserByUsername(authentication.getName());
        v.setNguoiDungID(n);
        v.setNgayDat(new Date());
        v.setPhuongThucThanhToan("Tiền");
        v.setTinhTrang(true);
        Suatchieu sc = this.scService.getShowtimeById(v.getSuatChieuID().getSuatChieuID());
        v.setGia(selectedSeatIds.size() * sc.getGiaTien());
        return this.repository.addTicket(v, selectedSeatIds);
    }
    
//     @Override
//    public Ve addTicket(Ve v) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        Nguoidung n = this.userRepository.getUserByUsername(authentication.getName());
//        v.setNguoiDungID(n);
//        v.setNgatDat(new Date());
//        v.setPhuongThucThanhToan("Tiền");
//        v.setTinhTrang(true);
//        return this.repository.addTicket(v);
//    }

    @Override
    public List<Ve> getTicketByUserID(int id) {
        return this.repository.getTicketByUserID(id);
    }

}
