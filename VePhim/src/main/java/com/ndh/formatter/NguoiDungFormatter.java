/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndh.formatter;

import com.ndh.pojo.Nguoidung;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Duc Hung
 */
public class NguoiDungFormatter implements Formatter<Nguoidung> {

    @Override
    public String print(Nguoidung object, Locale locale) {
        return String.valueOf(object.getNguoiDungID());
    }

    @Override
    public Nguoidung parse(String nguoiDungID, Locale locale) throws ParseException {
        return new Nguoidung(Integer.parseInt(nguoiDungID));
    }

}
