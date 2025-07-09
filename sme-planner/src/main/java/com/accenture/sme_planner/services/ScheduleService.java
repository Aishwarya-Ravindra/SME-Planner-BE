package com.accenture.sme_planner.services;

import com.accenture.sme_planner.dtos.ScheduleDTO;
import com.accenture.sme_planner.models.Schedule;
import com.accenture.sme_planner.repositories.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;

    public List<ScheduleDTO> getByMonth(String month) {
        List<Schedule> schedules =  scheduleRepository.findByMonth(month);
        return schedules.stream()
                .map(s -> new ScheduleDTO(
                        s.getId(), s.getActivity(), s.getFromDate(), s.getToDate(),
                        s.getFromTime(), s.getToTime(), s.getShortDescription()
                ))
                .toList();// ✅ OK
    }

    public Schedule getById(Long id){
        return  scheduleRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Schedule not found"));
    }

    public void deleteById(Long id) {
        if (!scheduleRepository.existsById(id)) {
            throw new RuntimeException("Schedule with id " + id + " not found");
        }
        scheduleRepository.deleteById(id);
    }


}
