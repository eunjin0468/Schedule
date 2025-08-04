package org.example.scheduly.repository;

import org.example.scheduly.dto.ScheduleResponseDto;
import org.example.scheduly.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface ScheduleRepository{
    List<ScheduleResponseDto> findAllSchedules();

    Schedule findScheduleById(Long id);
    Schedule saveSchedule(Schedule schedule);
}
