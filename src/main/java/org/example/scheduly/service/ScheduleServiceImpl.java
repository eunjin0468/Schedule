package org.example.scheduly.service;

import org.example.scheduly.dto.ScheduleRequestDto;
import org.example.scheduly.dto.ScheduleResponseDto;
import org.example.scheduly.entity.Schedule;
import org.example.scheduly.repository.ScheduleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public ScheduleResponseDto saveSchedule(ScheduleRequestDto dto) {
        Schedule schedule = new Schedule(
                dto.getName(),
                dto.getPassword(),
                dto.getTitle(),
                dto.getContents()
        );
        Schedule savedSchedule = scheduleRepository.saveSchedule(schedule); // 커스텀 메서드 사용
        return new ScheduleResponseDto(savedSchedule);
    }

    @Override
    public List<ScheduleResponseDto> findAllSchedules() {
        return scheduleRepository.findAllSchedules(); // 커스텀 메서드 사용
    }

    @Override
    public ScheduleResponseDto findScheduleById(Long id) {
        Schedule schedule = scheduleRepository.findScheduleById(id); // 커스텀 메서드 사용
        if (schedule == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id= " + id);
        }
        return new ScheduleResponseDto(schedule);
    }

    @Override
    public ScheduleResponseDto update(Long id, String title, String contents) {
        Schedule schedule = scheduleRepository.findScheduleById(id);
        if (schedule == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id= " + id);
        }
        if (title == null || contents == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The title and contents are required values");
        }
        schedule.update(title, contents);
        return new ScheduleResponseDto(schedule);
    }

}
