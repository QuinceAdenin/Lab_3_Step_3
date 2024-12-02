import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DischargeSummaryRepository implements SearchableMedicalRepository<DischargeSummary> {
    private final List<DischargeSummary> dischargeSummaries = new ArrayList<>();

    @Override
    public void create(DischargeSummary record) {
        dischargeSummaries.add(record);
    }

    @Override
    public DischargeSummary read(String id) {
        return dischargeSummaries.stream()
                .filter(summary -> summary.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void update(DischargeSummary record) {
        dischargeSummaries.removeIf(summary -> summary.getId().equals(record.getId()));
        dischargeSummaries.add(record);
    }

    @Override
    public void delete(String id) {
        dischargeSummaries.removeIf(summary -> summary.getId().equals(id));
    }

    @Override
    public List<DischargeSummary> sort(Comparator<DischargeSummary> comparator) {
        return dischargeSummaries.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    @Override
    public List<DischargeSummary> search(Predicate<DischargeSummary> predicate) {
        return dischargeSummaries.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
}