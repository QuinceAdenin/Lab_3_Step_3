import java.util.Comparator;
import java.util.List;

public class MedicalMain {
    public static void main(String[] args) {
        // Создание репозиториев
        LabReportRepository labReportRepository = new LabReportRepository();
        DischargeSummaryRepository dischargeSummaryRepository = new DischargeSummaryRepository();
        PrescriptionRepository prescriptionRepository = new PrescriptionRepository();

        // Создание записей
        LabReport labReport_1 = new LabReport("1", "Иван Иванов", "Общий анализ крови", "Норма", "25.10.2022");
        LabReport labReport_2 = new LabReport("2", "Иван Прут", "Общий анализ крови", "Умирает", "03.08.2024");
        DischargeSummary dischargeSummary_1 = new DischargeSummary("1", "Иван Иванов", "Грипп", "Антибиотики", "10.12.2022");
        DischargeSummary dischargeSummary_2 = new DischargeSummary("2", "Иван Прут", "СПИД", "Уринотерапия", "24.03.2012");
        Prescription prescription_1 = new Prescription("1", "Иван Иванов", "Амоксициллин", "500 мг, 2 раза в день", "12.12.2022");
        Prescription prescription_2 = new Prescription("2", "Иван Прут", "Кокаин", "1000 кг, 100 раз в день", "13.06.2004");

        // Добавление записей в репозитории
        labReportRepository.create(labReport_1);
        labReportRepository.create(labReport_2);
        dischargeSummaryRepository.create(dischargeSummary_1);
        dischargeSummaryRepository.create(dischargeSummary_2);
        prescriptionRepository.create(prescription_1);
        prescriptionRepository.create(prescription_2);

        // Чтение записей
        LabReport readLabReport_1 = labReportRepository.read("1");
        LabReport readLabReport_2 = labReportRepository.read("2");
        DischargeSummary readDischargeSummary_1 = dischargeSummaryRepository.read("1");
        DischargeSummary readDischargeSummary_2 = dischargeSummaryRepository.read("2");
        Prescription readPrescription_1 = prescriptionRepository.read("1");
        Prescription readPrescription_2 = prescriptionRepository.read("2");

        // Вывод записей на консоль
        System.out.println("Прочитанный анализ: " + readLabReport_1);
        System.out.println("Прочитанный анализ: " + readLabReport_2);
        System.out.println("Прочитанная выписка: " + readDischargeSummary_1);
        System.out.println("Прочитанная выписка: " + readDischargeSummary_2);
        System.out.println("Прочитанный рецепт: " + readPrescription_1);
        System.out.println("Прочитанный рецепт: " + readPrescription_2);

        // Обновление записей
        labReport_1.setResult("Повышенный уровень лейкоцитов");
        labReportRepository.update(labReport_1);
        labReport_2.setDate("19.05.2007");
        labReportRepository.update(labReport_2);

        // Чтение обновленной записи
        LabReport updatedLabReport_1 = labReportRepository.read("1");
        System.out.println("Обновленный анализ: " + updatedLabReport_1);
        LabReport updatedLabReport_2 = labReportRepository.read("2");
        System.out.println("Обновленный анализ: " + updatedLabReport_2);

        // Сортировка и поиск
        List<LabReport> sortedLabReports = labReportRepository.sort(Comparator.comparing(LabReport::getDate));
        List<DischargeSummary> sortedDischargeSummary = dischargeSummaryRepository.sort(Comparator.comparing(DischargeSummary::getTreatment));
        List<LabReport> searchedLabReports_1 = labReportRepository.search(report -> report.getPatientName().equals("Иван Прут"));
        List<LabReport> searchedLabReports_2 = labReportRepository.search(report -> report.getResult().equals("Повышенный уровень лейкоцитов"));

        // Вывод отсортированных и найденных записей на консоль
        System.out.println("Отсортированные анализы:");
        sortedLabReports.forEach(System.out::println);

        System.out.println("Отсортированные выписки:");
        sortedDischargeSummary.forEach(System.out::println);

        System.out.println("Найденные анализы:");
        searchedLabReports_1.forEach(System.out::println);
        searchedLabReports_2.forEach(System.out::println);

        // Удаление записей
        labReportRepository.delete("1");
    }
}
