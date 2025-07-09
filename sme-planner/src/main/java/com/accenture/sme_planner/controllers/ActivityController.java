package com.accenture.sme_planner.controllers;

import com.accenture.sme_planner.enums.ActivityType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/activities")
public class ActivityController {

    @GetMapping
    public ActivityType[] getActivityTypes() {
        return ActivityType.values();
    }
}
