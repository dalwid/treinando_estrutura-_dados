import n_np_npcompleto.Aresta;
import n_np_npcompleto.EstrategiaGulosa;
import n_np_npcompleto.Item;
import n_np_npcompleto.Solucao;

import java.util.*;

public class Main_P_Np_NpCompleto {
    public static void main(String[] args) {
        // Define o valor do troco.
        double valorDoTroco = 3.75;

        // Cria uma instância da nossa calculadora de troco.
        var calculadora = new EstrategiaGulosa();

        // Chama o método para calcular o troco.
        Map<Double, Integer> trocoCalculado = calculadora.calcularTroco(valorDoTroco);

        // Imprime o resultado para usuário.
        //System.out.println("O troco para R$" + String.format("%.2f", valorDoTroco));

        // Intera sobre o mapa para exibir as notas e moedas.
        // O método forEach do mapa itera sobre os dados do mapa.
        // Ele cria duas variáveis LOCAIS para cada iteração: 'nota' (a chave)
        // e 'quantidade' (o valor). Elas não têm nada a ver com as variáveis
        // da classe CalculadoraDeTroco.
        /*trocoCalculado.forEach((nota, quantidade) ->
                        System.out.println(quantidade + " x R$" + String.format("%.2f", nota))
        );*/


        // Cria a lista de itens.
        List<Item> itens = new ArrayList<>();
        itens.add(new Item(10, 60)); // Item de 10kg com valor 60
        itens.add(new Item(20, 100)); // Item de 20kg com valor 100
        itens.add(new Item(30, 120)); // Item de 30kg com valor 120

        // Define a capacidade da mochila.
        int capacidadeMochila = 50;

        // Cria uma instância da nossa calculadora de mochila.
        EstrategiaGulosa mochila = new EstrategiaGulosa();

        // Resolve o problema e obtém o valor máximo.
        double valorMaximo = mochila.resolverMochila(itens, capacidadeMochila);

        // Imprime o resultado final.
        //System.out.println("\nO valor total máximo que pode ser obtido é: " + valorMaximo);

        // Cria a lista de atividades com seus horários de início e término.
        /*List<Atividade> atividades = new ArrayList<>();
        atividades.add(new Atividade("A1", 10, 11)); // termina cedo
        atividades.add(new Atividade("A2", 9, 12));
        atividades.add(new Atividade("A3", 11, 13)); // pode ser agendada logo depois de A1
        atividades.add(new Atividade("A4", 14, 15)); // pode ser agendada depois
        atividades.add(new Atividade("A5", 13, 16)); // também pode

        // Cria uma instância do gerenciador.
        var gerenciador = new EstrategiaGulosa();

        // Resolve o problema e obtém a lista de atividades selecionadas.
        List<Atividade> cronograma = gerenciador.selecionarAtividades(atividades);

        // Imprime o resultado final.
        System.out.println("O cronograma ideal de atividades é:");
        for (Atividade atividade : cronograma) {
            System.out.println(atividade);
        }*/

        /*List<AtividadeComPrazo> atividades = new ArrayList<>();
        atividades.add(new AtividadeComPrazo("a1", 50, 2));
        atividades.add(new AtividadeComPrazo("a2", 40, 1));
        atividades.add(new AtividadeComPrazo("a3", 30, 2));
        atividades.add(new AtividadeComPrazo("a4", 20, 3));
        atividades.add(new AtividadeComPrazo("a5", 10, 1));

        var solver = new EstrategiaGulosa();
        int lucroMaximo = solver.problemaAtividadePrazo(atividades);

        System.out.println("\nLucro máximo obtido: " + lucroMaximo);*/

        // Define o universo a ser coberto
        Set<String> universo = new HashSet<>();
        universo.add("A"); universo.add("B"); universo.add("C");
        universo.add("D"); universo.add("E"); universo.add("F");

        // Define os subconjuntos disponíveis
        List<Set<String>> subconjuntos = new ArrayList<>();
        subconjuntos.add(new HashSet<>(List.of("A", "C", "D")));
        subconjuntos.add(new HashSet<>(List.of("B", "E")));
        subconjuntos.add(new HashSet<>(List.of("A", "F")));
        subconjuntos.add(new HashSet<>(List.of("C", "E")));

        //EstrategiaGulosa solver = new EstrategiaGulosa();
       // List<Set<String>> solucao = solver.coberturaDeConjuntosGuloso(universo, subconjuntos);
/*
        System.out.println("Universo a ser coberto: " + universo);
        System.out.println("Subconjuntos disponíveis: " + subconjuntos);
        System.out.println("\nSolução (cobertura gulosa):");
        solucao.forEach(System.out::println);
        System.out.println("Número de conjuntos na solução: " + solucao.size());*/

        // Grafo com arestas (1,2), (1,3), (2,3), (2,4), (3,4)
        List<Aresta> arestas = List.of(
                new Aresta(1, 2),
                new Aresta(1, 3),
                new Aresta(2, 3),
                new Aresta(2, 4),
                new Aresta(3, 4)
        );

        EstrategiaGulosa solverII = new EstrategiaGulosa();
        List<Integer> solucaoVertices = solverII.coberturaDeVerticesGuloso(arestas);

        //System.out.println("Arestas do grafo: " + arestas);
        //System.out.println("\nSolução (cobertura de vértices gulosa): " + solucaoVertices);

        // Cidades: 0, 1, 2, 3
        int[][] distancias = {
                {0,10,15,20},
                {10,0,35,25},
                {15,35,0,30},
                {20,25,30,0}
        };

        Solucao solucao = EstrategiaGulosa.caixeiroViajanteGuloso(distancias, 0);
        System.out.println("Caminho guloso: "+ solucao.caminho());
        System.out.println("Custo total: " + solucao.custoTotal());

    }
}
