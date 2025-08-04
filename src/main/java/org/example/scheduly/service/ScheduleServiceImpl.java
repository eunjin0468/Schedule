package org.example.scheduly.service;

import org.example.scheduly.dto.ScheduleRequestDto;
import org.example.scheduly.dto.ScheduleResponseDto;
import org.example.scheduly.entity.Schedule;
import org.example.scheduly.repository.ScheduleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
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
                dto.getContents(),
                dto.getAuthor()
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
    public ScheduleResponseDto update(Long id, String title, String name, String password) {
        Schedule schedule = scheduleRepository.findScheduleById(id);

        if (schedule == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id= " + id);
        }

        if (password == null || !password.equals(schedule.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Password mismatch");
        }

        if (title == null || name == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Title and name are required");
        }

        // 일정 제목과 작성자명만 수정
        schedule.update(title, name);

        // 수정일자 갱신
        schedule.setModifiedAt(LocalDateTime.now());

        return new ScheduleResponseDto(schedule);
    }

    @Override
    public void deleteSchedule(Long id, String password) {
        Schedule schedule = scheduleRepository.findScheduleById(id);

        if (schedule == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id= " + id);
        }

        if (password == null || !password.equals(schedule.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Password mismatch");
        }

        scheduleRepository.deleteSchedule(id);
    }


}