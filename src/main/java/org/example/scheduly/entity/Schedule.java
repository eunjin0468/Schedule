package org.example.scheduly.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Schedule extends BaseEntity {

    @Id
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  //고유 식별자

    private String name; //작성자명
    private String password; //비밀번호
    private String title; //일정 제목
    private String contents; //일정 내용
    private String author;
//    private LocalDateTime createTime; //생성일자
//    private LocalDateTime updateTime; //수정일자

    public Schedule(String name, String password, String title, String contents, String author) {
        this.name = name;
        this.password = password;
        this.title = title;
        this.contents = contents;
        this.author = author;
    }


    //dto를 넣으면 항상 매개변수가 들어와야 메소드 동작하나,기본타입으로 하면 누구든지 사용 가능 -> 유지보수 증가
    public void update(String title, String name) {
        this.title = title;
        this.name = name;
    }
}