import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args){
        var typesSort = new SelectionSort();
        var quickSort = new QuickSort();

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

        pessoas = typesSort.selectionSortObjects(pessoas);

        // Exibindo o resultado ordenado
        /*
        System.out.println("Pessoas ordenadas por idade:");
        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa.getNome() + " - " + pessoa.getIdade() + " anos");
        }*/

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
        int[] range = {5, 2, 9, 1, 5, 6};
        int start = 1;
        int end = 4;
        int[] result = typesSort.selectionSortRange(array, start, end);
//        System.out.println("Array parcialmente ordenado:");
//        for (int num : result) {
//            System.out.print(num + " ");
//        }

        int[] stepsBySteps = {29, 10, 14, 37, 13, 5};
        //int[] animated = typesSort.selectionSortAnimated(stepsBySteps);
//        for (int steps : animated){
//            System.out.print(Arrays.toString(animated));
//        }

        //System.out.println(Arrays.toString(typesSort.selectionSort(array)));
        int[] recursive = {64, 25, 12, 22, 11};
        //System.out.println(Arrays.toString(typesSort.selectionSortRecursive(recursive, 0)));

        int[] arr = {10, 7, 8, 9, 1, 5, 15, 13};  // Exemplo de array desordenado
        /*System.out.println("Array original: " + Arrays.toString(arr));
        quickSort.quickSortBasic(arr, 0, arr.length - 1);  // Chamando o Quicksort
        System.out.println("Array ordenado: " + Arrays.toString(arr));*/
        /*
        quickSort.quickSortRandomPivot(arr, 0, array.length - 1);
        System.out.println(Arrays.toString(arr));*/

        quickSort.quickSortWithComparisons(arr, 0, array.length - 1 );
        //System.out.println(Arrays.toString(arr));

        quickSort.quickSortDescending(range, 1, range.length - 1);
        //System.out.println(Arrays.toString(range));

        int[] quickArray = {10, 5, 2, 3, 7, 6};
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

        quickSort.runTestTime();

    }
}