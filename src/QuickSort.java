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


/*
*
* 6. Quicksort para Listas com Números Duplicados
*Altere a implementação do Quicksort para lidar de forma eficiente com listas que contêm muitos elementos repetidos.
*
* */
public void sortToQuickSort(int[] array){
    if(array == null || array.length == 0){
        return;
    }
    threeWayQuickSort(array, 0, array.length - 1);
}

private void threeWayQuickSort(int[] array, int low, int hight){
    if(low >= hight){
        return;
    }

    int[] pivotRange = myPartition(array, low, hight);
    threeWayQuickSort(array, low, pivotRange[0] - 1);
    threeWayQuickSort(array, pivotRange[1] + 1, hight);
}

private int[] myPartition(int[] array, int low, int hight){
    int pivot = array[low];
    int lt    = low;
    int gt    = hight;
    int i     = low + 1;

    while (i <= gt){
        if(array[i] < pivot){
            swap(array, lt++, i++);
        }
        else if(array[i] > pivot){
            swap(array, i, gt--);
        }
        else{
            i++;
        }
    }

    return new int[]{lt, gt};
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

/*
O Quicksort é um algoritmo de ordenação eficiente que utiliza a estratégia de "dividir para conquistar".
Ele funciona selecionando um elemento chamado pivô e particionando a array de forma que os elementos menores que o
pivô fiquem à esquerda e os maiores à direita.
Em seguida, o algoritmo é aplicado recursivamente às sub-arrays à esquerda e à direita do pivô.

Existem diferentes métodos para realizar a partição,
sendo os mais comuns o Lomuto e o Hoare. Vou explicar ambos e mostrar como implementá-los.


1. Partição de Lomuto

A partição de Lomuto é mais simples de entender,
mas geralmente menos eficiente que a de Hoare. O pivô é escolhido como o último elemento da array.

Passos:

   1. Escolha o último elemento como pivô.

   2. Percorra a array com um índice i que mantém a posição onde os elementos menores que o pivô serão colocados.

   3. Para cada elemento, se ele for menor que o pivô, mova-o para a posição i e incremente i.

   4. No final, coloque o pivô na posição correta (índice i).
*/
public int lomutoPartition(int[] array, int low, int high){
    int pivot = array[high]; // Escolhe o último elemento como pivô
    int i = low - 1; // Índice do menor elemento

    for (int j = low; j < high; j++) {
        if (array[j] < pivot) {
            i++;
            // Troca arr[i] e arr[j]
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    // Coloca o pivô na posição correta
    int temp     = array[i + 1];
    array[i + 1] = array[high];
    array[high]  = temp;

    return i + 1; // Retorna a posição do pivô
}
public void quickSortLomuto(int[] array, int low, int high){
    if (low < high) {
        int pi = lomutoPartition(array, low, high); // Índice do pivô
        quickSortLomuto(array, low, pi - 1); // Ordena a sub-array à esquerda
        quickSortLomuto(array, pi + 1, high); // Ordena a sub-array à direita
    }
}

/*
2. Partição de Hoare

A partição de Hoare é mais eficiente que a de Lomuto, pois realiza menos trocas.
O pivô é escolhido como o primeiro elemento da array.

Passos:

   1. Escolha o primeiro elemento como pivô.

   2. Use dois índices, i e j, que começam nas extremidades da array e se movem em direção ao centro.

   3. Enquanto i encontra elementos menores que o pivô, ele avança.

   4. Enquanto j encontra elementos maiores que o pivô, ele retrocede.

   5. Quando i e j se cruzam, a partição está concluída.
*/
public int hoarePartition(int[] array, int low, int high){
    int pivot = array[low]; // Escolhe o primeiro elemento como pivô
    int i = low - 1;
    int j = high + 1;

    while (true) {
        // Avança i enquanto arr[i] < pivô
        do {
            i++;
        } while (array[i] < pivot);

        // Retrocede j enquanto arr[j] > pivô
        do {
            j--;
        } while (array[j] > pivot);

        // Se i e j se cruzarem, retorna j
        if (i >= j) {
            return j;
        }

        // Troca arr[i] e arr[j]
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

// Função principal do Quicksort com Hoare
public void quickSortHoare(int[] array, int low, int high){
    if (low < high) {
        int pi = hoarePartition(array, low, high); // Índice do pivô
        quickSortHoare(array, low, pi); // Ordena a sub-array à esquerda
        quickSortHoare(array, pi + 1, high); // Ordena a sub-array à direita
    }
}

// Gera um array de tamnho 'size' com números aleatórios
public int[] generateRandomArray(int size){
    Random random = new Random();
    int[] array = new int[size];
    for (int i = 0; i < size; i++) {
        array[i] = random.nextInt(1000000); // Números entre 0 e 999.999
    }

    return array;
}

// Mede o tempo de execução de uma função de ordenação
public long measureTime(Runnable sortingFunction){
    long startTime = System.nanoTime();
    sortingFunction.run();
    long endTime = System.nanoTime();
    return endTime - startTime;
}

public void runTestTime(){
    int[] sizes = {10000, 100000, 1000000}; // Tamanhos dos arrays
    int iterations = 5; // Número de interações para casa teste

    for (int size : sizes){
        System.out.println("Testando com array de tamanho: "+size);
        long totalTimeLomuto = 0;
        long totalTimeHoare  = 0;

        for (int i = 0; i < iterations; i++) {
            int[] array = generateRandomArray(size);

            // Testa lomuto
            int[] arrayLomuto = array.clone(); // Clona o array não agetar o original
            totalTimeLomuto  += measureTime(()-> quickSortLomuto(arrayLomuto, 0, arrayLomuto.length - 1));

            // Testa Hoare
            int[] arrayHoare = array.clone();// Clona o array apra não afetar o original
            totalTimeHoare  += measureTime(()-> quickSortHoare(arrayHoare, 0, arrayHoare.length - 1));
        }

        // Calcula a média de tempo para casa algoritmo
        long avgTimeLomuto = totalTimeLomuto / iterations;
        long avgTimeHoare  = totalTimeHoare / iterations;

        System.out.println("Tempo médio (Lomuto): " + avgTimeLomuto + " ns");
        System.out.println("Tempo médio (Hoare): "  + avgTimeHoare);
        System.out.println();
    }
}

}



