package com.mydaytodo.scheduling;

import com.mydaytodo.scheduling.model.Schedule;
import com.mydaytodo.scheduling.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    /**
     * Set default scheduyle to print some text
     * to console in 5 mins
     * @return
     */
    @GetMapping("/default")
    public ResponseEntity<HttpStatus> defaultSchedule() {
        scheduleService.setDefaultSchedule();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Object> setScheduleFor(@RequestBody Schedule schedule) {
        scheduleService.setSchedule(schedule);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
