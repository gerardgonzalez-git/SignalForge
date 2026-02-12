package com.gerardgonzalez.signalforge.domain.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "embeddings", indexes = {
        @Index(name = "idx_feedback_id", columnList = "feedback_item_id")
})
public class Embedding {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "feedback_item_id", nullable = false, unique = true)
    private FeedbackItem feedbackItem;

    @Column(nullable = false, unique = true)
    private String qdrantPointId; // UUID in Qdrant

    @Column(nullable = false)
    private Integer vectorDimension;

    @Column(nullable = false)
    private String modelUsed;

    @Column(nullable = false)
    private LocalDateTime createdAt;
}
