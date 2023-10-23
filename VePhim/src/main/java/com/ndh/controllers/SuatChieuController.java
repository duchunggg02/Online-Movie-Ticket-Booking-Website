/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndh.controllers;

import com.ndh.pojo.Suatchieu;
import com.ndh.service.PhimService;
import com.ndh.service.PhongChieuService;
import com.ndh.service.SuatChieuService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Duc Hung
 */
@Controller
@Transactional
public class SuatChieuController {

    @Autowired
    private SuatChieuService service;

    @Autowired
    private PhimService phimService;

    @Autowired
    private PhongChieuService phongChieuService;

    @ModelAttribute
    public void commonAttr(Model model,@RequestParam Map<String, String> params) {
        model.addAttribute("movies", this.phimService.getMovies(params));
        model.addAttribute("rooms", this.phongChieuService.getRooms());
    }

    @RequestMapping("/showtimes")
    public String index(Model model,  @RequestParam Map<String, String> params) {
        model.addAttribute("showtimes", this.service.getShowtimes(params));
        return "showtimes";
    }

    @GetMapping("/showtimes/add")
    public String addForm(Model model) {
        model.addAttribute("showtime", new Suatchieu());
        return "showtimes.addOrUpdate";
    }

    @PostMapping("/showtimes")
    public String add(@ModelAttribute(value = "showtime") Suatchieu s) {
        if (this.service.addOrUpdateShowtime(s) == true) {
            return "redirect:/showtimes";
        }
        return "showtimes.addOrUpdate";
    }

    @GetMapping("/showtimes/edit/{id}")
    public String update(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("showtime", this.service.getShowtimeById(id));
        return "showtimes.addOrUpdate";
    }
}
