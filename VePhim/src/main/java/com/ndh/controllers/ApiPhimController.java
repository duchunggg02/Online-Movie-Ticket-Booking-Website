/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndh.controllers;

import com.ndh.pojo.Phim;
import com.ndh.service.PhimService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
public class ApiPhimController {

    @Autowired
    private PhimService service;

    @GetMapping("/movies/")
    @CrossOrigin
    public ResponseEntity<List<Phim>> list(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.service.getMovies(params), HttpStatus.OK);
    }
    
    @RequestMapping(path = "/movies/{phimID}/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<Phim> details(@PathVariable(value = "phimID") int id) {
        return new ResponseEntity<>(this.service.getMovieById(id), HttpStatus.OK);
    }
}
