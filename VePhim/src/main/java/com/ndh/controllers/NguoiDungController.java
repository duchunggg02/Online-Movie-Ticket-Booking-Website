/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndh.controllers;

import com.ndh.pojo.Nguoidung;
import com.ndh.service.NguoiDungService;
import com.ndh.service.VaiTroService;
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
public class NguoiDungController {

    @Autowired
    private NguoiDungService service;

    @Autowired
    private VaiTroService vaiTroService;

    @ModelAttribute
    public void commonAttr(Model model) {
        model.addAttribute("roles", this.vaiTroService.getRoles());
    }

    @RequestMapping("/users")
    public String index(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("users", this.service.getUsers(params));
        return "users";
    }

    @GetMapping("/users/add")
    public String addForm(Model model) {
        model.addAttribute("user", new Nguoidung());
        return "users.addOrUpdate";
    }

    @PostMapping("/users")
    public String add(@ModelAttribute(value = "user") Nguoidung n) {
        if (this.service.addOrUpdateUser(n) == true) {
            return "redirect:/users";
        }

        return "users.addOrUpdate";
    }

    @GetMapping("/users/edit/{id}")
    public String update(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("user", this.service.getUserById(id));
        return "users.addOrUpdate";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new Nguoidung());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute(value = "user") Nguoidung n, Model model) {
        String msg = "";
        if (n.getPassword().equals(n.getConfirmPassword())) {
            if (this.service.registerUser(n) == true) {
                return "redirect:/login";
            } else {
                msg = "Đã có lỗi xảy ra";
            }
        } else {
            msg = "Mật khẩu không trùng khớp";
        }
        model.addAttribute("msg", msg);
        return "register";
    }
}
