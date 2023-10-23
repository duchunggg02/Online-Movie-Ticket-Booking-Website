/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndh.service.impl;

import com.ndh.pojo.Vaitro;
import com.ndh.repository.VaiTroRepository;
import com.ndh.service.VaiTroService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Duc Hung
 */
@Service
public class VaiTroServiceImpl implements VaiTroService {

    @Autowired
    private VaiTroRepository repository;
    
    @Override
    public List<Vaitro> getRoles() {
        return this.repository.getRoles();
    }

    @Override
    public boolean addOrUpdateRole(Vaitro v) {
        return this.repository.addOrUpdateRole(v);
    }

    @Override
    public Vaitro getRoleById(int id) {
        return this.repository.getRoleById(id);
    }

    @Override
    public boolean deleteRole(int id) {
        return this.repository.deleteRole(id);
    }

}
