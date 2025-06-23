import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainDijkstra {
    public static void main(String[] args) {
        List<Map<String, Map<String, Integer>>> exercicios = new ArrayList<>();

        // Ex 1
        exercicios.add(Map.of(
                "A", Map.of("B", 5, "C", 2),
                "B", Map.of("A", 5, "C", 1, "D", 3),
                "C", Map.of("A", 2, "B", 1, "D", 7),
                "D", Map.of("B", 3, "C", 7)
        ));

        // Ex 2
        exercicios.add(Map.of(
                "A", Map.of("B", 2),
                "B", Map.of("C", 2),
                "C", Map.of("D", 2),
                "D", Map.of("E", 2),
                "E", Map.of()
        ));

        // Ex 3 (grafo com ciclo)
        exercicios.add(Map.of(
                "A", Map.of("B", 1),
                "B", Map.of("C", 1),
                "C", Map.of("A", 1, "D", 1),
                "D", Map.of()
        ));

        // Ex 4 (grafo com caminhos equivalentes)
        exercicios.add(Map.of(
                "A", Map.of("B", 1, "C", 1),
                "B", Map.of("D", 1),
                "C", Map.of("D", 1),
                "D", Map.of()
        ));

        // Ex 5 (grafo desconexo)
        exercicios.add(Map.of(
                "A", Map.of("B", 3),
                "B", Map.of("A", 3),
                "C", Map.of("D", 2),
                "D", Map.of("C", 2)
        ));

        // Ex 6 (a partir de matriz)
        exercicios.add(Map.of(
                "0", Map.of("1", 4),
                "1", Map.of("0", 4, "2", 8),
                "2", Map.of("1", 8, "3", 7),
                "3", Map.of("2", 7)
        ));

        // Ex 7 (pesos altos)
        exercicios.add(Map.of(
                "A", Map.of("B", 1000),
                "B", Map.of("C", 2000),
                "C", Map.of("D", 3000),
                "D", Map.of()
        ));

        // Ex 8 (caminhos alternativos)
        exercicios.add(Map.of(
                "A", Map.of("B", 4, "C", 2),
                "B", Map.of("A", 4, "C", 3, "D", 1),
                "C", Map.of("A", 2, "B", 3, "D", 5),
                "D", Map.of("B", 1, "C", 5)
        ));

        // Ex 9 (grafo com ciclo fechado)
        exercicios.add(Map.of(
                "A", Map.of("B", 1, "C", 4),
                "B", Map.of("A", 1, "D", 2),
                "C", Map.of("A", 4, "D", 1),
                "D", Map.of("B", 2, "C", 1)
        ));

        // Ex 10 (com vértice isolado)
        exercicios.add(Map.of(
                "A", Map.of("B", 1),
                "B", Map.of("A", 1, "C", 2),
                "C", Map.of("B", 2),
                "D", Map.of() // isolado
        ));

        // Executar todos
        for (int i = 0; i < exercicios.size(); i++) {
            System.out.println("Exercícios " + (i + 1));
            var resultado = Dijkstra.dijkstra(exercicios.get(i), exercicios.get(i).keySet().iterator().next());
            for (var entrada : resultado.entrySet()){
                System.out.println(entrada.getKey() + " => "+
                        (entrada.getValue() == Integer.MAX_VALUE ? "INF" : entrada.getValue()));
            }
            System.out.println("----------------------------------------");
        }
    }
}
