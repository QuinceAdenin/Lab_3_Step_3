import java.util.Comparator;
import java.util.List;

public interface SortableMedicalRepository<T> extends MedicalRepository<T> {
    List<T> sort(Comparator<T> comparator);
}
