package com.gerardgonzalez.signalforge.domain.model;

import com.gerardgonzalez.signalforge.domain.enums.ProcessingStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "feedback_items", indexes = {
        @Index(name = "idx_created_at", columnList = "created_at"),
        @Index(name = "idx_source_id", columnList = "source_id"),
        @Index(name = "idx_status", columnList = "processing_status")
})
public class FeedbackItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String externalId; // Source-specific identifier

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(columnDefinition = "TEXT")
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "source_id", nullable = false)
    private Source source;

    @Column(nullable = false)
    private String authorUsername;

    private String authorId;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime ingestedAt;

    @Column(name = "processing_status")
    @Enumerated(EnumType.STRING)
    private ProcessingStatus processingStatus;

    private String url;

    @Column(columnDefinition = "jsonb")
    private String metadata; // JSON for flexible fields

    @OneToOne(mappedBy = "feedbackItem", cascade = CascadeType.ALL)
    private ClassificationResult classificationResult;

    @OneToOne(mappedBy = "feedbackItem", cascade = CascadeType.ALL)
    private Embedding embedding;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cluster_id")
    private Cluster cluster;

    private Double sentimentScore;

    @Version
    private Long version;
}
