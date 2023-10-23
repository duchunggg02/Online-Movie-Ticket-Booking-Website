/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndh.controllers;

import com.ndh.pojo.Phanhoi;
import com.ndh.service.PhanHoiService;
import com.ndh.service.VeService;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Duc Hung
 */
@RestController
@RequestMapping("/api")
public class ApiPhanHoiController {

    @Autowired
    private PhanHoiService service;
    
    @Autowired
    private VeService veService;

    @GetMapping("movies/{phimID}/feedbacks/")
    @CrossOrigin
    public ResponseEntity<List<Phanhoi>> listFeedbacks(@PathVariable(value = "phimID") int id) {
        return new ResponseEntity<>(this.service.getFeedbackByPhimId(id), HttpStatus.OK);
    }
    
    @PostMapping(path="/feedbacks/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<Phanhoi> addComment(@RequestBody Phanhoi phanHoi) {
        Phanhoi p = this.service.addFeedback(phanHoi);
        
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }
}
