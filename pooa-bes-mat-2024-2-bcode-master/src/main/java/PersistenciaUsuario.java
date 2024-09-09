public interface PersistenciaUsuario {

    public User create(String username, String password, String role);
    public void list();
    public void update(int id, String newUsername, String newPassword, String newRole);
    void delete(int id);
}
