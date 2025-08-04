package org.example.scheduly.repository;

import org.example.scheduly.dto.ScheduleResponseDto;
import org.example.scheduly.entity.Schedule;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.*;

@Repository
public class ScheduleRepositoryImpl implements ScheduleRepository {
    private final Map<Long, Schedule> scheduleList = new HashMap<>();

    public Schedule saveSchedule(Schedule schedule) {
        if (schedule.getId() == null) {
            // 새로 생성하는 경우
            Long scheduleId = scheduleList.isEmpty() ? 1L : Collections.max(scheduleList.keySet()) + 1;
            schedule.setId(scheduleId);
            schedule.setCreatedAt(LocalDateTime.now());  // 생성일자 직접 세팅
        }
        // 수정할 때는 createdAt 유지하고 modifiedAt 업데이트
        schedule.setModifiedAt(LocalDateTime.now()); // 수정일자 직접 세팅

        scheduleList.put(schedule.getId(), schedule);
        return schedule;
    }

    public List<ScheduleResponseDto> findAllSchedules() {
        List<ScheduleResponseDto> allSchedules = new ArrayList<>();
        for (Schedule schedule : scheduleList.values()) {
            allSchedules.add(new ScheduleResponseDto(schedule));
        }
        return allSchedules;
    }

    public Schedule findScheduleById(Long id) {
        return scheduleList.get(id);
    }

    @Override
    public void deleteSchedule(Long id) {
        scheduleList.remove(id);
    }
}
