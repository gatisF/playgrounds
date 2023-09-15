package io.swedbank.playgrounds.domain;

import jakarta.persistence.*;

import java.time.OffsetDateTime;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
@Accessors(chain = true)
public class Kid {

    @Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(
            name = "kid_sequence",
            sequenceName = "kid_sequence",
            allocationSize = 1,
            initialValue = 2
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "kid_sequence"
    )
    private Long id;

    @Column
    private String name;

    @Column
    private Integer age;

    @Column(unique = true)
    private Long ticketNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "playsite_id")
    private PlaySite playsite;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private OffsetDateTime dateCreated;

    @LastModifiedDate
    @Column(nullable = false)
    private OffsetDateTime lastUpdated;

}
