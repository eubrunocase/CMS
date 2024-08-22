
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

    public Content(int id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public int getId() {
        return id;
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

    @Override
    public String toString() {
        return "ID: " + id + "\nTítulo: " + title + "\nCorpo: " + body + "\n";
    }
}
