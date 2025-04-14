import java.util.*;

public class HashTable {
    /*
    Aqui estão 10 exercícios básicos para praticar o uso de tabelas hash
    (também conhecidas como dicionários ou mapas em algumas linguagens de programação):

    1. Contagem de Frequência
    Descrição: Dada uma lista de elementos, conte quantas vezes cada elemento aparece.

    Exemplo de Entrada: [1, 2, 2, 3, 3, 3, 4]

    Exemplo de Saída: {1: 1, 2: 2, 3: 3, 4: 1}

    2. Remoção de Duplicatas
    Descrição: Dada uma lista de elementos, retorne uma nova lista sem elementos duplicados.

    Exemplo de Entrada: [1, 2, 2, 3, 3, 3, 4]

    Exemplo de Saída: [1, 2, 3, 4]

    3. Interseção de Duas Listas
    Descrição: Dadas duas listas, retorne uma lista com os elementos comuns a ambas.

    Exemplo de Entrada: [1, 2, 3, 4], [3, 4, 5, 6]

    Exemplo de Saída: [3, 4]

    4. Verificação de Anagramas
    Descrição: Dadas duas strings, verifique se elas são anagramas uma da outra.

    Exemplo de Entrada: "listen", "silent"

    Exemplo de Saída: True

    5. Primeiro Elemento Único
    Descrição: Dada uma lista de elementos, retorne o primeiro elemento que não se repete.

    Exemplo de Entrada: [1, 2, 3, 2, 1, 4]

    Exemplo de Saída: 3

    6. Soma de Dois Números
    Descrição: Dada uma lista de números e um valor alvo, encontre dois números na lista que somam ao valor alvo.

    Exemplo de Entrada: [2, 7, 11, 15], 9

    Exemplo de Saída: (2, 7)

    7. Agrupamento de Elementos
    Descrição: Dada uma lista de elementos, agrupe-os em categorias com base em uma chave.

    Exemplo de Entrada: ["apple", "banana", "cherry", "avocado"]

    Exemplo de Saída: {'a': ['apple', 'avocado'], 'b': ['banana'], 'c': ['cherry']}

    8. Verificação de Permutação
    Descrição: Dadas duas strings, verifique se uma é uma permutação da outra.

    Exemplo de Entrada: "abc", "bca"

    Exemplo de Saída: True

    9. Contagem de Palavras em um Texto
    Descrição: Dado um texto, conte a frequência de cada palavra.

    Exemplo de Entrada: "hello world hello"

    Exemplo de Saída: {'hello': 2, 'world': 1}

    10. Encontrar o Elemento Mais Frequente
    Descrição: Dada uma lista de elementos, encontre o elemento que aparece com mais frequência.

    Exemplo de Entrada: [1, 3, 2, 3, 4, 3, 2, 2, 2]

    Exemplo de Saída: 2

    Esses exercícios ajudam a praticar o uso de tabelas hash para resolver problemas comuns de programação,
    como contagem, busca e agrupamento de elementos.
    */

    // 1. Contagem de Frequência
    public Map<Integer, Integer> contarFrequencia(int[] lista){
        Map<Integer, Integer> frequencia = new HashMap<>();
        for(int elemento : lista){
            frequencia.put(elemento, frequencia.getOrDefault(elemento, 0) + 1);
        }

        return frequencia;
    }

    // 2. Remoção de Duplicatas
    public int[] removerDuplicatas(int[] lista){
        Set<Integer> set = new HashSet<>();
        for (int elemento : lista){
            set.add(elemento);
        }

        return set.stream().mapToInt(Integer::intValue).toArray();
    }

    // 3. Interseção de Duas Listas
    public int[] intersecaoListas(int[] lista1, int[] lista2){
        Set<Integer> set1 = new HashSet<>();
        for (int num : lista1) {
            set1.add(num);
        }

        Set<Integer> intersecao = new HashSet<>();
        for (int num : lista2) {
            if(set1.contains(num))
                intersecao.add(num);

        }

        return intersecao.stream().mapToInt(Integer::intValue).toArray();
    }

    // 4. Verificação de Anagramas
    public boolean saoAnagramas(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort((arr1));
        Arrays.sort((arr2));

        return Arrays.equals(arr1, arr2);
    }

    // 5. Primeiro Elemento Único
    public int primeiroElementoUnico(int[] lista){
        Map<Integer, Integer> frequencia = new HashMap<>();
        for(int elemento : lista){
            frequencia.put(elemento, frequencia.getOrDefault(elemento, 0) + 1);
        }

        for(int elemento : lista){
            if(frequencia.get(elemento) == 1){
                return elemento;
            }
        }

        return - 1;
    }

    // 6. Soma de Dois Números
    public int[] somaDoisNumeros(int[] lista, int alvo){
        Map<Integer, Integer> visto = new HashMap<>();

        for (int i = 0; i < lista.length; i++) {
            int complemento = alvo - lista[i];
            if(visto.containsKey(complemento)){
                return new int[]{complemento, lista[i]};
            }
            visto.put(lista[i], i);
        }

        return null;
    }

    // 7. Agrupamento de Elementos
    public Map<Character, List<String>> agruparPorChave(String[] lista){

        Map<Character, List<String>> grupos = new HashMap<>();

        for (String elemento : lista){
            char chave = elemento.charAt(0);
            grupos.computeIfAbsent(chave, k -> new ArrayList<>()).add(elemento);
        }

        return grupos;
    }

    // 8. Verificação de Permutação
    public boolean saoPermutacoes(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }

    // 9. Contagem de Palavras em um Texto
    public Map<String, Integer> contarPalavras(String texto){
        String[] palavras = texto.split(" ");

        Map<String, Integer> frequencia = new HashMap<>();

        for(String palavra : palavras){
            frequencia.put(palavra, frequencia.getOrDefault(palavra, 0) + 1);
        }

        return frequencia;
    }

    // 10. Encontrar o Elemento Mais Frequente
    public int elementoMaisFrequente(int[] lista){
        Map<Integer, Integer> frequencia = new HashMap<>();

        for (int elemento : lista) {
            frequencia.put(elemento, frequencia.getOrDefault(elemento, 0) + 1);
        }

        int maisFrequente = -1;
        int maxFrequencia =  0;
        for (Map.Entry<Integer, Integer> entry : frequencia.entrySet()) {
            if (entry.getValue() > maxFrequencia) {
                maisFrequente = entry.getKey();
                maxFrequencia = entry.getValue();
            }
        }

        return maisFrequente;
    }

}
