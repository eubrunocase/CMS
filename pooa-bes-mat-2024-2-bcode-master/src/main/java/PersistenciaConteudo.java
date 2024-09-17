
public interface PersistenciaConteudo {


    void create(String title, String body, String autor);
    public void list();
    void update(int id, String newTitle, String newBody);
    void delete(int id);

}
