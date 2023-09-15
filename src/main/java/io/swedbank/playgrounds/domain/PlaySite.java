package io.swedbank.playgrounds.domain;

import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.List;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
@Accessors(chain = true)
public class PlaySite {

    @Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(
            name = "play_site_sequence",
            sequenceName = "play_site_sequence",
            allocationSize = 1,
            initialValue = 2
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "play_site_sequence"
    )
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column
    private Integer totalEquipmentCount;

    @Column(nullable = false)
    private Integer utilization = 0;

    @Column(nullable = false)
    private Integer totalVisitors = 0;

    @Column(nullable = false)
    private Integer visitors = 0;

    @OneToMany(mappedBy = "playsite")
    private List<Equipment> equipments;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private OffsetDateTime dateCreated;

    @LastModifiedDate
    @Column(nullable = false)
    private OffsetDateTime lastUpdated;

}
