package com.linameritha.myapplication.Fitur.Siswa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParser {
    public static Date parseToDate(String date){
        Date target;
        SimpleDateFormat source = new SimpleDateFormat("yyyy-MM-dd");
        try {
            target = source.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            target = new Date();
        }
        return target;
    }

    public static Date now(){
        return new Date();
    }
}
