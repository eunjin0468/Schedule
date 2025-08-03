package org.example.scheduly.repository;

import org.example.scheduly.dto.ScheduleRequestDto;
import org.example.scheduly.dto.ScheduleResponseDto;
import org.example.scheduly.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    //Schedule saveSchedule(Schedule schedule);
//    List<ScheduleResponseDto> findAllMemos();
//    Schedule findMemoById(Long id);
//    void deleteMemo(Long id);
}