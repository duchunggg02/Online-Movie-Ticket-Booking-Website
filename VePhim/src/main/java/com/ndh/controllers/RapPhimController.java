/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndh.controllers;

import com.ndh.pojo.Rapphim;
import com.ndh.service.RapPhimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Duc Hung
 */
@Controller
@Transactional
public class RapPhimController {

    @Autowired
    private RapPhimService service;

    @RequestMapping("/theaters")
    public String index(Model model) {
        model.addAttribute("theaters", this.service.getTheaters());
        return "theaters";
    }

    @GetMapping("/theaters/add")
    public String addForm(Model model) {
        model.addAttribute("theater", new Rapphim());
        return "theaters.addOrUpdate";
    }

    @PostMapping("/theaters")
    public String add(@ModelAttribute(value = "theater") Rapphim r) {
        if (this.service.addOrUpdateTheater(r) == true) {
            return "redirect:/theaters";
        }

        return "theaters.addOrUpdate";
    }

    @GetMapping("/theaters/edit/{id}")
    public String update(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("theater", this.service.getTheaterById(id));
        return "theaters.addOrUpdate";
    }
}
