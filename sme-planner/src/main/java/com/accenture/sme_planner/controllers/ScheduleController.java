// File: ScheduleController.java
package com.accenture.sme_planner.controllers;

import com.accenture.sme_planner.models.Schedule;
import com.accenture.sme_planner.repositories.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @PostMapping
    public Schedule createSchedule(@RequestBody Schedule schedule) {
        System.out.println("Schedule==="+schedule);
        return scheduleRepository.save(schedule);
    }
}
