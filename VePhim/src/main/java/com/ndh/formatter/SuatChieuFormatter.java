/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndh.formatter;

import com.ndh.pojo.Suatchieu;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Duc Hung
 */
public class SuatChieuFormatter implements Formatter<Suatchieu> {

    @Override
    public String print(Suatchieu object, Locale locale) {
        return String.valueOf(object.getSuatChieuID());
    }

    @Override
    public Suatchieu parse(String suatChieuID, Locale locale) throws ParseException {
        return new Suatchieu(Integer.parseInt(suatChieuID));
    }

}
