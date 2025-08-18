import java.util.*;

public class BellmanFord {
    private Map<String, Integer> distancias;
    private List<Edges> arestas;
    private Set<String> vertices;

    public BellmanFord(List<Edges> arestas){
        this.arestas = arestas;
        this.vertices = new HashSet<>();
        for (Edges e: arestas){
            vertices.add(e.origem);
            vertices.add(e.destino);
        }
    }

    public Map<String, Integer> calcular(String origem){
        distancias = new HashMap<>();
        for (String v : vertices){
            distancias.put(v, Integer.MAX_VALUE);
        }
        distancias.put(origem, 0);

        int v = vertices.size();
        for (int i = 0; i < v; i++) {
            for (Edges e : arestas){
                if (distancias.get(e.origem) != Integer.MAX_VALUE
                        &&
                        distancias.get(e.origem) + e.custo <distancias.get(e.destino))
                {
                    distancias.put(e.destino, distancias.get(e.origem) + e.custo);
                }
            }
        }

        // verifica ciclo negativo
        for (Edges e : arestas){
            if(distancias.get(e.origem) != Integer.MAX_VALUE &&
            distancias.get(e.origem) + e.custo < distancias.get(e.destino)){
                throw  new RuntimeException("Ciclo negativo dectado!");
            }
        }

        return distancias;
    }
}
/*

 🦆 Explicação estilo pato de borracha:

    Começamos dizendo que A é 0, os outros são ∞.

    Relaxamos as estradas várias vezes, ou seja:

        "Se eu posso ir de A até B com 6, B vale 6 agora."

        "Se eu posso ir de B até C e for mais barato, atualizo C."

    Vamos melhorando os caminhos até não dar pra melhorar mais.

    Depois só checamos se algum caminho ainda abaixaria — se sim, tem ciclo negativo e avisamos.

*/