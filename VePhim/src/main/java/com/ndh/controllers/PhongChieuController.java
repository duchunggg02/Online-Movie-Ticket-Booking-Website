/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndh.controllers;

import com.ndh.pojo.Chongoi;
import com.ndh.pojo.Phongchieu;
import com.ndh.service.ChoNgoiService;
import com.ndh.service.PhongChieuService;
import com.ndh.service.RapPhimService;
import java.util.List;
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
public class PhongChieuController {

    @Autowired
    private PhongChieuService service;

    @Autowired
    private RapPhimService rapPhimService;

    @Autowired
    private ChoNgoiService choNgoiService;

    @ModelAttribute
    public void commonAttr(Model model) {
        model.addAttribute("theaters", this.rapPhimService.getTheaters());
    }

    @RequestMapping("/rooms")
    public String index(Model model) {
        model.addAttribute("rooms", this.service.getRooms());
        return "rooms";
    }

    @GetMapping("/rooms/add")
    public String addForm(Model model) {
        model.addAttribute("room", new Phongchieu());
        return "rooms.addOrUpdate";
    }

    @PostMapping("/rooms")
    public String add(@ModelAttribute(value = "room") Phongchieu p) {
        if (this.service.addOrUpdateRoom(p) == true) {
            return "redirect:/rooms";
        }

        return "rooms.addOrUpdate";
    }

    @GetMapping("/rooms/edit/{id}")
    public String update(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("room", this.service.getRoomById(id));
        return "rooms.addOrUpdate";
    }

    @GetMapping("/ghe")
    public String listGhe(Model model) {
        List<Chongoi> chongoiList = this.choNgoiService.getSeats();// Lấy danh sách ghế từ repository hoặc service
        model.addAttribute("chongoiList", chongoiList);
        return "ghe"; // Trả về tên JSP để hiển thị danh sách ghế
    }
}
