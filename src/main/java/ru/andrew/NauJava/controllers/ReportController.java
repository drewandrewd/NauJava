package ru.andrew.NauJava.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.andrew.NauJava.models.Report;
import ru.andrew.NauJava.models.ReportStatus;
import ru.andrew.NauJava.services.ReportService;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/reports")
public class ReportController {

    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @PostMapping
    public ResponseEntity<Long> createReport() {
        Long reportId = reportService.createReport();
        reportService.generateReport(reportId);
        return ResponseEntity.ok(reportId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getReport(@PathVariable Long id) {
        Report report = reportService.getReport(id);
        if (report.getStatus() == ReportStatus.CREATED) {
            return ResponseEntity.ok("Отчет еще не сформирован.");
        } else if (report.getStatus() == ReportStatus.ERROR) {
            return ResponseEntity.ok("Ошибка при формировании отчета.");
        } else {
            return ResponseEntity.ok(report.getContent());
        }
    }

    /**
     * Отображает отчет в формате HTML с использованием Thymeleaf.
     *
     * @param id идентификатор отчета.
     * @param model объект модели для передачи данных в шаблон.
     * @return имя HTML-шаблона для отображения.
     */
    @GetMapping("/view/{id}")
    public String viewReport(@PathVariable Long id, Model model) {
        Report report = reportService.getReport(id);
        model.addAttribute("report", report);
        return "report"; // Название шаблона report.html
    }
}
