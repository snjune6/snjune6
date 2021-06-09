package org.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // JPA Auditing 활성화
// 스프링 부트의 자동 설정, 스프링 Bean 일기와 생성을 모두 자동으로 설정
// @SpringBootApplication이 있는 위치부터 설정을 읽어가기 때문에 이 클래스는 항상 프로젝트 최상단에 위치햐야만 한다.
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        // SpringApplication.run으로 인해 내장 WAS를 실행한다.
        SpringApplication.run(Application.class, args);
    }
}
