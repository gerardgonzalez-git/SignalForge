package com.gerardgonzalez.signalforge.domain.model;

import com.gerardgonzalez.signalforge.domain.enums.SourceType;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "sources")
public class Source {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name; // e.g., "github-langchain-ai", "reddit-r-openai"

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SourceType type; // GITHUB, REDDIT, APP_STORE, etc.

    @Column(nullable = false)
    private String endpoint; // API endpoint or identifier

    @Column(columnDefinition = "jsonb")
    private String configuration; // API keys, filters, etc.

    @Column(nullable = false)
    private Boolean active = true;

    private LocalDateTime lastSyncedAt;

    @OneToMany(mappedBy = "source")
    private List<FeedbackItem> feedbackItems;

    private LocalDateTime createdAt;
}
