import java.util.*;

public class Main {
    public static void main(String[] args){
        var typesSort = new SelectionSort();
        var quickSort = new QuickSort();
        var hashTable = new HashTable();
        var hashTableII = new HashTableII();
        var fbs = new Fbs();
        /*
        int[] array = {9, 7, 5, 3, 1, 8, 6};

        int[] selectionSortDescending = typesSort.selectionSortDescending(array);
        //System.out.println(Arrays.toString(selectionSortDescending));

        String[] fruits = {"banana", "apple", "cherry", "date"};
        //System.out.println(Arrays.toString(fruits));
        String[] orderFruits = typesSort.selectionSortStrings(fruits);
        //System.out.println(Arrays.toString(orderFruits));

        Pessoa[] pessoas = {
                new Pessoa("Alice",30),
                new Pessoa("Bob",  25),
                new Pessoa("Carol",35),
                new Pessoa("David",20)
        };

        pessoas = typesSort.selectionSortObjects(pessoas);*/

        // Exibindo o resultado ordenado
        /*
        System.out.println("Pessoas ordenadas por idade:");
        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa.getNome() + " - " + pessoa.getIdade() + " anos");
        }*/

        /*
        int[] numeros = {30, 25, 35, 20};
        //System.out.println(typesSort.selectionSortCountComparisons(numeros));
        //System.out.println(typesSort.selectionSortCountSwaps(numeros));

        int[] L = {29, 10, 14, 37, 13};
        int K = 3;
        int[] kSorted = typesSort.selectionSortPartial(L, K);
        //System.out.println(Arrays.toString(kSorted));

        int[][] matrix = {
                {4, 2, 1},  // Soma: 7
                {9, 5, 3},  // Soma: 17
                {1, 1, 1},  // Soma: 3
                {6, 0, 2}   // Soma: 8
        };
        int[][] sortedMatrix = typesSort.selectionSOrtMatrix(matrix);/*
        for (int[] linhas : sortedMatrix){
            System.out.println(Arrays.toString(linhas));
        }*/
        // Sugestão para o próximo array 29, 10, 14, 37, 13, 5
        /*int[] range = {5, 2, 9, 1, 5, 6};
        int start = 1;
        int end = 4;
        int[] result = typesSort.selectionSortRange(array, start, end);*/
//        System.out.println("Array parcialmente ordenado:");
//        for (int num : result) {
//            System.out.print(num + " ");
//        }

        //int[] stepsBySteps = {29, 10, 14, 37, 13, 5};
        //int[] animated = typesSort.selectionSortAnimated(stepsBySteps);
//        for (int steps : animated){
//            System.out.print(Arrays.toString(animated));
//        }

        //System.out.println(Arrays.toString(typesSort.selectionSort(array)));
        //int[] recursive = {64, 25, 12, 22, 11};
        //System.out.println(Arrays.toString(typesSort.selectionSortRecursive(recursive, 0)));

        //int[] arr = {10, 7, 8, 9, 1, 5, 15, 13};  // Exemplo de array desordenado
        /*System.out.println("Array original: " + Arrays.toString(arr));
        quickSort.quickSortBasic(arr, 0, arr.length - 1);  // Chamando o Quicksort
        System.out.println("Array ordenado: " + Arrays.toString(arr));*/
        /*
        quickSort.quickSortRandomPivot(arr, 0, array.length - 1);
        System.out.println(Arrays.toString(arr));*/

        //quickSort.quickSortWithComparisons(arr, 0, array.length - 1 );
        //System.out.println(Arrays.toString(arr));

        //quickSort.quickSortDescending(range, 1, range.length - 1);
        //System.out.println(Arrays.toString(range));

        //int[] quickArray = {10, 5, 2, 3, 7, 6};
        //System.out.println("Ordenando: " + Arrays.toString(quickSort.quickSortPivotMiddle(quickArray)));

        //quickSort.quickSortPerformance(quickArray);
        //System.out.println(Arrays.toString(quickSort.quickSortDesc(quickArray)));

        /*
        quickSort.quickSortCount(quickArray);
        System.out.println("Números de chamadas recursivas: " + quickSort.getCount());*/
        /*
        int[] repeatedArray = {4, 2, 7, 2, 4, 8, 4, 9};
        System.out.println("Com elementos repetitidos: " + Arrays.toString(quickSort.quickSortRepeat(repeatedArray)));*/
        /*
        String[] words = {"banana", "apple", "orange", "grape", "cherry"};
        Arrays.sort(words, String::compareTo);
        System.out.println("Strings ordenadas: " + Arrays.toString(words));*/

        /*
        Student[] students = {
                new Student("Alice", 85),
                new Student("Bob", 75),
                new Student("Charlie", 95)
        };

        Arrays.sort(students, Comparator.comparingInt(s -> s.score));
        Arrays.stream(students).forEach(s -> System.out.println(s.name + " - " + s.score));*/
        /*
        quickSort.quickSortInterative(quickArray);
        System.out.println(Arrays.toString(quickArray));*/

        /*
        quickSort.quickSortRandomPivot(quickArray);
        System.out.println(Arrays.toString(quickArray));*/

        /*
        int[] arranjo = {3, 6, 8, 10, 1, 2, 1, 3, 5, 7, 9, 8, 10, 2, 4, 6};
        System.out.println("Array original: " + Arrays.toString(arranjo));
        quickSort.sortToQuickSort(arranjo);
        System.out.println("Array ordenado: " + Arrays.toString(arranjo));*/

        //quickSort.runTestTime();


       /* int[] lista = {1, 2, 2, 3, 3, 3, 4};
       System.out.println(hashTable.contarFrequencia(lista));// Saída: {1=1, 2=2, 3=3, 4=1}

        int[] resultado = hashTable.removerDuplicatas(lista);
        for (int num : resultado){
            System.out.println(num + " "); // Saída 1 2 3 4
        }

        int[] lista1 = {1, 2, 3, 4};
        int[] lista2 = {3, 4, 5, 6};
        int[] resultado = hashTable.intersecaoListas(lista1, lista2);
        for (int num : resultado) {
            System.out.print(num + " "); // Saída: 3 4
        }

        String s1 = "listen";
        String s2 = "silent";
        System.out.println(hashTable.saoAnagramas(s1, s2));*/

        //int[] lista = {1, 2, 3, 2, 1, 4};
        //System.out.println(hashTable.primeiroElementoUnico(lista));

        /*
        int[] lista = {2, 7, 11, 15};
        int alvo = 9;
        int[] resultado = hashTable.somaDoisNumeros(lista, alvo);
        System.out.println(resultado[0]+", "+ resultado[1]); // Sáida 2, 7

        String[] fruit = {"apple", "banan", "cherry", "avocado"};
        System.out.println(hashTable.agruparPorChave(fruit)); // Saída: {a=[apple, avocado], b=[banana], c=[cherry]}
        */

        /*
        String s1 = "abc";
        String s2 = "bca";
        System.out.println(hashTable.saoPermutacoes(s1, s2));

        String texto = "hello world hello";
        System.out.println(hashTable.contarPalavras(texto));// Saída: {hello=2, world=1}

        int[] lista = {1, 3, 2, 3, 4, 3, 2, 2, 2};
        System.out.println(hashTable.elementoMaisFrequente(lista)); // Saída: 2

         */

        /*
        //1. Criar e adicionar elementos em uma tabela hash
        Map<String, Object> tabelaHash = new HashMap<>();
        tabelaHash.put("nome", "Alice");
        tabelaHash.put("idade", 25);
        tabelaHash.put("profissao", "Engenheira");
        tabelaHash.put("cidade", "São Paulo");
        tabelaHash.put("país", "Brasil");
        System.out.println(tabelaHash);

        //2. Buscar um elemento na tabela hash
        System.out.println(tabelaHash.get("cidade")); // São Paulo

        // 3. Remover um elemento da tabela hash
        tabelaHash.remove("profissao");
        System.out.println(tabelaHash.getOrDefault("profissao", "Não encontrado"));

        // 4. Verificar se uma chave existe
        System.out.println(tabelaHash.containsKey("nome")); // true
        System.out.println(tabelaHash.containsKey("telefone")); // false

        // 5. Iterar sobre os elementos da tabela hash
        for(Map.Entry<String, Object> entry : tabelaHash.entrySet()){
            System.out.println(entry.getKey()+": "+entry.getValue());
        }

        // 6. Contar quantos elementos há na tabela hash
        System.out.println("Tamanho: "+ tabelaHash.size());

        // 7. Criar uma função que converte um array de pares chave-valor em uma tabela hash
        String[][] dados = {{"nome", "Carlos"}, {"idade", "30"}, {"cidade", "Rio"}};
        Map<String, Object> novaHash = hashTableII.arrayParaHash(dados);
        System.out.println(novaHash);

        // 8. Criar uma função que converte uma tabela hash em um objeto (simulado via classe)
        Pepple p = new Pepple();
        p.nome   = (String) tabelaHash.get("nome");
        p.idade  = (int) tabelaHash.get("idade");
        p.cidade = (String) tabelaHash.get("cidade");

        //System.out.println(p.nome+" - "+p.idade+" - "+p.cidade);

        // 9. Criar um cache simples com tabela hash
        Map<String, Integer> cache = new HashMap<>();
        int resultado1 = hashTableII.calcular("soma", cache, ()-> 10 + 20);
        int resultado2 = hashTableII.calcular("soma", cache, ()-> 50 + 50);

        System.out.println(resultado1);
        System.out.println(resultado2);

        // 10. Criar um sistema de contagem de palavras usando tabela hash
        String texto = "O gato preto encontrou outro gato preto no telhado.";
        System.out.println(hashTableII.contarPalavras(texto));

         */

    /*
        char[][] grade = {
                {'.', '.', '#'},
                {'#', '.', '#'},
                {'.', '.', '.'}
        };
        //System.out.println(fbs.menorCaminho(grade));

        int[][] matriz = {
                {1, 1, 0, 0},
                {0, 1, 0, 0},
                {1, 0, 1, 1},
                {0, 0, 1, 0}
        };
        //System.out.println("Total de ilhas: "+fbs.contarIlhas(matriz));

        Map<String, List<String>> grafo = new HashMap<>();
        grafo.put("João",  Arrays.asList("maria", "Lucas"));
        grafo.put("Maria", Arrays.asList("Joao", "Paulo"));
        grafo.put("Lucas", Arrays.asList("Joao", "Ana"));
        grafo.put("Paulo", Arrays.asList("Maria"));
        grafo.put("Ana",   Arrays.asList("Lucas", "Rafa"));
        grafo.put("Rafa",  Arrays.asList("Ana"));

        List<String> amigos = fbs.amigosnivel2(grafo, "João");
        //System.out.println("Amigos de nível 2 de João: "+amigos);

        int[][] labirinto = {
                {0, 1, 0, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0}
        };

        int passos = fbs.menorDistancia(labirinto, 0, 0, 4, 4);
        System.out.println("Menor distância: " + passos);

        Map<Integer, List<Integer>> grafo = new HashMap<>();
        grafo.put(1, Arrays.asList(2, 3));
        grafo.put(2, Arrays.asList(1, 4));
        grafo.put(3, Arrays.asList(1));
        grafo.put(4, Arrays.asList(2, 5));
        grafo.put(5, Arrays.asList(4));

        int idInicial = 1;
        int minutos = fbs.tempoParaEspalhar(grafo, idInicial);
        //System.out.println("Tempo para espalhar a notícia: " + minutos + " minuto(s)");


        String inicio = "hit";
        String fim = "cog";
        List<String> dicionario = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        int passos = fbs.ladderLength(inicio, fim, dicionario);
        //System.out.println("Menor número de passos: " + passos);

        int x = 3;
        int y = 11;

        int resultado = fbs.transformarNumero(x, y);
        System.out.println("Número mínimo de operações: " + resultado);

        int[][] cidade = {
                {0, 1, 0},
                {0, 0, 0},
                {1, 0, 0}
        };
        int resultado = fbs.minutosParaInfeccaoTotal(cidade);
        System.out.println("Minutos para infectar todos os humanos: " + resultado);

        int n = 8; // Tabuleiro 8x8 padrão
        int[] inicio = {0, 0}; // Posição inicial
        int[] fim = {7, 7}; // Posição final

        int resultado = fbs.minMovimentos(n, inicio, fim);
        System.out.println("Movimentos mínimos do cavalo: "+resultado);*/

        // Exemplo de grafo bipartido
        List<List<Integer>> grafo = Arrays.asList(
                Arrays.asList(1, 3),
                Arrays.asList(0, 2),
                Arrays.asList(1, 3),
                Arrays.asList(0, 2)
        );

        boolean resultado = fbs.ehBipartido(grafo);
        System.out.println("O grafo é bipartido? " + resultado);

    }
}