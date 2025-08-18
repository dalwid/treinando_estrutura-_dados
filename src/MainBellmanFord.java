import java.util.*;

public class MainBellmanFord {

    // Classe para representar uma aresta
    static class Aresta {
        String origem, destino;
        int peso;

        Aresta(String origem, String destino, int peso) {
            this.origem = origem;
            this.destino = destino;
            this.peso = peso;
        }
    }

    public static void main(String[] args) {

        List<Edges> arestas = new ArrayList<>();
        arestas.add(new Edges("A", "B", 6));
        arestas.add(new Edges("A", "C", 5));
        arestas.add(new Edges("B", "C", -2));
        arestas.add(new Edges("B", "D", 1));
        arestas.add(new Edges("C", "D", -1));
        arestas.add(new Edges("D", "E", 3));
        arestas.add(new Edges("C", "E", 8));

        BellmanFord bf = new BellmanFord(arestas);
        try {
            Map<String, Integer> resultado = bf.calcular("A");
            System.out.println("Custo mínimo de A até E: " + resultado.get("E"));
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        // Custo mínimo de A até E: 7

        // 🧱 Passo 1: Criar lista de arestas
        /*List<Aresta> arestas = List.of(
                new Aresta("A", "B", 4),
                new Aresta("A", "C", 5),
                new Aresta("B", "C", -3),
                new Aresta("C", "D", 2)
        );

        // 🐣 Passo 2: Encontrar todos os vértices (lugares)
        Set<String> vertices = new HashSet<>();
        for (Aresta a : arestas) {
            vertices.add(a.origem);
            vertices.add(a.destino);
        }

        // 🟢 Passo 3: Inicializar distâncias
        String inicio = "A";
        Map<String, Integer> distancia = new HashMap<>();
        for (String v : vertices) {
            distancia.put(v, Integer.MAX_VALUE);
        }
        distancia.put(inicio, 0); // distância do início é 0

        // 🔁 Passo 4: Relaxar todas as arestas (V - 1) vezes
        int V = vertices.size();
        for (int i = 0; i < V - 1; i++) {
            for (Aresta a : arestas) {
                int dU = distancia.get(a.origem);
                int dV = distancia.get(a.destino);
                if (dU != Integer.MAX_VALUE && dU + a.peso < dV) {
                    distancia.put(a.destino, dU + a.peso);
                }
            }
        }

        // 🚨 Passo 5: Verificar ciclos negativos
        boolean temCicloNegativo = false;
        for (Aresta a : arestas) {
            int dU = distancia.get(a.origem);
            int dV = distancia.get(a.destino);
            if (dU != Integer.MAX_VALUE && dU + a.peso < dV) {
                temCicloNegativo = true;
                break;
            }
        }

        // 🖨️ Passo 6: Mostrar resultados
        if (temCicloNegativo) {
            System.out.println("⚠️ O grafo tem ciclo negativo!");
        } else {
            System.out.println("🟢 Menores distâncias a partir de " + inicio);
            for (String v : vertices) {
                int d = distancia.get(v);
                System.out.println(inicio + " → " + v + " = " + (d == Integer.MAX_VALUE ? "∞" : d));
            }
        }

        /*
        *
        *
        * 🟢 Menores distâncias a partir de A
            A → A = 0
            A → B = 4
            A → C = 1
            A → D = 3
        *
        *
        *
        * */

    }
}
