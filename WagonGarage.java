import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um local de armazenamento (garagem) de vagões.
 */
public class WagonGarage {

    private List<Wagon> wagons = new ArrayList<>();


    

    /**
     * Encontra um vagão na garagem com base no seu ID.
     *
     * @param wagonId O ID do vagão a ser encontrado.
     * @return O vagão encontrado ou null se não for encontrado nenhum com o ID especificado.
     */
    public Wagon findWagonById(int wagonId) {
        for (Wagon wagon : wagons) {
            if (wagon.getId() == wagonId) {
                return wagon;
            }
        }
        return null;
    }
}
