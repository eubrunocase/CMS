public interface PersistenciaDB<T>  {

    User save(T entidade);
    void update(T entidade);
    void list();
    void delete(int id);

}
