import java.util.List;

public interface Persistencia<T> {

    void create(T entidade);
    void update(T entidade);
    List<T> list();
    void remover(int id);
}
