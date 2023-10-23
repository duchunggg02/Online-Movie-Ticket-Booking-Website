/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndh.repository.impl;

import com.ndh.pojo.ChongoiSuatchieu;
import com.ndh.pojo.ChongoiVe;
import com.ndh.pojo.Suatchieu;
import com.ndh.pojo.Ve;
import com.ndh.repository.ChoNgoiSuatChieuRepository;
import com.ndh.repository.VeRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Duc Hung
 */
@Repository
@Transactional
public class VeRepositoryImpl implements VeRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Autowired
    private ChoNgoiSuatChieuRepository choNgoiSuatChieuRepository;

    @Override
    public List<Ve> getTickets() {
        Session s = this.factory.getObject().getCurrentSession();

        Query q = s.createQuery("FROM Ve");
        return q.getResultList();
    }

    @Override
    public boolean addOrUpdateTicket(Ve v, List<Integer> selectedSeatIds) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if (v.getVeID() == null) {  
               
                s.save(v);
                for (Integer seatId : selectedSeatIds) {
                    ChongoiSuatchieu choNgoiSuatChieu = choNgoiSuatChieuRepository.getBookSeatsById(seatId);
                    choNgoiSuatChieu.setTrangThai(true);
                    ChongoiVe chongoiVe = new ChongoiVe();
                    chongoiVe.setVeID(v);
                    chongoiVe.setChoNgoiSuatChieuID(choNgoiSuatChieu);
                    s.save(chongoiVe);
                }

                
            } else {
                s.update(v);
            }


            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
  


    @Override
    public boolean deleteTicket(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Ve v = this.getTicketById(id);
        try {
            s.delete(v);

            List<ChongoiSuatchieu> bookedSeats = this.choNgoiSuatChieuRepository.getBookSeatsByTicketId(id);
            for (ChongoiSuatchieu seat : bookedSeats) {
                seat.setTrangThai(false);
                s.update(seat);
            }

            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Ve getTicketById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Ve.class, id);
    }

    @Override
    public Ve addTicket(Ve v, List<Integer> selectedSeatIds) {
        Session s = this.factory.getObject().getCurrentSession();
        s.save(v);
        
        for (Integer seatId : selectedSeatIds) {
                    ChongoiSuatchieu choNgoiSuatChieu = choNgoiSuatChieuRepository.getBookSeatsById(seatId);
                    choNgoiSuatChieu.setTrangThai(true);
                    ChongoiVe chongoiVe = new ChongoiVe();
                    chongoiVe.setVeID(v);
                    chongoiVe.setChoNgoiSuatChieuID(choNgoiSuatChieu);
                    s.save(chongoiVe);
        }
        
        return v;
    }
//    @Override
//    public Ve addTicket(Ve v) {
//        Session s = this.factory.getObject().getCurrentSession();
//        s.save(v);
//        
//     
//        
//        return v;
//    }

    @Override
    public List<Ve> getTicketByUserID(int id) {
        Session s = this.factory.getObject().getCurrentSession();

        Query q = s.createQuery("From Ve Where nguoiDungID.nguoiDungID=:id");
        q.setParameter("id", id);

        return q.getResultList();
    }
}
