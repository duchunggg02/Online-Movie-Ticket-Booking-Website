/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndh.controllers;

import com.ndh.components.JwtService;
import com.ndh.pojo.Nguoidung;
import com.ndh.service.NguoiDungService;
import java.security.Principal;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Duc Hung
 */
@RestController
@RequestMapping("/api")
public class ApiNguoiDungController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private NguoiDungService userService;

    @PostMapping("/login/")
    @CrossOrigin
    public ResponseEntity<String> login(@RequestBody Nguoidung user) {
        if (this.userService.authUser(user.getUsername(), user.getPassword()) == true) {
            String token = this.jwtService.generateTokenLogin(user.getUsername());

            return new ResponseEntity<>(token, HttpStatus.OK);
        }

        return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
    }

//    @PostMapping("/test/")
//    @CrossOrigin(origins = {"127.0.0.1:5500"})
//    public ResponseEntity<String> test(Principal pricipal) {
//        return new ResponseEntity<>("SUCCESSFUL", HttpStatus.OK);
//    }

    @PostMapping(path = "/users/",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin
    public ResponseEntity<Nguoidung> addUser(@RequestParam Map<String, String> params, @RequestPart MultipartFile avatar) {
        Nguoidung user = this.userService.addUser(params, avatar);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping(path = "/current-user/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<Nguoidung> details(Principal user) {
        Nguoidung u = this.userService.getUserByUsername(user.getName());
        return new ResponseEntity<>(u, HttpStatus.OK);
    }
    
    @GetMapping("/users/check-username/")
    @CrossOrigin
    public ResponseEntity<String> isExistUsername(@RequestParam String username) {
        if (this.userService.isExistUsername(username) == false) {
            

            return new ResponseEntity<>("SUCCESSFUL", HttpStatus.OK);
        }

        return new ResponseEntity<>( "ERROR",HttpStatus.OK);
    }
}
