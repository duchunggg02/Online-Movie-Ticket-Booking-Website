/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndh.controllers;

import com.ndh.pojo.Nguoidung;
import com.ndh.pojo.Phim;
import com.ndh.service.PhimService;
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
public class PhimController {

    @Autowired
    private PhimService service;

    @RequestMapping("/movies")
    public String index(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("movies", this.service.getMovies(params));
        return "movies";
    }

    @GetMapping("/movies/add")
    public String addForm(Model model) {
        model.addAttribute("movie", new Phim());
        return "movies.addOrUpdate";
    }

    @PostMapping("/movies")
    public String add(@ModelAttribute(value = "movie") Phim p) {
        if (this.service.addOrUpdateMovie(p) == true) {
            return "redirect:/movies";
        }

        return "movies.addOrUpdate";
    }

    @GetMapping("/movies/edit/{id}")
    public String update(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("movie", this.service.getMovieById(id));
        return "movies.addOrUpdate";
    }
}
