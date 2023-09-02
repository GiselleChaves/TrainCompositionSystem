import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um local de armazenamento (garagem) de locomotivas.
 */
public class LocomotiveGarage {

    private List<Locomotive> locomotives = new ArrayList<>(); 

    /**
     * Adiciona uma locomotiva à garagem.
     *
     * @param locomotive A locomotiva a ser adicionada à garagem.
     */
    public void addLocomotive(Locomotive locomotive) {
        locomotives.add(locomotive);
    }


    /**
     * Remove uma locomotiva da garagem.
     *
     * @param locomotive A locomotiva a ser removida da garagem.
     */
    public void removeLocomotive(Locomotive locomotive) {
        locomotives.remove(locomotive);
    }

    /**
     * Obtém a lista de locomotivas armazenadas na garagem.
     *
     * @return A lista de locomotivas na garagem.
     */
    public List<Locomotive> getLocomotives() {
        return locomotives;
    }

    /**
     * Encontra uma locomotiva na garagem pelo seu ID.
     *
     * @param locomotiveId O ID da locomotiva a ser encontrado.
     * @return A locomotiva com o ID correspondente ou null se não encontrada.
     */
    public Locomotive findLocomotiveById(int locomotiveId) {
        for (Locomotive locomotive : locomotives) {
            if (locomotive.getId() == locomotiveId) {
                return locomotive;
            }
        }
        return null;
    }
}