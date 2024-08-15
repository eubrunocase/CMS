public class usuario {

    private String nome;
    private double senha;


    public usuario(String nome, double senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSenha() {
        return senha;
    }

    public void setSenha(double senha) {
        this.senha = senha;
    }


    public String autenticar(int password) {
        if (password == senha) {
            return "Acesso liberado!";
        } else {
            return "Senha incorreta!";
        }
    }


}
