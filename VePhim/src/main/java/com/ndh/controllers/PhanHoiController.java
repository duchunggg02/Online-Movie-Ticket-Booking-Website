/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndh.controllers;

import com.ndh.pojo.Phanhoi;
import com.ndh.pojo.Ve;
import com.ndh.service.PhanHoiService;
import com.ndh.service.VeService;
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
public class PhanHoiController {
    
    @Autowired
    private PhanHoiService service;
    
    @Autowired
    private VeService veService;
    
    @RequestMapping("/feedbacks")
    public String index(Model model) {
        model.addAttribute("feedbacks", this.service.getFeedbacks());
        return "feedbacks";
    }
    
    @GetMapping("/feedbacks/add")
    public String addForm(Model model, @RequestParam("ticketId") int ticketId) {
        Phanhoi p = new Phanhoi();
        Ve v = this.veService.getTicketById(ticketId);
        p.setVeID(v);
        model.addAttribute("feedback", p);
        return "feedbacks.addOrUpdate";
    }
    
    @PostMapping("/feedbacks")
    public String add(@ModelAttribute(value = "feedback") Phanhoi p) {
        if (this.service.addOrUpdateFeedback(p) == true) {
            return "redirect:/feedbacks";
        }
        
        return "feedbacks.addOrUpdate";
    }
    
    @GetMapping("/feedbacks/edit/{id}")
    public String update(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("feedback", this.service.getFeedbackById(id));
        return "feedbacks.addOrUpdate";
    }
}
