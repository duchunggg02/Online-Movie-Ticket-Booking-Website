/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndh.formatter;

import com.ndh.pojo.Vaitro;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Duc Hung
 */
public class VaiTroFormatter implements Formatter<Vaitro> {

    @Override
    public String print(Vaitro object, Locale locale) {
        return String.valueOf(object.getVaiTroID());
    }

    @Override
    public Vaitro parse(String vaiTroID, Locale locale) throws ParseException {
        return new Vaitro(Integer.parseInt(vaiTroID));
    }

}
