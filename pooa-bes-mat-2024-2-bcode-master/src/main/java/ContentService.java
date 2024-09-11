import java.util.ArrayList;
import java.util.List;

 /*
 *   author: @Bruno Cazé
 *
 *  Classe Classe responsável por possuir as propriedades do CRUD da entidade Conteúdo;
 */
public class ContentService implements PersistenciaConteudo {
    /*
     *
     * Collection para armazenar os conteúdos + Id para atualizações posteriores
     * Atributo "nextId" para iteração e identificação de cada conteúdo individualmente
     */
    private List<Content> contents;
    private int nextId;

/*
* Construtor da classe
* Define a collection "contents" como um Array List, e inicializa o nextId
 */
    public ContentService() {
        contents = new ArrayList<>();
        nextId = 1;
    }
/*
* Método createContent responsável por gerar o conteúdo fornecido pelo scanner da classe main
*  Contém instancia da classe Content
*  Assinaturas de título + body, seguidos da geração de um Id para que possa ser identificado posteriormente
 */
     @Override
    public void create(String title, String body) {
            Content content = new Content(nextId++, title, body);
        contents.add(content);
        System.out.println("Conteúdo criado com sucesso!\n");
    }

     /*
   * Método listContents responsável por listar os conteúdos adicionados
   *
   *  Funciona através de um If-Else + For each, verificando se existem conteúdos pelo "contents.isEmpty"
   *   e caso contenha conteúdos, ele percorre atráves da iteração do for each
    */
     @Override
    public void list() {
        if (contents.isEmpty()) {
            System.out.println("Nenhum conteúdo disponível.\n");
        } else {
            for (Content content : contents) {
                System.out.println(content);
            }
        }
    }

     /*
    * Método updateContent para atualizar conteúdos já listados
    *
     */
     @Override
    public void update(int id, String newTitle, String newBody) {
        Content content = findContentById(id);
        if (content != null) {
            content.setTitle(newTitle);
            content.setBody(newBody);
            System.out.println("Conteúdo atualizado com sucesso!\n");
        } else {
            System.out.println("Conteúdo não encontrado.\n");
        }
    }
/*
* Método findContentById responsável por auxiliar na listagem do conteúdo
*
* Utiliza um loop for each para iterar sobre a collection de contents e buscar o seu Id
 */

    private Content findContentById(int id) {
        for (Content content : contents) {
            if (content.getId() == id) {
                return content;
            }
        }
        return null;
    }
    /*
    * Método deleteContent, responsável por remover o conteúdo pelo Id
    *
    *  Utiliza a estrutura if-else para verificar a existência ou não do conteúdo específico pelo Id
    *  Caso exista o mesmo é removido, caso contrário exibe a mensagem de conteúdo não encontrado
     */
     @Override
    public void delete(int id) {
        Content content = findContentById(id);
        if (content != null) {
            contents.remove(content);
            System.out.println("Conteúdo excluído com sucesso!\n");
        } else {
            System.out.println("Conteúdo não encontrado.\n");
        }
    }

}
