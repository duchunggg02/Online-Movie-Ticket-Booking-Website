/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndh.repository.impl;

import com.ndh.pojo.Chongoi;
import com.ndh.pojo.Phongchieu;
import com.ndh.repository.PhongChieuRepository;
import java.util.ArrayList;
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
public class PhongChieuRepositoryImpl implements PhongChieuRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Phongchieu> getRooms() {
        Session s = this.factory.getObject().getCurrentSession();

        Query q = s.createQuery("FROM Phongchieu");
        return q.getResultList();
    }

    @Override
    public boolean addOrUpdateRoom(Phongchieu p) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if (p.getPhongChieuID() == null) {
                s.save(p);
                // Tạo danh sách chỗ ngồi
                List<Chongoi> chongoiList = new ArrayList<>();

                // Lặp để thêm số lượng ghế tương ứng
                for (int i = 1; i <= p.getSoLuongGhe(); i++) {
                    Chongoi chongoi = new Chongoi();
                    chongoi.setPhongChieuID(p);
                    chongoi.setSoGhe(String.valueOf(i));
//                    chongoi.setTinhTrang(false); // Chỗ ngồi mới tạo có tình trạng là false
                    chongoiList.add(chongoi);
                }

                // Gán danh sách chỗ ngồi cho phòng chiếu
                p.setChongoiList(chongoiList);
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
    public Phongchieu getRoomById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Phongchieu.class, id);
    }

    @Override
    public boolean deleteRoom(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Phongchieu p = this.getRoomById(id);
        try {
            s.delete(p);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
