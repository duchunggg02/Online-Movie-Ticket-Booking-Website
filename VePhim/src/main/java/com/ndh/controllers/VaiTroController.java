/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndh.controllers;

import com.ndh.pojo.Vaitro;
import com.ndh.service.VaiTroService;
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
public class VaiTroController {

    @Autowired
    private VaiTroService service;

    @RequestMapping("/roles")
    public String index(Model model) {
        model.addAttribute("roles", this.service.getRoles());
        return "roles";
    }

    @GetMapping("/roles/add")
    public String addForm(Model model) {
        model.addAttribute("role", new Vaitro());
        return "roles.addOrUpdate";
    }

    @PostMapping("/roles")
    public String add(@ModelAttribute(value = "role") Vaitro v) {
        if (this.service.addOrUpdateRole(v) == true) {
            return "redirect:/roles";
        }

        return "roles.addOrUpdate";
    }

    @GetMapping("/roles/edit/{id}")
    public String update(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("role", this.service.getRoleById(id));
        return "roles.addOrUpdate";
    }
}
