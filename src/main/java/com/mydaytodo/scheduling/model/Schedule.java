package com.mydaytodo.scheduling.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@ToString
@Data
@Builder
public class Schedule {
    // optional
    private String message;
    private Date scheduleDate;
}
