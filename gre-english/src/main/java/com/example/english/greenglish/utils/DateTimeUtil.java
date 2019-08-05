package com.example.english.greenglish.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;

import static com.example.english.greenglish.utils.ApiConstant.DATE_AND_TIME_FORMAT;
import static com.example.english.greenglish.utils.ApiConstant.DATE_FORMAT;


/**
 * This class is used to convert localDateTime in String
 */
public class DateTimeUtil
{

    private DateTimeUtil(){}

    public static String convertLocalDateTimeToString(LocalDateTime localDateTime){
        if(localDateTime == null){ return null; }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_AND_TIME_FORMAT);
        return localDateTime.format(formatter);
    }

    public static String convertLocalDateToString(LocalDate localDate){
        if (localDate==null){ return  null; }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        return localDate.format(formatter);
    }

    public static LocalDateTime convertStringToLocalDateTime(String dateAndTimeInString){
        if (dateAndTimeInString == null){ return  null; }
        String convertedDateTime = dateAndTimeInString.replace('T',' ');
        DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern(DATE_AND_TIME_FORMAT)
                .parseDefaulting(ChronoField.HOUR_OF_DAY, 0).parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
                .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0).toFormatter();
        try {
            return LocalDateTime.parse(convertedDateTime, formatter);
        } catch (DateTimeParseException ex){
           return null;
        }
    }

    public static LocalDate convertStringToLocalDate(String localDate){
        if (localDate==null){ return  null; }
        try {
            return LocalDate.parse(localDate, DateTimeFormatter.ofPattern(DATE_FORMAT));
        } catch (DateTimeParseException ex){
            return null;
        }
    }

}

