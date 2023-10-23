/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndh.repository.impl;

import com.ndh.pojo.Phanhoi;
import com.ndh.pojo.Suatchieu;
import com.ndh.repository.PhanHoiRepository;
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
public class PhanHoiRepositoryImpl implements PhanHoiRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Phanhoi> getFeedbacks() {
        Session s = this.factory.getObject().getCurrentSession();

        Query q = s.createQuery("FROM Phanhoi");
        return q.getResultList();
    }

    @Override
    public boolean addOrUpdateFeedback(Phanhoi p) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if (p.getPhanHoiID() == null) {
                s.save(p);
            } else {
                s.update(p);
            }

            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Phanhoi getFeedbackById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Phanhoi.class, id);
    }

    @Override
    public boolean deleteFeedback(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Phanhoi p = this.getFeedbackById(id);
        try {
            s.delete(p);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Phanhoi> getFeedbackByPhimId(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From Phanhoi Where veID.suatChieuID.phimID.phimID=:id");
        q.setParameter("id", id);

        return q.getResultList();
    }

    @Override
    public Phanhoi addFeedback(Phanhoi p) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            s.save(p);
            return p;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
