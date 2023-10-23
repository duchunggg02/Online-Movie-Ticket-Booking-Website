/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndh.repository.impl;

import com.ndh.pojo.ChongoiSuatchieu;
import com.ndh.pojo.Suatchieu;
import com.ndh.repository.ChoNgoiSuatChieuRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
public class ChoNgoiSuatChieuRepositoryImpl implements ChoNgoiSuatChieuRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ChongoiSuatchieu> getBookSeatsBySuatChieu(Suatchieu suatChieu) {
        Session s = this.factory.getObject().getCurrentSession();
        Criteria criteria = s.createCriteria(ChongoiSuatchieu.class);

        criteria.add(Restrictions.eq("suatChieuID", suatChieu));
        return criteria.list();
    }

    @Override
    public ChongoiSuatchieu getBookSeatsById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(ChongoiSuatchieu.class, id);
    }

    @Override
    public List<ChongoiSuatchieu> getBookSeatsByTicketId(int id) {
        String sql = "SELECT cs.* FROM chongoi_suatchieu cs "
                + "INNER JOIN chongoi_ve cv ON cs.ChoNgoiSuatChieuID = cv.ChoNgoiSuatChieuID "
                + "WHERE cv.VeID = :veID";

        return entityManager.createNativeQuery(sql, ChongoiSuatchieu.class)
                .setParameter("veID", id)
                .getResultList();
    }

    @Override
    public List<ChongoiSuatchieu> getBookSeatsBySuatChieuId(int id) {
        Session s = this.factory.getObject().getCurrentSession();

        Query q = s.createQuery("From ChongoiSuatchieu Where suatChieuID.suatChieuID=:id");
        q.setParameter("id", id);

        return q.getResultList();
    }

    @Override
    public List<ChongoiSuatchieu> getBookSeats(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();

        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<ChongoiSuatchieu> q = b.createQuery(ChongoiSuatchieu.class);
        Root root = q.from(ChongoiSuatchieu.class);
        q.select(root);
        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            String suatChieuID = params.get("suatChieuID");
            if (suatChieuID != null && !suatChieuID.isEmpty()) {
                predicates.add(b.equal(root.get("suatChieuID"), Integer.parseInt(suatChieuID)));
            }
            q.where(predicates.toArray(Predicate[]::new));
        }

        Query query = s.createQuery(q);

        return query.getResultList();
    }

}
