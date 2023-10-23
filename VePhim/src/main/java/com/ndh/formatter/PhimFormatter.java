/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndh.formatter;

import com.ndh.pojo.Phim;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Duc Hung
 */
public class PhimFormatter implements Formatter<Phim> {

    @Override
    public String print(Phim object, Locale locale) {
        return String.valueOf(object.getPhimID());
    }

    @Override
    public Phim parse(String phimID, Locale locale) throws ParseException {
        return new Phim(Integer.parseInt(phimID));
    }

}
