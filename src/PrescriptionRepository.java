import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PrescriptionRepository implements SearchableMedicalRepository<Prescription> {
    private final List<Prescription> prescriptions = new ArrayList<>();

    @Override
    public void create(Prescription record) {
        prescriptions.add(record);
    }

    @Override
    public Prescription read(String id) {
        return prescriptions.stream()
                .filter(prescription -> prescription.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void update(Prescription record) {
        prescriptions.removeIf(prescription -> prescription.getId().equals(record.getId()));
        prescriptions.add(record);
    }

    @Override
    public void delete(String id) {
        prescriptions.removeIf(prescription -> prescription.getId().equals(id));
    }

    @Override
    public List<Prescription> sort(Comparator<Prescription> comparator) {
        return prescriptions.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    @Override
    public List<Prescription> search(Predicate<Prescription> predicate) {
        return prescriptions.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
}