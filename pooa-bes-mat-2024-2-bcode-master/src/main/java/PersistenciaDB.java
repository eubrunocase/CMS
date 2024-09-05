import java.util.List;

public interface PersistenciaDB<T>  {

    void save(T entidade);
    void update(T entidade);
    void list();
    void delete(int id);

}
