public interface MedicalRepository<T> {
    void create(T record);
    T read(String id);
    void update(T record);
    void delete(String id);
}
