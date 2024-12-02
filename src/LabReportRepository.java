import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LabReportRepository implements SearchableMedicalRepository<LabReport> {
    private final List<LabReport> labReports = new ArrayList<>();

    @Override
    public void create(LabReport record) {
        labReports.add(record);
    }

    @Override
    public LabReport read(String id) {
        return labReports.stream()
                .filter(report -> report.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void update(LabReport record) {
        labReports.removeIf(report -> report.getId().equals(record.getId()));
        labReports.add(record);
    }

    @Override
    public void delete(String id) {
        labReports.removeIf(report -> report.getId().equals(id));
    }

    @Override
    public List<LabReport> sort(Comparator<LabReport> comparator) {
        return labReports.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    @Override
    public List<LabReport> search(Predicate<LabReport> predicate) {
        return labReports.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
}