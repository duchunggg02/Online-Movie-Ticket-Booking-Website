/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndh.formatter;

import com.ndh.pojo.Ve;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Duc Hung
 */
public class VeFormatter implements Formatter<Ve> {

    @Override
    public String print(Ve object, Locale locale) {
        return String.valueOf(object.getVeID());
    }

    @Override
    public Ve parse(String veID, Locale locale) throws ParseException {
        return new Ve(Integer.parseInt(veID));
    }

}
