package org.example.scheduly.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleRequestDto {
    private String name;
    private String password;
    private String contents;
    private String title;
    private String author;
}

