package com.gerardgonzalez.signalforge.domain.model;

import com.gerardgonzalez.signalforge.domain.enums.AlertType;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "alerts", indexes = {
        @Index(name = "idx_created_at", columnList = "created_at"),
        @Index(name = "idx_type", columnList = "alert_type")
})
public class Alert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AlertType alertType; // SENTIMENT_SPIKE, NEW_CLUSTER, VOLUME_ANOMALY, etc.

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(nullable = false)
    private Double severity; // 0.0 - 1.0

    @ManyToOne
    @JoinColumn(name = "cluster_id")
    private Cluster relatedCluster;

    @Column(columnDefinition = "bigint[]")
    private Long[] relatedFeedbackIds;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    private Boolean acknowledged = false;

    private LocalDateTime acknowledgedAt;

    @ManyToOne
    @JoinColumn(name = "acknowledged_by")
    private User acknowledgedBy;

    @Column(columnDefinition = "jsonb")
    private String metadata; // Additional context
}
