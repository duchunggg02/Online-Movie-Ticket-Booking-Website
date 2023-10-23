/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndh.repository.impl;

import com.ndh.pojo.Chongoi;
import com.ndh.pojo.ChongoiSuatchieu;
import com.ndh.pojo.Suatchieu;
import com.ndh.repository.ChoNgoiRepository;
import com.ndh.repository.SuatChieuRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
public class SuatChieuRepositoryImpl implements SuatChieuRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Autowired
    private ChoNgoiRepository choNgoiRepository;

    @Override
    public List<Suatchieu> getShowtimes(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();

        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Suatchieu> q = b.createQuery(Suatchieu.class);
        Root root = q.from(Suatchieu.class);
        q.select(root);
        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            String phimID = params.get("phimID");
            if (phimID != null && !phimID.isEmpty()) {
                predicates.add(b.equal(root.get("phimID"), Integer.parseInt(phimID)));
            }
            q.where(predicates.toArray(Predicate[]::new));
        }

        Query query = s.createQuery(q);

        return query.getResultList();

    }

    @Override
    public boolean addOrUpdateShowtime(Suatchieu sc) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if (sc.getSuatChieuID() == null) {
                s.save(sc);

                List<Chongoi> listChoNgoi = choNgoiRepository.getSeatsByPhongChieu(sc.getPhongChieuID());

                for (Chongoi choNgoi : listChoNgoi) {
                    ChongoiSuatchieu seat = new ChongoiSuatchieu();
                    seat.setSuatChieuID(sc);
                    seat.setChoNgoiID(choNgoi);
                    seat.setTrangThai(false); // Chưa đặt
                    s.persist(seat);
                }

            } else {
                s.update(sc);
            }

            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Suatchieu getShowtimeById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Suatchieu.class, id);
    }

    @Override
    public boolean deteleShowtime(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Suatchieu sc = this.getShowtimeById(id);
        try {
            s.delete(sc);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Suatchieu> getShowtimeByPhimId(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From Suatchieu Where phimID.phimID=:id");
        q.setParameter("id", id);
        
        return q.getResultList();
    }
    

}
