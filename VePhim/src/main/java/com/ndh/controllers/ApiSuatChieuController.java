/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndh.controllers;

import com.ndh.pojo.Suatchieu;
import com.ndh.service.SuatChieuService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Duc Hung
 */
@RestController
@RequestMapping("/api")
public class ApiSuatChieuController {

    @Autowired
    private SuatChieuService service;

    @RequestMapping(path = "/showtimes/{suatChieuID}/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<Suatchieu> list(@PathVariable(value = "suatChieuID") int id) {
        return new ResponseEntity<>(this.service.getShowtimeById(id), HttpStatus.OK);
    }
    
    @GetMapping("/movies/{phimID}/showtimes/")
    @CrossOrigin
    public ResponseEntity<List<Suatchieu>> listShowtimes(@PathVariable(value = "phimID") int id) {
        return new ResponseEntity<>(this.service.getShowtimeByPhimId(id), HttpStatus.OK);
    }
}
