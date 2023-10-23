/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndh.formatter;

import com.ndh.pojo.ChongoiSuatchieu;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Duc Hung
 */
public class ChoNgoiSuatChieuFormatter implements Formatter<ChongoiSuatchieu> {

    @Override
    public String print(ChongoiSuatchieu object, Locale locale) {
        return String.valueOf(object.getChoNgoiSuatChieuID());
    }

    @Override
    public ChongoiSuatchieu parse(String choNgoiSuatChieuID, Locale locale) throws ParseException {
        return new ChongoiSuatchieu(Integer.parseInt(choNgoiSuatChieuID));
    }

}
