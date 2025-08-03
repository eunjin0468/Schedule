package org.example.scheduly.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
//@AllArgsConstructor
public class Schedule extends BaseEntity {

    @Id @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  //고유 식별자

    private String name; //작성자명
    private String password; //비밀번호
    private String title; //일정 제목
    private String contents; //일정 내용
//    private LocalDateTime createTime; //생성일자
//    private LocalDateTime updateTime; //수정일자

    public Schedule(String name, String password, String title, String contents) {
        this.name = name;
        this.password = password;
        this.title = title;
        this.contents = contents;
    }


}
