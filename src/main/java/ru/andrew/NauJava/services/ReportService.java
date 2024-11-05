package ru.andrew.NauJava.services;

import ru.andrew.NauJava.models.Report;

import java.util.concurrent.CompletableFuture;

public interface ReportService {
    Long createReport();
    CompletableFuture<Report> generateReport(Long reportId);
    Report getReport(Long reportId);
}
