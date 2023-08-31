package ru.skypro.lesson.springboot.EmployeeApplication.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "report")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Lob
    @Column(columnDefinition = "oid", nullable = false)
    private String report;

    @CreationTimestamp(source = SourceType.DB)
    @Column(updatable = false, name = "created_at", nullable = false)
    private Instant createdAt;

    private String path;
}
