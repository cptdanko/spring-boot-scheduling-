package com.mydaytodo.scheduling.controller;

import com.mydaytodo.scheduling.model.Schedule;
import com.mydaytodo.scheduling.service.ScheduleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/api/schedule")
@Slf4j
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    /**
     * @param schedule
     * @return
     * @throws ParseException
     */
    @PostMapping("/")
    public ResponseEntity<Object> setScheduleFor(@RequestBody Schedule schedule) throws ParseException {

        log.info("Received request to set schedule for {}", schedule.toString());
        log.info(schedule.toString());
        var scheduleSet = scheduleService.setSchedule(schedule);
        log.info("Set Schedule for {}", scheduleSet.toString());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
