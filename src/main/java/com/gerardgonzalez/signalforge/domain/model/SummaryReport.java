package com.gerardgonzalez.signalforge.domain.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "summary_reports", indexes = {
        @Index(name = "idx_created_at", columnList = "created_at")
})
public class SummaryReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime reportDate;

    @Column(nullable = false)
    private LocalDate periodStart;

    @Column(nullable = false)
    private LocalDate periodEnd;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String executiveSummary; // AI-generated

    @Column(columnDefinition = "TEXT")
    private String keyInsights; // Bulleted list

    @Column(columnDefinition = "TEXT")
    private String topIssues; // AI-generated

    @Column(columnDefinition = "jsonb")
    private String categoryBreakdown; // JSON: {"bug": 45, "feature": 23, ...}

    @Column(columnDefinition = "jsonb")
    private String sentimentTrends; // Time-series data

    private Integer totalFeedbackProcessed;

    private Integer newClustersIdentified;

    private Integer alertsGenerated;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private String modelUsed;
}
