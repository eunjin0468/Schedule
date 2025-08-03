package org.example.scheduly.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.scheduly.dto.ScheduleRequestDto;
import org.example.scheduly.dto.ScheduleResponseDto;
import org.example.scheduly.entity.Schedule;
import org.example.scheduly.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Getter
@Service
public class ScheduleServiceImpl implements ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public ScheduleResponseDto saveSchedule(ScheduleRequestDto dto) {
        //요청받은 데이터로 스케쥴 객체 생성
        Schedule schedule = new Schedule(dto.getName(), dto.getPassword(), dto.getAuthor(), dto.getContents());
        //DB 저장
        Schedule savedSchedule = scheduleRepository.save(schedule);
        return new ScheduleResponseDto(savedSchedule);
    }
}