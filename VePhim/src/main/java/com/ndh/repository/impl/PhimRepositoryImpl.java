/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndh.repository.impl;

import com.ndh.pojo.Phim;
import com.ndh.repository.PhimRepository;
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
public class PhimRepositoryImpl implements PhimRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Phim> getMovies(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();

        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Phim> q = b.createQuery(Phim.class);
        Root root = q.from(Phim.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                predicates.add(b.like(root.get("tenPhim"), String.format("%%%s%%", kw)));
            }
            q.where(predicates.toArray(Predicate[]::new));
        }

        Query query = s.createQuery(q);

        return query.getResultList();
    }

    @Override
    public boolean addOrUpdateMovie(Phim p) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if (p.getPhimID() == null) {
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
    public Phim getMovieById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Phim.class, id);
    }

    @Override
    public boolean deleteMovie(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Phim p = this.getMovieById(id);
        try {
            s.delete(p);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
