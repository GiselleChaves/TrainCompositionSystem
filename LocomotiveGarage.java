import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um local de armazenamento (garagem) de locomotivas.
 */
public class LocomotiveGarage {

    

    


    
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