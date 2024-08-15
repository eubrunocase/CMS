
public class Content {

/*
*   author: @Bruno Cazé
*
* Classe que contém os atributos dos conteúdos
*
 */
    private int id;
    private String titulo;
    private String tipo;

    public Content(int id, String title, String body) {
        this.id = id;
        this.titulo = title;
        this.tipo = body;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return titulo;
    }

    public void setTitle(String title) {
        this.titulo = title;
    }

    public String getBody() {
        return tipo;
    }

    public void setBody(String body) {
        this.tipo = body;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nTítulo: " + titulo + "\nCorpo: " + tipo + "\n";
    }
}
