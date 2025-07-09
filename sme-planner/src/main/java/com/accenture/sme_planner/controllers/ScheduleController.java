// File: ScheduleController.java
package com.accenture.sme_planner.controllers;

import com.accenture.sme_planner.dtos.ScheduleDTO;
import com.accenture.sme_planner.models.Schedule;
import com.accenture.sme_planner.repositories.ScheduleRepository;
import com.accenture.sme_planner.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    @Autowired
    private ScheduleRepository scheduleRepository;
    @Autowired
    private ScheduleService scheduleService;

    @PostMapping
    public Schedule createSchedule(@RequestBody Schedule schedule) {
        System.out.println("Schedule==="+schedule);
        return scheduleRepository.save(schedule);
    }

    @GetMapping
    public ResponseEntity<List<ScheduleDTO>> getByMonth(@RequestParam String month) {
        List<ScheduleDTO> schedules = scheduleService.getByMonth(month);
        return ResponseEntity.ok(schedules);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Schedule> getById(@PathVariable Long id) {
        Schedule schedule = scheduleService.getById(id);
        return ResponseEntity.ok(schedule);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSchedule(@PathVariable Long id) {
        scheduleService.deleteById(id);
        return ResponseEntity.ok("Schedule deleted successfully");
    }

}
