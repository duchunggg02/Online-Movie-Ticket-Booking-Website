/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndh.controllers;

import com.ndh.service.NguoiDungService;
import com.ndh.service.PhanHoiService;
import com.ndh.service.PhimService;
import com.ndh.service.PhongChieuService;
import com.ndh.service.RapPhimService;
import com.ndh.service.SuatChieuService;
import com.ndh.service.VaiTroService;
import com.ndh.service.VeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Duc Hung
 */
@RestController
public class ApiDeleteController {

    @Autowired
    private NguoiDungService service;

    @Autowired
    private VaiTroService vaiTroService;

    @Autowired
    private RapPhimService rapPhimService;

    @Autowired
    private PhimService phimService;

    @Autowired
    private PhongChieuService phongChieuService;

    @Autowired
    private SuatChieuService suatChieuService;

    @Autowired
    private VeService veService;

    @Autowired
    private PhanHoiService phanHoiService;

    @DeleteMapping("/users/edit/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable(value = "id") int id) {
        this.service.deleteUser(id);
    }

    @DeleteMapping("/roles/edit/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRole(@PathVariable(value = "id") int id) {
        this.vaiTroService.deleteRole(id);
    }

    @DeleteMapping("/theaters/edit/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTheater(@PathVariable(value = "id") int id) {
        this.rapPhimService.deleteTheater(id);
    }

    @DeleteMapping("/movies/edit/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMovie(@PathVariable(value = "id") int id) {
        this.phimService.deleteMovie(id);
    }

    @DeleteMapping("/rooms/edit/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRoom(@PathVariable(value = "id") int id) {
        this.phongChieuService.deleteRoom(id);
    }

    @DeleteMapping("/showtimes/edit/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteShowtime(@PathVariable(value = "id") int id) {
        this.suatChieuService.deteleShowtime(id);
    }

    @DeleteMapping("/tickets/edit/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTicket(@PathVariable(value = "id") int id) {
        this.veService.deleteTicket(id);
    }

    @DeleteMapping("/feedbacks/edit/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFeedback(@PathVariable(value = "id") int id) {
        this.phanHoiService.deleteFeedback(id);
    }
}
