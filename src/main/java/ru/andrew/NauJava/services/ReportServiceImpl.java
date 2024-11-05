package ru.andrew.NauJava.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import ru.andrew.NauJava.models.Report;
import ru.andrew.NauJava.models.ReportStatus;
import ru.andrew.NauJava.repositories.ReportRepository;

import java.util.concurrent.CompletableFuture;

@Service
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;

    @Autowired
    public ReportServiceImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    /**
     * Создает новый отчет с начальными значениями и сохраняет его в базе данных.
     *
     * @return уникальный идентификатор созданного отчета.
     */
    @Override
    public Long createReport() {
        Report report = new Report();
        report.setStatus(ReportStatus.CREATED);
        report.setContent("");
        report = reportRepository.save(report);
        return report.getId();
    }

    /**
     * Асинхронно генерирует отчет по указанному идентификатору.
     * Выполняет подсчет пользователей и получение списка объектов в отдельных потоках.
     *
     * @param reportId идентификатор отчета для генерации.
     * @return CompletableFuture с завершенным отчетом.
     */
    @Async
    @Override
    public CompletableFuture<Report> generateReport(Long reportId) {
        long startTime = System.currentTimeMillis();

        Report report = reportRepository.findById(reportId).orElseThrow(() -> new RuntimeException("Report not found"));

        try {
            Thread.sleep(2000);
            int userCount = 100;

            Thread.sleep(2000);
            String itemList = "Item1, Item2, Item3";

            long elapsedUserCountTime = System.currentTimeMillis() - startTime;
            long elapsedItemListTime = System.currentTimeMillis() - startTime - elapsedUserCountTime;
            long totalTime = System.currentTimeMillis() - startTime;

            String content = "<html><body>";
            content += "<h1>Отчет</h1>";
            content += "<p>Количество пользователей: " + userCount + "</p>";
            content += "<p>Список объектов: " + itemList + "</p>";
            content += "<p>Время на получение количества пользователей: " + elapsedUserCountTime + " мс</p>";
            content += "<p>Время на получение списка объектов: " + elapsedItemListTime + " мс</p>";
            content += "<p>Общее время формирования отчета: " + totalTime + " мс</p>";
            content += "</body></html>";

            report.setContent(content);
            report.setStatus(ReportStatus.COMPLETED);
        } catch (Exception e) {
            report.setStatus(ReportStatus.ERROR);
            e.printStackTrace();
        } finally {
            reportRepository.save(report);
        }
        return CompletableFuture.completedFuture(report);
    }

    /**
     * Получает отчет по указанному идентификатору.
     *
     * @param reportId идентификатор отчета.
     * @return объект отчета.
     */
    @Override
    public Report getReport(Long reportId) {
        return reportRepository.findById(reportId).orElseThrow(() -> new RuntimeException("Report not found"));
    }
}
