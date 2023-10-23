/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndh.repository.impl;

import com.ndh.pojo.Chongoi;
import com.ndh.pojo.Phongchieu;
import com.ndh.repository.ChoNgoiRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
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
public class ChoNgoiRepositoryImpl implements ChoNgoiRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Chongoi> getSeats() {
        Session s = this.factory.getObject().getCurrentSession();

        Query q = s.createQuery("FROM Chongoi");
        return q.getResultList();
    }

    @Override
    public List<Chongoi> getSeatsByPhongChieu(Phongchieu phongChieu) {
        Session s = this.factory.getObject().getCurrentSession();

        Criteria criteria = s.createCriteria(Chongoi.class);

        criteria.add(Restrictions.eq("phongChieuID", phongChieu));
        return criteria.list();
    }

}
