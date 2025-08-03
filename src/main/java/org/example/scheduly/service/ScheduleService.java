package org.example.scheduly.service;

import org.example.scheduly.dto.ScheduleRequestDto;
import org.example.scheduly.dto.ScheduleResponseDto;
import org.springframework.stereotype.Service;


@Service
public interface ScheduleService {
    ScheduleResponseDto saveSchedule(ScheduleRequestDto dto);

}