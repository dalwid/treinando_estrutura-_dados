import java.util.*;

public class QuickSort {
/*
*Implementação personalizada:
Escreva uma versão do Quicksort em PHP e Python onde o pivô seja escolhido como o elemento do meio do array em vez do primeiro.

Comparação de Desempenho:
Compare o tempo de execução do Quicksort em PHP e Python para arrays de 10.000 números aleatórios. Utilize funções de tempo como microtime(true) em PHP e time.perf_counter() em Python.

Ordenação Decrescente:
Modifique o Quicksort para ordenar o array em ordem decrescente.

Contagem de Chamadas Recursivas:
Adapte o Quicksort para contar o número de chamadas recursivas feitas durante a execução. Exiba esse valor ao final da ordenação.

Arrays com Elementos Repetidos:
Teste o Quicksort com um array que contém muitos elementos repetidos e observe o comportamento do algoritmo.

Ordenação de Strings:
Modifique o Quicksort para ordenar um array de strings em vez de números.

Ordenação de Dicionários/Associative Arrays:
Em Python, ordene uma lista de dicionários baseada em um valor específico usando Quicksort. Em PHP, faça o mesmo com arrays associativos.

Verificação de Ordenação:
Escreva uma função para verificar se um array retornado pelo Quicksort está realmente ordenado.

Quicksort Iterativo:
Em vez de usar recursão, implemente uma versão iterativa do Quicksort usando uma pilha.

Uso de um Pivô Aleatório:
Modifique o algoritmo para selecionar um pivô aleatório em cada chamada recursiva. Verifique como isso afeta a eficiência para arrays quase ordenados.
*
*
*
*
* Desafios Adicionais
Escolha de Pivô: Compare o desempenho do Quicksort usando diferentes estratégias de pivô (primeiro elemento, último elemento, elemento do meio, pivô aleatório).
Dados em Arquivos: Implemente o Quicksort para ordenar os números lidos de um arquivo e gravar o resultado ordenado em outro arquivo.
Estes exercícios cobrem diversos conceitos importantes e irão aprofundar sua compreensão de Quicksort.
* */


/*


5. Quicksort com Ordem Decrescente
Modifique o Quicksort para ordenar os elementos em ordem decrescente.

6. Quicksort para Listas com Números Duplicados
Altere a implementação do Quicksort para lidar de forma eficiente com listas que contêm muitos elementos repetidos.

7. Quicksort com Partição Lomuto e Hoare
Implemente o Quicksort duas vezes usando as estratégias de partição de Lomuto e de Hoare. Compare o desempenho.

8. Quicksort Iterativo
Implemente uma versão iterativa do Quicksort, substituindo a recursão por uma pilha explícita.

9. K-ésimo Menor Elemento usando Quicksort
Use a técnica de Quicksort para encontrar o K-ésimo menor elemento em uma lista sem ordenar toda a lista.

10. Verificação de Estabilidade do Quicksort
Escreva um experimento para testar se o Quicksort é um algoritmo de ordenação estável. Explique por que ele não é considerado estável.
*/

/*
*1. Implementação Básica do Quicksort
*Escreva um algoritmo para implementar o Quicksort em uma lista de números inteiros.
*Use o primeiro elemento como pivô.*
*
* Exercício 1: Implementação Básica do Quicksort
* */
public void quickSortBasic(int[] array, int low, int hight){
    if (low < hight){
        int pivoIndex = partition(array, low, hight);
        quickSortBasic(array, low, pivoIndex - 1);
        quickSortBasic(array, pivoIndex + 1, hight);
    }
}
private int partition(int[] array, int low, int hight){
    int pivo = array[hight]; // Escolhe o último elemento como pivô
    int i = low - 1;         // Marca a posição para elementos menores
    for(int j = low; j < hight; j++){
        if(array[j] <= pivo){
            i++;
            swap(array, i, j); // Move o elemento menor para a esquerda
        }
    }
    swap(array, i + 1, hight); // Move o pivô para sua posição correta
    return i + 1;              // Retorna o índice do pivô
}
private void swap(int[] array, int i, int j){
    int aux  = array[i];
    array[i] = array[j];
    array[j] = aux;
}

/*
*2. Quicksort com Pivô Aleatório
*Modifique a implementação do Quicksort para escolher um pivô aleatório em vez do primeiro ou último elemento.
*
* Exercicio 2: Quicksort com Pivo Aleatorio
* */
public void quickSortRandomPivot(int[] array, int low, int hight){
    if(low < hight){
        int pivotIndex = randomPartition(array, low, hight);
        quickSortRandomPivot(array, low, pivotIndex - 1);
        quickSortRandomPivot(array, pivotIndex + 1, hight);
    }
}
private int randomPartition(int[] array, int low, int high){
    int pivotIndex = low + new Random().nextInt(high - low + 1);
    swap(array, pivotIndex, high);
    return partition(array, low, high);
}

/*
*
* 3. Quicksort para Ordenar Strings
*Implemente o Quicksort para ordenar um array de strings em ordem lexicográfica.
*
* Exercicio 3: Quicksort para Ordenar Strings
* */
public void quickSortStrings(String[] array, int low, int hight){
    if(low < hight){
        //
    }
}
private int partition(String[] array, int low, int hight){
    String pivot = array[hight];
    int i = low - 1;
    for (int j = low; j < hight; j++) {
        if(array[j].compareTo(pivot) <= 0){
            i++;
            swap(array, i, j);
        }
    }
    swap(array, i + 1, hight);
    return i = 1;
}
private void swap(String[] array, int i, int j){
    String aux = array[i];
    array[i]   = array[j];
    array[j]   = aux;
}

/*
*
* 4. Contagem de Comparações no Quicksort
*Adapte o algoritmo para contar o número de comparações realizadas durante a ordenação.
*
*Exercicio 4: Contagem de Comparacoes no Quicksort
* */
static int comparisonCount = 0;
public void quickSortWithComparisons(int[] array, int low, int hight){
    if (low < hight) {
        int pivotIndex = partition(array, low, hight);
        quickSortWithComparisons(array, low, pivotIndex - 1);
        quickSortWithComparisons(array, pivotIndex + 1, hight);
    }
}
private int partitionComparison(int[] array, int low, int hight){
    int pivot = array[hight];
    int i = low - 1;

    for (int j = low; j < hight; j++) {
        comparisonCount++;
        if (array[j] <= pivot) {
            i++;
            swap(array, i, j);
        }
    }

    swap(array, i + 1, hight);
    return i + 1;
}


}
