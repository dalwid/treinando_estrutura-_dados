import java.util.Arrays;

/*
*               O(n²)
* */
public class SelectionSort {
/*
1. Implementação Básica
Implemente a ordenação por seleção para ordenar um arrayay de números inteiros em ordem decrescente.
*/
// 1. Selection Sort in descending
public int[] selectionSortDescending(int[] array){
    int n = array.length;

    for (int i = 0; i < n - 1; i++) {
        int index = i;
        for (int j = i + 1; j < n; j++) {
            if(array[j] < array[index]){ index = j; }
        }

        int aux = array[i];
        array[i] = array[index];
        array[index] = aux;
    }

    return array;
}

/*
2. Ordenação de Strings
Modifique o algoritmo de ordenação por seleção para ordenar um arrayay de strings em ordem alfabética
*/
// 2. Selection Sort for strings in alphabet order
public String[] selectionSortStrings(String[] array){
    int n = array.length;
    for (int i = 0; i < n - 1; i++) {
        int index = i;
        for (int j = i + 1; j < n; j++) {
            if(array[j].compareTo(array[index]) < 0){
                index = j;
            }
        }

        String aux   = array[i];
        array[i]     = array[index];
        array[index] = aux;
    }

    return array;
}


/*
3. Ordenação de arrayays de Objetos
Use a ordenação por seleção para ordenar um arrayay de objetos,
como pessoas com nome e idade, em ordem crescente de idade.
*/
// 3. Selection Sort objects by age
public Pessoa[] selectionSortObjects(Pessoa[] pessoas) {
    int n = pessoas.length;
    for (int i = 0; i < n - 1; i++) {
        int index = i;
        for (int j = i + 1; j < n; j++) {
            if (pessoas[j].getIdade() < pessoas[index].getIdade()) {
                index = j;
            }
        }

        Pessoa aux = pessoas[i];
        pessoas[i] = pessoas[index];
        pessoas[index] = aux;
    }
    return pessoas;
}



/*
4. Contagem de Comparações
Altere o algoritmo para contar o número total de comparações feitas durante a ordenação e exiba o resultado.
*/
// 4. Counting comparisons in Selection Sort
public int selectionSortCountComparisons(int[] array){
    int n = array.length;
    int comparisons = 0;
    for (int i = 0; i < n - 1; i++) {
        int index = i;
        for (int j = i + 1; j < n; j++) {
            comparisons++;
            if(array[j] < array[index]){
                index = j;
            }
        }

        int aux      = array[i];
        array[i]     = array[index];
        array[index] = aux;
    }

    return comparisons;
}


/*
5. Contagem de Trocas
Modifique o algoritmo para contar o número de trocas realizadas e exiba o total no final da execução.
*/
// 5. Counting swaps in Selection Sort
public int selectionSortCountSwaps(int[] array){
    int n = array.length;
    int swaps = 0;

    for (int i = 0; i < n - 1; i++) {
        int index = i;
        for (int j = i + 1; j < n; j++) {
            if(array[j] < array[index]){
                index = j;
            }
        }

        int aux      = array[i];
        array[i]     = array[index];
        array[index] = aux;
        swaps++;
    }

    return swaps;
}

/*
6. Ordenação Parcial
Escreva uma versão da ordenação por seleção que ordene apenas os 5 menores elementos de um arrayay, deixando o restante intacto.
*/
// 6. Partial Selection Sort (first k smallest elements)
public static int[] selectionSortPartial(int[] array, int k) {
    int n = array.length;
    for (int i = 0; i < Math.min(k, n); i++) {
        int index = i;
        for (int j = i + 1; j < n; j++) {
            if (array[j] < array[index]) {
                index = j;
            }
        }
        // Correção: troca usando a variável auxiliar corretamente
        int aux = array[i];
        array[i] = array[index];
        array[index] = aux;  // Corrigido para evitar a atribuição errada
    }

    return array;
}


/*
7. Ordenação de Matrizes (Bidimensional)
Use a ordenação por seleção para ordenar as linhas de uma matriz bidimensional com base na soma de seus elementos.
*/
// 7. Selection Sort for matrices by row sum
public int[][] selectionSOrtMatrix(int[][] matrix){
    int n = matrix.length;

    for (int i = 0; i < n - 1; i++) {
        int index = i;
        for (int j = i + 1; j < n; j++) {
            if(Arrays.stream(matrix[j]).sum() < Arrays.stream(matrix[index]).sum()){
                index = j;
            }
        }

        int[] aux     = matrix[i];
        matrix[i]     = matrix[index];
        matrix[index] = aux;
    }

    return matrix;
}


/*
8.Maior para Menor em Intervalos
Ordene um intervalo específico de um array (por exemplo, índices de 3 a 7)
usando ordenação por seleção, mantendo o restante do arrayay inalterado.
*/
// 8. Selection Sort for a specific range (from index 3 to 7)
public int[] selectionSortRange(int[] array, int start, int end) {
    int n = array.length;

    for (int i = start; i <= Math.min(end, n - 1); i++) {
        int index = i;
        for (int j = i + 1; j <= Math.min(end, n - 1); j++) {
            if (array[j] < array[index]) {
                index = j;
            }
        }
        int aux = array[i];
        array[i] = array[index];
        array[index] = aux;  // Correção aqui
    }

    return array;
}


/*
9. Verificação de arrayay já Ordenado
Antes de iniciar a ordenação,
adicione uma verificação para determinar se o arrayay já está ordenado e pule o processo se for o caso.
*/
// 9. Checking if an array is sorted
public boolean isSoterd(int[] array){
    for (int i = 1; i < array.length; i++) {
        if (array[i - 1] > array[i]){
            return false;
        }
        return true;
    }

    return false;
}
public int[] selectionSortWithCheck(int[] array){
    if(isSoterd(array)){
        return array;
    }

    return selectionSortDescending(array);
}


/*
10. Animação de Passos da Ordenação
Implemente uma função que exiba o estado do array a cada iteração do laço externo do algoritmo de ordenação por seleção.
*/
// 10. Displaying sorting steps
public int[] selectionSortAnimated(int[] array){
    int n = array.length;
    for (int i = 0; i < n - 1; i++) {
        int minIndex = i;
        for (int j = i + 1; j < n; j++) {
            if (array[j] < array[minIndex]) {
                minIndex = j;
            }
        }
        int temp = array[i];
        array[i] = array[minIndex];
        array[minIndex] = temp;
        System.out.println("Step " + i + ": " + Arrays.toString(array));
    }
    return array;
}

/*
Desafio Extra
Implemente a ordenação por seleção em duas versões diferentes:
    Versão iterativa (tradicional).
    Versão recursiva.
*/

public int[] selectionSort(int[] array){
    int n = array.length;
    for (int i = 0; i < n - 1; i++) {
        int index = i;
        for (int j = i + 1; j < n; j++) {
            if(array[j] < array[index]){
                index = j;
            }
        }
        int aux      = array[i];
        array[i]     = array[index];
        array[index] = aux;
    }

    return array;
}

public int[] selectionSortRecursive(int[] recursive, int i) {
    int n = recursive.length;
    if (i >= n - 1) {
        return recursive;
    }

    int index = i;
    for (int j = i + 1; j < n; j++) {
        if (recursive[j] < recursive[index]) {
            index = j;
        }
    }

    // Troca os elementos
    int aux = recursive[i];
    recursive[i] = recursive[index];
    recursive[index] = aux;

    // Chamada recursiva com i + 1
    return selectionSortRecursive(recursive, i + 1);
}



}
