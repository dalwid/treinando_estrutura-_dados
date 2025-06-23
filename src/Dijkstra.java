import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Dijkstra {
    public static Map<String, Integer> dijkstra(Map<String, Map<String, Integer>> grafo, String origem){
        Map<String, Integer> distancias = new HashMap<>();
        Set<String> visitados = new HashSet<>();

        for (String vertice : grafo.keySet()){
            distancias.put(vertice, Integer.MAX_VALUE);
        }

        distancias.put(origem, 0);

        while(visitados.size() < grafo.size()){
            String atual = null;
            int menorDist = Integer.MAX_VALUE;

            for (String vertice : grafo.keySet()){
                if(!visitados.contains(vertice) && distancias.get(vertice) < menorDist){
                    menorDist = distancias.get(vertice);
                    atual = vertice;
                }
            }

            if(atual == null) {
                break;
            }

            visitados.add(atual);
            for (Map.Entry<String, Integer> vizinho : grafo.get(atual).entrySet()){
                if(!visitados.contains(vizinho.getKey())){
                    int nova = distancias.get(atual) + vizinho.getValue();
                    if(nova < distancias.get(vizinho.getKey())){
                        distancias.put(vizinho.getKey(), nova);
                    }
                }
            }
        }

        return distancias;
    }
}
