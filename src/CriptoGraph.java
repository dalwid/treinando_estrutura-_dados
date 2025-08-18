import java.util.ArrayList;
import java.util.*;

public class CriptoGraph{
    private final int vertices;
    private final List<Edge> edges;

    public  CriptoGraph(int vertices){
        this.vertices = vertices;
        this.edges    = new ArrayList<>();
    }

    public void addEdge(int from, int to, double rate){
        // usa logaritimo negativo para detectar arbirtragem (lucro garantido)
        double weight = Math.log(rate);
        edges.add(new Edge(from, to, weight));
    }

    public boolean detectaLucroArbitrario(int origem){
        double[] dist = new double[vertices];
        Arrays.fill(dist, Double.POSITIVE_INFINITY);

        // Relaxa todas as arestas V - 1 vezes
        for (int i = 0; i < vertices - 1; i++) {
            for (Edge e : edges){
                if(dist[e.from] + e.weight < dist[e.to]){
                    dist[e.to] = dist[e.from] + e.weight;
                }
            }
        }

        // Verifica se existe ciclo negativo
        for(Edge e : edges){
            if(dist[e.from] + e.weight < dist[e.to]){
                return true; // existe arbitragem!
            }
        }

        return false;
    }
}
/*

🦆 Explicação passo a passo (como se você fosse um pato):

    Você observa preços em diferentes exchanges (como Binance e Coinbase).

    O algoritmo usa logaritmo dos preços pra transformar multiplicações em somas (assim, Bellman-Ford pode ser usado).

    O Bellman-Ford relaxa os preços, tentando achar o caminho com o menor custo (ou maior ganho).

    Se em algum momento ele acha um ciclo negativo, significa:

        Você pode comprar e vender de volta e terminar com mais bitcoins do que começou.

        🪙💵 Lucro arbitrário detectado!
*/