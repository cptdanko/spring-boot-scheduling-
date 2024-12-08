package com.mydaytodo.scheduling.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@ToString
@Data
@Builder
@Slf4j
public class Schedule {
    // optional
    private String message;
    // @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss a")
    private String scheduleDate;
    private String name;

    public Date scheduleToDate() throws ParseException {
        DateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm a", Locale.ENGLISH);
        log.info("About to parse schedule date, {}", scheduleDate);
        return formatter.parse(scheduleDate);
    }
}
