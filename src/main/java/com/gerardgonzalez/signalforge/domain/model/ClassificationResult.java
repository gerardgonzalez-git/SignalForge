package com.gerardgonzalez.signalforge.domain.model;

import com.gerardgonzalez.signalforge.domain.enums.FeedbackCategory;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "classification_results")
public class ClassificationResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "feedback_item_id", nullable = false)
    private FeedbackItem feedbackItem;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FeedbackCategory primaryCategory; // BUG, FEATURE_REQUEST, BILLING, UX, OTHER

    @Column(nullable = false)
    private Double confidence;

    @Column(columnDefinition = "jsonb")
    private String allScores; // JSON: {"bug": 0.85, "feature": 0.12, ...}

    @Column(nullable = false)
    private String modelUsed;

    @Column(nullable = false)
    private LocalDateTime classifiedAt;

    private String secondaryCategory;
}
