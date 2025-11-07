import n_np_npcompleto.Aresta;
import n_np_npcompleto.CoberturaDeVerticesGuloso;
import n_np_npcompleto.EstrategiaGulosa;

import java.util.List;

public class MainPPNPNCompletoII {
    public static void main(String[] args) {
        // Grafo com arestas (1,2), (1,3), (2,3), (2,4), (3,4)
        List<Aresta> arestas = List.of(
                new Aresta(1, 2),
                new Aresta(1, 3),
                new Aresta(2, 3),
                new Aresta(2, 4),
                new Aresta(3, 4)
        );

        CoberturaDeVerticesGuloso solver = new CoberturaDeVerticesGuloso();
        List<Integer> solucaoVertices = solver.resolver(arestas);

        System.out.println("Arestas do grafo: " + arestas);
        System.out.println("\nSolução (cobertura de vértices gulosa): " + solucaoVertices);
    }
}
