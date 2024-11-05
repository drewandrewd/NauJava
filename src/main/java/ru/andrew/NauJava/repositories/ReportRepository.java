package ru.andrew.NauJava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.andrew.NauJava.models.Report;

public interface ReportRepository extends JpaRepository<Report, Long> {
}
