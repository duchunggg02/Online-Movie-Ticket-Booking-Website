/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ndh.repository;

import com.ndh.pojo.Ve;
import java.util.List;

/**
 *
 * @author Duc Hung
 */
public interface VeRepository {

    List<Ve> getTickets();
    boolean addOrUpdateTicket(Ve v, List<Integer> selectedSeatIds);
    Ve getTicketById(int id);
    boolean deleteTicket(int id);
    Ve addTicket(Ve v, List<Integer> selectedSeatIds);
    //Ve addTicket(Ve v);
    List<Ve> getTicketByUserID(int id);
}
