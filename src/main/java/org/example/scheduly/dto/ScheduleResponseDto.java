package org.example.scheduly.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.scheduly.entity.Schedule;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ScheduleResponseDto {

    private Long id;  //고유 식별자
    private String name; //작성자명
    private String password; //비밀번호
    private String title; //일정 제목
    private String contents; //일정 내용
    private LocalDateTime createdAt; //생성일자
    private LocalDateTime modifiedAt; //수정일자

    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.name = schedule.getName();
        this.title = schedule.getTitle();
        this.contents = schedule.getContents();
        this.createdAt = schedule.getCreatedAt();
        this.modifiedAt = schedule.getModifiedAt();
        this.password = schedule.getPassword();
    }
}
