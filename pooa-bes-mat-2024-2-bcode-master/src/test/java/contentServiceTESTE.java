import java.util.ArrayList;
import java.util.List;

public class contentServiceTESTE implements Persistencia<Content>{

    private List<Content> contents;
    private int nextId;

    public contentServiceTESTE() {
        contents = new ArrayList<>();
        nextId = 1;
    }

    @Override
    public void create(Content entidade) {

    }

    @Override
    public void update(Content entidade) {

    }

    @Override
    public List<Content> list() {
        return List.of();
    }

    @Override
    public void remover(int id) {

    }
}
