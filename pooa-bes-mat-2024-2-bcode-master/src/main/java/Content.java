
public class Content {

/*
*   author: @Bruno Cazé
*
* Classe que contém os atributos dos conteúdos
*
 */
    private int id;
    private String title;
    private String body;
    private String autor;

    public Content(int id, String title, String body, String autor) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.autor = autor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "\nID: " + id + "\nTítulo: " + getTitle() + "\nCorpo: " + getBody() + "\nAutor: " + getAutor() + "\n";
    }
}
