/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndh.repository.impl;

import com.ndh.pojo.Vaitro;
import com.ndh.repository.VaiTroRepository;
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
public class VaiTroRepositoryImpl implements VaiTroRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Vaitro> getRoles() {
        Session s = this.factory.getObject().getCurrentSession();

        Query q = s.createQuery("FROM Vaitro");
        return q.getResultList();
    }

    @Override
    public boolean addOrUpdateRole(Vaitro v) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if (v.getVaiTroID() == null) {
                s.save(v);
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
    public Vaitro getRoleById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Vaitro.class, id);
    }

    @Override
    public boolean deleteRole(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Vaitro v = this.getRoleById(id);
        try {
            s.delete(v);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
