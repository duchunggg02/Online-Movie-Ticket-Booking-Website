/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndh.controllers;

import com.ndh.pojo.ChongoiSuatchieu;
import com.ndh.pojo.ChongoiVe;
import com.ndh.pojo.Suatchieu;
import com.ndh.pojo.Ve;
import com.ndh.service.ChoNgoiSuatChieuService;
import com.ndh.service.NguoiDungService;
import com.ndh.service.SuatChieuService;
import com.ndh.service.VeService;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
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
public class VeController {

    @Autowired
    private VeService service;

    @Autowired
    private SuatChieuService suatChieuService;

    @Autowired
    private NguoiDungService nguoiDungService;

    @Autowired
    private ChoNgoiSuatChieuService choNgoiService;

    @ModelAttribute
    public void commonAttr(Model model) {
        model.addAttribute("users", this.nguoiDungService.getUsers(null));
    }

    @RequestMapping("/tickets")
    public String index(Model model) {
        model.addAttribute("tickets", this.service.getTickets());
        return "tickets";
    }

    @GetMapping("/tickets/booking/{suatChieuID}")
    public String addForm(Model model, @PathVariable int suatChieuID) {
        Ve newVe = new Ve();
        newVe.setVeID(null);
        model.addAttribute("ticket", newVe);
        Suatchieu sc = this.suatChieuService.getShowtimeById(suatChieuID);
        model.addAttribute("showtime", sc);
        model.addAttribute("seats", this.choNgoiService.getBookSeatsBySuatChieu(sc));
        return "tickets.addOrUpdate";
    }

//    @PostMapping("/tickets")
//    public String add(@ModelAttribute(value = "ticket") Ve v) {
//        if (this.service.addOrUpdateTicket(v) == true) {
//            return "redirect:/tickets";
//        }
//
//        return "tickets.addOrUpdate";
//    }
    @PostMapping("/tickets")
    public String add(@ModelAttribute(value = "ticket") Ve v, HttpServletRequest request) {
        String[] selectedSeatIds = request.getParameterValues("choNgoiSuatChieuID");

        List<Integer> selectedSeats = Arrays.stream(selectedSeatIds)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        
        if (this.service.addOrUpdateTicket(v, selectedSeats) == true) {
            return "redirect:/tickets";
        }

        return "redirect:/tickets";

    }

}
