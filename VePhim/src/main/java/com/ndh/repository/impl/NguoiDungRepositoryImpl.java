/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndh.repository.impl;

import com.ndh.pojo.Nguoidung;
import com.ndh.repository.NguoiDungRepository;
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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Duc Hung
 */
@Repository
@Transactional
public class NguoiDungRepositoryImpl implements NguoiDungRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Autowired
    private BCryptPasswordEncoder passEncoder;

    @Override
    public List<Nguoidung> getUsers(Map<String, String> params) {
        Session session = this.factory.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Nguoidung> q = b.createQuery(Nguoidung.class);
        Root root = q.from(Nguoidung.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                predicates.add(b.like(root.get("ten"), String.format("%%%s%%", kw)));
            }

//            String tenDangNhap = params.get("tenDangNhap");
//            if (tenDangNhap != null && !tenDangNhap.isEmpty()) {
//                predicates.add(b.equal(root.get("tenDangNhap"), tenDangNhap));
//            }
            String username = params.get("username");
            if (username != null && !username.isEmpty()) {
                predicates.add(b.equal(root.get("username"), username));
            }

            String ten = params.get("ten");
            if (ten != null && !ten.isEmpty()) {
                predicates.add(b.like(root.get("ten"), String.format("%%%s%%", ten)));
            }

            String ho = params.get("ho");
            if (ho != null && !ho.isEmpty()) {
                predicates.add(b.like(root.get("ho"), String.format("%%%s%%", ho)));
            }

//            String matKhau = params.get("matKhau");
//            if (matKhau != null && !matKhau.isEmpty()) {
//                predicates.add(b.equal(root.get("matKhau"), matKhau));
//            }
            String password = params.get("password");
            if (password != null && !password.isEmpty()) {
                predicates.add(b.equal(root.get("password"), password));
            }

            String vaiTroID = params.get("vaiTroID");
            if (vaiTroID != null && !vaiTroID.isEmpty()) {
                predicates.add(b.equal(root.get("vaiTroID"), Integer.parseInt(vaiTroID)));
            }
            q.where(predicates.toArray(Predicate[]::new));
        }

        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public boolean addOrUpdateUser(Nguoidung n) {
        Session session = this.factory.getObject().getCurrentSession();
        try {
            if (n.getNguoiDungID() == null) {
                session.save(n);
            } else {
                session.update(n);
            }

            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Nguoidung getUserById(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        return session.get(Nguoidung.class, id);
    }

    @Override
    public boolean deleteUser(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        Nguoidung n = this.getUserById(id);
        try {
            session.delete(n);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Nguoidung getUserByUsername(String username) {
        Session session = this.factory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Nguoidung WHERE username = :un");
        q.setParameter("un", username);

        return (Nguoidung) q.getSingleResult();
    }

    @Override
    public boolean registerUser(Nguoidung n) {
        Session session = this.factory.getObject().getCurrentSession();
        try {
            session.save(n);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean authUser(String username, String password) {
        Nguoidung n = this.getUserByUsername(username);

        return this.passEncoder.matches(password, n.getPassword());
    }

    @Override
    public Nguoidung addUser(Nguoidung n) {
        Session s = this.factory.getObject().getCurrentSession();
        s.save(n);

        return n;
    }

    @Override
    public boolean isExistUsername(String username) {
        boolean isExist = false;
        Session session = this.factory.getObject().getCurrentSession();

        Long count = (Long) session.createQuery("SELECT COUNT(n) FROM Nguoidung n WHERE n.username = :un")
                .setParameter("un", username)
                .uniqueResult();
        if (count != 0) {
            isExist = true;
        }

        return isExist;
    }

}
