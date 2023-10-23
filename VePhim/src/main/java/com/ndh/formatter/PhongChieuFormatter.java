/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndh.formatter;

import com.ndh.pojo.Phongchieu;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Duc Hung
 */
public class PhongChieuFormatter implements Formatter<Phongchieu> {

    @Override
    public String print(Phongchieu object, Locale locale) {
        return String.valueOf(object.getPhongChieuID());
    }

    @Override
    public Phongchieu parse(String phongChieuID, Locale locale) throws ParseException {
        return new Phongchieu(Integer.parseInt(phongChieuID));
    }

}
