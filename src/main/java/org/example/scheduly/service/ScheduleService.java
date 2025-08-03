package org.example.scheduly.service;

import org.example.scheduly.dto.ScheduleRequestDto;
import org.example.scheduly.dto.ScheduleResponseDto;

import java.util.List;

public interface ScheduleService {
    ScheduleResponseDto saveSchedule(ScheduleRequestDto dto);
    List<ScheduleResponseDto> findAllSchedules();
    ScheduleResponseDto findScheduleById(Long id);
}
