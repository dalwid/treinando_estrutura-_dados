import java.util.*;

public class QuickSort {
/*
*Implementação personalizada:
Escreva uma versão do Quicksort em PHP e Python onde o pivô seja escolhido como o elemento do meio do array em vez do primeiro.

Comparação de Desempenho:
Compare o tempo de execução do Quicksort em PHP e Python para arrays de 10.000 números aleatórios. Utilize funções de tempo como microtime(true) em PHP e time.perf_counter() em Python.

3. Ordenação Decrescente:
Modifique o Quicksort para ordenar o array em ordem decrescente.

4. Contagem de Chamadas Recursivas:
Adapte o Quicksort para contar o número de chamadas recursivas feitas durante a execução. Exiba esse valor ao final da ordenação.

5. Arrays com Elementos Repetidos:
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

/*
*5. Quicksort com Ordem Decrescente
*Modifique o Quicksort para ordenar os elementos em ordem decrescente.
*
* Exercício 5: Quicksort com Ordem Decrescente
* */
public void quickSortDescending(int[] array, int low, int hight){
    if(low < hight){
        int pivotIndex = partitionDescending(array, low, hight);
        quickSortDescending(array, low, pivotIndex - 1);
        quickSortDescending(array, pivotIndex + 1, hight);
    }
}
private int partitionDescending(int[] array, int low, int hight){
    int pivot = array[hight];
    int i = low - 1;

    for (int j = low; j < hight; j++) {
        if(array[j] >= pivot){ // Note the  >= for descendinding order
            i++;
            swap(array, i + 1, hight);
        }
    }

    swap(array, i + 1, hight);
    return i + 1;
}

// *********************************************************************************************************************
//                                             Quick Sort Fundamental
// *********************************************************************************************************************

/*
*
*1. Implementação personalizada:
*Escreva uma versão do Quicksort em PHP e Python onde o pivô seja escolhido como o elemento do meio do array em vez do primeiro.
*
*   Escolhendo o pivô como elemento do meio
**/
public int[] quickSortPivotMiddle(int[] array){
    if(array.length < 2){
        return array;
    }
    int pivot     = array[array.length / 2];
    int[] less    = Arrays.stream(array).filter(x -> x < pivot).toArray();
    int[] equal   = Arrays.stream(array).filter(x -> x > pivot).toArray();
    int[] greater = Arrays.stream(array).filter(x -> x > pivot).toArray();
    return concatenate(quickSortPivotMiddle(less), equal, quickSortPivotMiddle(greater));
}
private int[] concatenate(int[] less, int[] equal, int[] greater){
    int[] result = new int[less.length + equal.length + greater.length];
    System.arraycopy(less, 0, result, 0, less.length);
    System.arraycopy(equal, 0, result, less.length, equal.length);
    System.arraycopy(greater, 0, result, less.length + equal.length, greater.length);
    return result;
}

/*
*
*2. Comparação de Desempenho:
*Compare o tempo de execução do Quicksort em PHP e Python para arrays de 10.000 números aleatórios.
* Utilize funções de tempo como microtime(true) em PHP e time.perf_counter() em Python.
*
*   Comparação de desempenho
* */
public void quickSortPerformance(int[] array){
    int[] arr = new Random().ints(10000, 1, 10001).toArray();
    long startTime = System.nanoTime();
    this.quickSortPivotMiddle(arr);
    long endTime = System.nanoTime();
    System.out.println("Tempo de execuçao: %.4f segundos%n " + (endTime - startTime) / 1e9);

}

/*
 *
 *3. Ordenação Decrescente:
 *Modifique o Quicksort para ordenar o array em ordem decrescente.
 *
 * Ordenação decrescente
 * */
public int[]  quickSortDesc(int[] array){
    if(array.length < 2){
        return array;
    }

    int pivot = array[0];
    int[] greater = Arrays.stream(array, 1, array.length).filter(x -> x >= pivot).toArray();
    int[] less    = Arrays.stream(array, 1, array.length).filter(x -> x < pivot).toArray();
    return concatenate(quickSortDesc(greater), new int[]{pivot}, quickSortDesc(less));
}

/*
*
* 4. Contagem de Chamadas Recursivas:
*Adapte o Quicksort para contar o número de chamadas recursivas feitas durante a execução. Exiba esse valor ao final da ordenação.
*
* Contagem de chamadas recursivas
* */
private int callCount = 0;
public int getCount(){ return this.callCount;}
    public void setCount(int count){ this.callCount = count; }

public int[] quickSortCount(int[] array){

    setCount(this.getCount() + 1);

    if(array.length < 2){
        return array;
    }

    int pivot = array[0];
    int[] less    = Arrays.stream(array, 1, array.length).filter(x -> x <= pivot).toArray();
    int[] greater = Arrays.stream(array, 1, array.length).filter(x -> x > pivot).toArray();
    return concatenate(quickSortCount(less), new int[]{pivot}, quickSortCount(greater));
}

/*
*
* 5. Arrays com Elementos Repetidos:
*Teste o Quicksort com um array que contém muitos elementos repetidos e observe o comportamento do algoritmo.
*
* Arrays com elementos repetitidos
* */
public int[] quickSortRepeat(int[] array){

    if(array.length < 2){
        return array;
    }

    int pivot = array[0];
    int[] less    = Arrays.stream(array, 1, array.length).filter(x -> x <= pivot).toArray();
    int[] greater = Arrays.stream(array, 1, array.length).filter(x -> x > pivot).toArray();
    return concatenate(quickSortCount(less), new int[]{pivot}, quickSortCount(greater));
}

/*
*
*9. Quicksort Iterativo:
*Em vez de usar recursão, implemente uma versão iterativa do Quicksort usando uma pilha.
*
* Quicksort interativo
* */
public void quickSortInterative(int[] array){
    Stack<int[]> stack = new Stack<>();
    stack.push(new int[]{0, array.length - 1});
    while(!stack.isEmpty()){
        int[] range = stack.pop();
        int start = range[0], end = range[1];
        if (start >= end){
            continue;
        }
        int pivot = array[start];
        int low = start + 1, hight = end;
        while (low <= hight){
            while(low <= hight && array[low] <= pivot) low++;
            while(low <= hight && array[hight] >= pivot) hight--;
            if(low < hight){
                swap(array, low, hight);
            }
        }

        swap(array, start, hight);
        stack.push(new int[]{start, hight - 1});
        stack.push(new int[]{hight + 1, end});

    }
}

/*
*
*10. Uso de um Pivô Aleatório:
*Modifique o algoritmo para selecionar um pivô aleatório em cada chamada recursiva.
* Verifique como isso afeta a eficiência para arrays quase ordenados.
*
*  Pivô aleatório
* */
public int[] quickSortRandomPivot(int[] array){
    if(array.length < 2){
        return array;
    }

    int pivot     = array[new Random().nextInt(array.length)];
    int[] less    = Arrays.stream(array).filter(x -> x < pivot).toArray();
    int[] equal   = Arrays.stream(array).filter(x -> x == pivot).toArray();
    int[] greater = Arrays.stream(array).filter(x -> x > pivot).toArray();

    return concatenate(quickSortRandomPivot(less), equal, quickSortRandomPivot(greater));
}


}



