/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndh.myObject;

import com.ndh.pojo.Ve;
import java.util.List;

/**
 *
 * @author Duc Hung
 */
public class BookingRequest {

    private Ve ve;
    private List<Integer> selectedSeatIds;

    /**
     * @return the ve
     */
    public Ve getVe() {
        return ve;
    }

    /**
     * @param ve the ve to set
     */
    public void setVe(Ve ve) {
        this.ve = ve;
    }

    /**
     * @return the selectedSeatIds
     */
    public List<Integer> getSelectedSeatIds() {
        return selectedSeatIds;
    }

    /**
     * @param selectedSeatIds the selectedSeatIds to set
     */
    public void setSelectedSeatIds(List<Integer> selectedSeatIds) {
        this.selectedSeatIds = selectedSeatIds;
    }
}
