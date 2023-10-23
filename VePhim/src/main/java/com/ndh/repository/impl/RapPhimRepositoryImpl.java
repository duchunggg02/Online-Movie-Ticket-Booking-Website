/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndh.repository.impl;

import com.ndh.pojo.Rapphim;
import com.ndh.repository.RapPhimRepository;
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
public class RapPhimRepositoryImpl implements RapPhimRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Rapphim> getTheaters() {
        Session s = this.factory.getObject().getCurrentSession();

        Query q = s.createQuery("FROM Rapphim");
        return q.getResultList();
    }

    @Override
    public boolean addOrUpdateTheater(Rapphim r) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if (r.getRapPhimID() == null) {
                s.save(r);
            } else {
                s.update(r);
            }

            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Rapphim getTheaterById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Rapphim.class, id);
    }

    @Override
    public boolean deleteTheater(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Rapphim r = this.getTheaterById(id);
        try {
              s.delete(r);
              return true;
          } catch (HibernateException ex) {
              ex.printStackTrace();
            return false;
          }
    }

}
