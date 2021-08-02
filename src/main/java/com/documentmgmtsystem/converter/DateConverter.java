package com.documentmgmtsystem.converter;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DateConverter {
    public String convertToString(Date date)
    {
        String tempDate = String.valueOf(date);
        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("DD//MM/YYYY");
        return tempDate;
    }
    public Date convertToDate(String date) throws ParseException
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("DD/MM/YYYY");
        Date date1 = simpleDateFormat.parse(date);
        return date1;
    }
}
