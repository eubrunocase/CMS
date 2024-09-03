public interface PersistenciaUsuario {

    public void create(String username, String password, String role);
    public void list();
    public void update(String username ,String newUsername, String newPassword, String newRole);
    public void delete(String username);

}
