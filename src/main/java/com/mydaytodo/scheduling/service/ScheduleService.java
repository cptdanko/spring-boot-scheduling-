package com.mydaytodo.scheduling.service;

import com.mydaytodo.scheduling.model.Schedule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ScheduleService {

    public Object setSchedule(Schedule schedule) {
        log.info("Received a request to set schedule");
        return null;
    }

    public HttpStatus setDefaultSchedule() {
        log.info("received a request to set default schedule");
        return null;
    }
}
