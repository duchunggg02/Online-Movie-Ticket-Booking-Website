/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndh.controllers;

import com.ndh.myObject.BookingRequest;
import com.ndh.pojo.ChongoiSuatchieu;
import com.ndh.pojo.Nguoidung;
import com.ndh.pojo.Phim;
import com.ndh.pojo.Suatchieu;
import com.ndh.pojo.Ve;
import com.ndh.repository.NguoiDungRepository;
import com.ndh.service.SuatChieuService;
import com.ndh.service.VeService;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.print.attribute.standard.Media;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Duc Hung
 */
@RestController
@RequestMapping("/api")
public class ApiVeController {

    @Autowired
    private VeService veService;

    @Autowired
    private SuatChieuService scSerive;
    

    @GetMapping("/tickets/")
    @CrossOrigin
    public ResponseEntity<List<Ve>> list(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.veService.getTickets(), HttpStatus.OK);
    }

    @PostMapping(path = "/tickets/add/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Ve> addTicket(@RequestBody Map<String, Object> requestData) {
        Ve ve = new Ve();
        Integer suatChieuID = (Integer) requestData.get("suatChieuID");
        Suatchieu sc = this.scSerive.getShowtimeById(suatChieuID);
        ve.setSuatChieuID(sc);
        List<Integer> list = (List<Integer>) requestData.get("selectedSeatIds");

        Ve v = this.veService.addTicket(ve, list);
        return new ResponseEntity<>(v, HttpStatus.CREATED);
    }

//    @PostMapping(path = "/ticket/add/", produces = MediaType.APPLICATION_JSON_VALUE)
//    @CrossOrigin
//    @ResponseStatus(HttpStatus.CREATED)
//    public ResponseEntity<Ve> addTicket(@RequestBody Ve ve) {
//        Ve v = this.veService.addTicket(ve);
//        return new ResponseEntity<>(v, HttpStatus.CREATED);
//    }
    
    @GetMapping("/users/{nguoiDungID}/tickets/")
    @CrossOrigin
    public ResponseEntity<List<Ve>> list(@PathVariable(value = "nguoiDungID") int id) {
        return new ResponseEntity<>(this.veService.getTicketByUserID(id), HttpStatus.OK);
    }
    
    @RequestMapping(path = "/tickets/{veID}/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<Ve> details(@PathVariable(value = "veID") int id) {
        return new ResponseEntity<>(this.veService.getTicketById(id), HttpStatus.OK);
    }
}
