package uz.elmurodov.spring_boot.entity.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @CreatedBy
    @Column(columnDefinition = "bigint default 1", updatable = false)
    protected Long createdBy;

    @CreatedDate
    @Column(columnDefinition = "timestamp default '2022-02-21T11:29:32.770609700'", updatable = false)
    protected LocalDateTime createdAt;

    @LastModifiedBy
    @Column(columnDefinition = "bigint default 1")
    protected Long lastModifiedBy;

    @LastModifiedDate
    @Column(columnDefinition = "timestamp default '2022-02-21T11:29:32.770609700'")
    protected LocalDateTime lastModifiedAt;

}