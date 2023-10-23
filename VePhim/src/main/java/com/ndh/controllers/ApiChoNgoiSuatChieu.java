/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndh.controllers;

import com.ndh.pojo.ChongoiSuatchieu;
import com.ndh.service.ChoNgoiSuatChieuService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Duc Hung
 */
@RestController
@RequestMapping("/api")
public class ApiChoNgoiSuatChieu {

    @Autowired
    private ChoNgoiSuatChieuService service;

//    @GetMapping("/seats/")
//    @CrossOrigin
//    public ResponseEntity<List<ChongoiSuatchieu>> list(@RequestParam Map<String, String> params) {
//        return new ResponseEntity<>(this.service.getBookSeats(params), HttpStatus.OK);
//    }
    
    @GetMapping("/showtimes/{suatChieuID}/seats/")
    @CrossOrigin
    public ResponseEntity<List<ChongoiSuatchieu>> list(@PathVariable(value = "suatChieuID") int id) {
        return new ResponseEntity<>(this.service.getBookSeatsBySuatChieuId(id), HttpStatus.OK);
    }
}
