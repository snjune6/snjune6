package org.example.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.springboot.domain.BaseTimeEntity;

import javax.persistence.*;

// 롬복의 어노테이션 (Getter, NoArgsConstructor)
// @NoArgsConstructor - 기본 생성자 자동추가 / public Posts(){}와 같은 효과
// @Getter - 클래스 내 모든 필드의 Getter메소드를 자동생성
// @Builder - 해당 클래스의 빌더 패턴 클래스를 생성 / 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
@Getter
@NoArgsConstructor
// JPA의 어노테이션, 주요 어노테이션을 클래스에 가깝게 둔다, 롬복은 주요어노테이션이 아니다. 안써도 상관 없기 때문
@Entity
public class Posts extends BaseTimeEntity {
// Posts클래스는 실제 DB의 테이블관 매칭될 클래스이며 보통 Entity클래스라고 한다.
// JPA를 사용하면 DB데이터에 작업할 경우 실제 쿼리를 날리기보다는, 이 Entity 클래스의 수정을 통해 작업한다.
// Posts클래스 JPA에서 제공하는 어노테이션
// 1. @Entity - 테이블관 링크될 클래스임을 나타낸다. / 기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍(_)으로 테이블 이름을 매칭
// ex) SalesManager.java -> sales_manager table
// 2. @Id - 해당 테이블의 PK필드를 나타낸다
// 3. @GeneratedValue - PK생성 규칙을 나타낸다. / 스프링 부트2.0에서는 Generation Type.IDENTITY 옵션을 추가하야만 auto_increment가 된다.
// 4. @Column - 테이블의 칼럼을 나타내며 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 칼럼이 된다.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
