package org.example.scheduly.repository;

import org.example.scheduly.entity.Schedule;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Repository
public abstract class ScheduleRepositoryImpl implements ScheduleRepository{
    private final Map<Long, Schedule> scheduleList = new HashMap<>();

//    @Override
//    public Schedule saveSchedule(Schedule schedule) {
//        Long scheduleId = scheduleList.isEmpty() ? 1 : Collections.max(scheduleList.keySet()) + 1;
//        schedule.setId(scheduleId);
//        scheduleList.put(scheduleId, schedule);
//
//        return schedule;
//    }
}
//@Override
//public Memo saveMemo(Memo memo) {
//    Long memoId = memoList.isEmpty() ? 1 : Collections.max(memoList.keySet()) + 1;
//    memo.setId(memoId);
//    memoList.put(memoId, memo);
//
//    return memo;
//}