// File: ScheduleRepository.java
package com.accenture.sme_planner.repositories;

import com.accenture.sme_planner.models.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {


}
