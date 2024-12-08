package com.mydaytodo.scheduling.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;

@Slf4j
@Data
@Builder
public class PrintTask implements Runnable {
    private Schedule schedule;

    @Override
    public void run() {
        String msg = String.format("About to perform the task for %s \n and " +
                "the message is %s", schedule.getName(), schedule.getMessage());
        log.info(msg);
        log.info("The time now is {} and the schedule was set for {}", Instant.now().toString(),
                schedule.getScheduleDate());
        System.out.println("Running the schedule at - "+ msg);
    }
}
