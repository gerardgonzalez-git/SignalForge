package com.gerardgonzalez.signalforge.domain.model;

import com.gerardgonzalez.signalforge.domain.enums.FeedbackCategory;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "clusters", indexes = {
        @Index(name = "idx_created_at", columnList = "created_at")
})
public class Cluster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String clusterId; // e.g., "cluster-2024-01-15-001"

    @Column(columnDefinition = "TEXT")
    private String description; // AI-generated summary

    @OneToMany(mappedBy = "cluster")
    private List<FeedbackItem> feedbackItems;

    @Column(nullable = false)
    private Integer itemCount;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    private LocalDateTime lastUpdatedAt;

    @Column(columnDefinition = "float[]")
    private float[] centroid; // Average embedding vector

    private Double cohesionScore; // Quality metric

    @Column(columnDefinition = "TEXT")
    private String keywords; // Comma-separated

    @Enumerated(EnumType.STRING)
    private FeedbackCategory dominantCategory;
}
