/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndh.formatter;

import com.ndh.pojo.Rapphim;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Duc Hung
 */
public class RapPhimFormatter implements Formatter<Rapphim> {

    @Override
    public String print(Rapphim object, Locale locale) {
        return String.valueOf(object.getRapPhimID());
    }

    @Override
    public Rapphim parse(String rapPhimID, Locale locale) throws ParseException {
        return new Rapphim(Integer.parseInt(rapPhimID));
    }

}
