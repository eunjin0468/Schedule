package org.example.scheduly.controller;


import org.example.scheduly.dto.ScheduleRequestDto;
import org.example.scheduly.dto.ScheduleResponseDto;
import org.example.scheduly.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //@Controller+@ResponseBody
@RequestMapping("/schedule") //prefix (공통적으로 사용될 url 선언)
public class ScheduleController {
    //final사용하면 최초로 주입된 키워드가 프로그램이 종료될 때까지 사용됨
    private final ScheduleService scheduleService;

    //    생성자 주입
//    클래스가 필요로 하는 의존성을 생성자를 통해 전달하는 방식
//    @param memoService @Service로 등록된 MemoSerivce 구현체인 Impl
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping
    public ResponseEntity<ScheduleResponseDto> createMemo(@RequestBody ScheduleRequestDto dto) {

        //Service Layer 호출, 응답
        return new ResponseEntity<>(scheduleService.saveSchedule(dto), HttpStatus.CREATED);
    }

}