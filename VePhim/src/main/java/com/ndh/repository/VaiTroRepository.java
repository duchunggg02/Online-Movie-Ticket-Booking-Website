/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ndh.repository;

import com.ndh.pojo.Vaitro;
import java.util.List;

/**
 *
 * @author Duc Hung
 */
public interface VaiTroRepository {

    List<Vaitro> getRoles();
    boolean addOrUpdateRole(Vaitro v);
    Vaitro getRoleById(int id);
    boolean deleteRole(int id);
}
