package com.accenture.sme_planner.repositories;

import com.accenture.sme_planner.models.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    List<Schedule> findByMonth(String month);

}
