package org.example.scheduly.repository;

import org.example.scheduly.dto.ScheduleResponseDto;
import org.example.scheduly.entity.Schedule;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public abstract class ScheduleRepositoryImpl implements ScheduleRepository {
    private final Map<Long, Schedule> scheduleList = new HashMap<>();


    public Schedule saveSchedule(Schedule schedule) {
        Long scheduleId = scheduleList.isEmpty() ? 1 : Collections.max(scheduleList.keySet()) + 1;
        schedule.setId(scheduleId);
        scheduleList.put(scheduleId, schedule);

        return schedule;
    }

    //@Override
    public List<ScheduleResponseDto> findAllSchedules() {

        //init List
        List<ScheduleResponseDto> allSchedules = new ArrayList<>();

        for (Schedule schedule : scheduleList.values()) { //DB에 있는 정보들을 꺼내서 반복문 실행
            ScheduleResponseDto responseDto = new ScheduleResponseDto(schedule);
            allSchedules.add(responseDto);
        }
        return allSchedules;
    }

    //@Override
    public Schedule findScheduleById(Long id) {
        return scheduleList.get(id);
    }
}