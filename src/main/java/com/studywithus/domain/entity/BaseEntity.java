package com.studywithus.domain.entity;
/* 자동 시간처리를 위한 클래스 */

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass // 해당 어노테이션이 적용된 클래스는 테이블로 생성되지 않는다. (실제 테이블은 해당 이 클래스를 상속한 엔티티의 클래스로 DB 테이블이 생성됨)
@EntityListeners(value = {AuditingEntityListener.class})   // AuditingEntityListener : JPA 내부에서 엔티티 객체가 생성/변경되는 것을 감지하는 역할.
                                                                // 이를 통해 regDate, modDate에 적절한 값이 지정됨
                                                                // 활성화 시키기 위해서는 프로젝트에 @EnableJpaAuditing 설정을 추가해야함
@Getter
public class BaseEntity {
    
    @CreatedDate // JPA에서 엔티티 생성 시간을 처리
    @Column(name = "regdate", updatable = false) // updatable = false : 해당 엔티티 객체를 DB에 반영할 때 regdate 칼럼 값은 변경되지 않음
    private LocalDateTime regDate;
    
    @LastModifiedDate // 최종 수정 시간을 자동으로 처리하는 용도
    @Column(name = "moddate")
    private LocalDateTime modDate;
}
