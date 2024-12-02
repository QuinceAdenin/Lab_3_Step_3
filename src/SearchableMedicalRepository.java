import java.util.List;
import java.util.function.Predicate;

public interface SearchableMedicalRepository<T> extends SortableMedicalRepository<T> {
    List<T> search(Predicate<T> predicate);
}