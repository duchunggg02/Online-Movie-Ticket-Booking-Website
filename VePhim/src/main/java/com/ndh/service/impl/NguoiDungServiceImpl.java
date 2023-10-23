/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndh.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ndh.pojo.Nguoidung;
import com.ndh.pojo.Vaitro;
import com.ndh.repository.NguoiDungRepository;
import com.ndh.repository.VaiTroRepository;
import com.ndh.service.NguoiDungService;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Duc Hung
 */
@Service
public class NguoiDungServiceImpl implements NguoiDungService {

    @Autowired
    private NguoiDungRepository repository;

    @Autowired
    private VaiTroRepository vaiTroRepository;
    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<Nguoidung> getUsers(Map<String, String> params) {
        return this.repository.getUsers(params);
    }

    @Override
    public boolean addOrUpdateUser(Nguoidung n) {
        if (!n.getFile().isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(n.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                n.setHinhDaiDien(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(NguoiDungServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (n.getNguoiDungID() == null) {
            String encodedPassword = passwordEncoder.encode(n.getPassword());
            n.setPassword(encodedPassword);
        }

        return this.repository.addOrUpdateUser(n);
    }

    @Override
    public Nguoidung getUserById(int id) {
        return this.repository.getUserById(id);
    }

    @Override
    public boolean deleteUser(int id) {
        return this.repository.deleteUser(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Nguoidung n = this.repository.getUserByUsername(username);
        if (n == null) {
            throw new UsernameNotFoundException("Invalid");
        }
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(n.getVaiTroID().getTenVaiTro()));
        return new org.springframework.security.core.userdetails.User(
                n.getUsername(), n.getPassword(), authorities);

    }

    @Override
    public boolean registerUser(Nguoidung n) {
        if (!n.getFile().isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(n.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                n.setHinhDaiDien(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(NguoiDungServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        Vaitro v = this.vaiTroRepository.getRoleById(2);

        String encodedPassword = passwordEncoder.encode(n.getPassword());
        n.setPassword(encodedPassword);
        n.setVaiTroID(v);

        return this.repository.registerUser(n);
    }

    @Override
    public boolean authUser(String username, String password) {
        return this.repository.authUser(username, password);
    }

    @Override
    public Nguoidung getUserByUsername(String username) {
        return this.repository.getUserByUsername(username);
    }

    @Override
    public Nguoidung addUser(Map<String, String> params, MultipartFile avatar) {
        Nguoidung n = new Nguoidung();
        n.setTen(params.get("ten"));
        n.setHo(params.get("ho"));
        n.setUsername(params.get("username"));
        n.setPassword(this.passwordEncoder.encode(params.get("password")));

        Vaitro v = this.vaiTroRepository.getRoleById(2);
        n.setVaiTroID(v);
        if (!avatar.isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(avatar.getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
                n.setHinhDaiDien(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(NguoiDungServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        this.repository.addUser(n);
        return n;
    }

    @Override
    public boolean isExistUsername(String username) {
        return this.repository.isExistUsername(username);
    }

}
