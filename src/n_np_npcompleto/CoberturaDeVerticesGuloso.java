package n_np_npcompleto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CoberturaDeVerticesGuloso {

    public List<Integer> resolver(List<Aresta> arestas) {
        Set<Aresta> arestasNaoCobertas = new HashSet<>(arestas);
        List<Integer> coberturaDeVertices = new ArrayList<>();

        // Cria a representação do grafo: um mapa de vértices para o conjunto de arestas adjacentes
        Map<Integer, Set<Aresta>> verticesEarestas = new HashMap<>();
        for (Aresta aresta : arestas) {
            // Acesso aos vértices da aresta
            int u = aresta.getU();
            int v = aresta.getV();

            verticesEarestas.computeIfAbsent(u, k -> new HashSet<>()).add(aresta);
            verticesEarestas.computeIfAbsent(v, k -> new HashSet<>()).add(aresta);
        }

        // Loop principal para encontrar a cobertura
        while (!arestasNaoCobertas.isEmpty()) {
            Integer melhorVertice = null;
            int maiorCobertura = 0;

            // Itera sobre todos os vértices para encontrar o que cobre o maior número de arestas restantes
            for (Map.Entry<Integer, Set<Aresta>> entry : verticesEarestas.entrySet()) {
                int vertice = entry.getKey();
                Set<Aresta> arestasDoVertice = entry.getValue();

                Set<Aresta> intersecao = new HashSet<>(arestasDoVertice);
                intersecao.retainAll(arestasNaoCobertas);

                if (intersecao.size() > maiorCobertura) {
                    maiorCobertura = intersecao.size();
                    melhorVertice = vertice;
                }
            }

            if (melhorVertice == null) {
                // Caso não haja mais vértices que cubram arestas restantes
                break;
            }

            // Adiciona o melhor vértice à solução e atualiza as arestas não cobertas
            coberturaDeVertices.add(melhorVertice);
            arestasNaoCobertas.removeAll(verticesEarestas.get(melhorVertice));
        }

        return coberturaDeVertices;
    }
}