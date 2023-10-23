/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndh.formatter;

import com.ndh.pojo.Chongoi;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Duc Hung
 */
public class ChoNgoiFormatter implements Formatter<Chongoi> {

    @Override
    public String print(Chongoi object, Locale locale) {
        return String.valueOf(object.getChoNgoiID());
    }

    @Override
    public Chongoi parse(String choNgoiID, Locale locale) throws ParseException {
        return new Chongoi(Integer.parseInt(choNgoiID));
    }

}
