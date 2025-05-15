import java.util.List;

public class MainDfs {
    public static void main(String[] args) {
        /*
        int n = 5; // número de vértices
        Dfs dfs = new Dfs();

        dfs.initializeGraph(n);

        // Adiciona as arestas
        dfs.eddEdge(0,1);
        dfs.eddEdge(0,2);
        dfs.eddEdge(1,3);
        dfs.eddEdge(2,3);
        dfs.eddEdge(2,4);

        // Inicializa a busca a partir do nó 0
        dfs.dfs(0);

        ✅ Saída esperada:
        Igual ao anterior:

        Visitando: 0
        Visitando: 1
        Visitando: 3
        Visitando: 2
        Visitando: 4
        */


        /*
        var detector = new Dfs();
        int n = 4;
        detector.initializeGraph(n);

        // cria um grafo com ciclo
        detector.eddEdge(0, 1);
        detector.eddEdge(1, 3);
        detector.eddEdge(3, 2);
        detector.eddEdge(2, 0); // ciclo fechado!

        if (detector.containsCycle()){
            System.out.println("grafo contém ciclo");
        }
        else{
            System.out.println("Grafo não contem ciclo");
        }
        // ✅ Saída esperada:
        // Grafo contém ciclo.*/

        /*
        var detector = new Dfs();
        int n = 4;
        detector.initializeGraph(n);


        // Adiciona arestas direcionadas
        detector.addEdge(0, 1);
        detector.addEdge(1, 2);
        detector.addEdge(2, 3);
        detector.addEdge(3, 0); // ciclo: 0 → 1 → 2 → 3 → 0

        if(detector.containsCycle()){
            System.out.println("Grafo direcionado contém ciclo");
        }
        else{
            System.out.println("Grafo direcionado não contém ciclo");
        }

        // ✅ Saída esperada:
        // Grafo direcionado contém ciclo.*/

        /*
        var counter = new Dfs();
        int n = 5;
        counter.initializeGraph(n);

        // Adiciona arestas entre os vértices
        counter.eddEdge(0, 1);
        counter.addEdge(3, 4);
        // vértices 2 está isolado

        int total = counter.countComponents();
        System.out.println("Total de componentes conexas: " + total);

        // ✅ Saída esperada:
        // Total de componentes conexas: 3*/

        /*
        var finder = new Dfs();
        int n = 4;
        finder.initializeGraph(n);

        finder.addEdge(0, 1);
        finder.addEdge(1, 2);
        finder.addEdge(1, 3);

        int start = 0;
        int end = 3;

        List<Integer> caminho = finder.findPath(start, end);

        if (caminho.isEmpty()) {
            System.out.println("Nenhum caminho encontrado.");
        } else {
            System.out.print("Caminho encontrado: ");
            for (int node : caminho) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
        // ✅ Saída esperada:
        // Caminho encontrado: 0 1 3*/

        /*
        var finder = new Dfs();
        int n = 4;
        finder.initializeGraph(n);

        finder.addEdge(0, 1);
        finder.addEdge(0, 2);
        finder.addEdge(1, 2);
        finder.addEdge(1, 3);

        int start = 0;
        int end   = 3;

        System.out.println("Todos so caminhos entre "+start+" e "+ end +":");
        finder.printAllPaths(start, end);
        // ✅ Saída esperada:
        //Todos os caminhos entre 0 e 3:
        //[0, 1, 3]
        //[0, 2, 1, 3]*/

        /*
        var counter = new Dfs();

        char[][] gird ={
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        int total = counter.countIsland(gird);
        System.out.println("Números de ilhas: "+ total);

        // ✅ Saída esperada:
        // Número de ilhas: 3*/

        /*
        var solver = new Dfs();

        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        System.out.println("Antes:");
        printBoard(board);

        solver.solve(board);

        System.out.println("\nDepois:");
        printBoard(board);
        // ✅ Saída esperada:*/
        /*
        Antes:
        X X X X
        X O O X
        X X O X
        X O X X

        Depois:
        X X X X
        X X X X
        X X X X
        X O X X

        */

        /*
        var painter = new Dfs();

        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };

        int sr = 1, sc = 1;
        int newColor = 2;

        System.out.println("Antes:");
        printImage(image);

        int[][] result = painter.floodFill(image, sr, sc, newColor);

        System.out.println("\nDepois:");
        printImage(result);*/
        // ✅ Saída esperada:
        /*
        Antes:
        1 1 1
        1 1 0
        1 0 1

        Depois:
        2 2 2
        2 2 0
        2 0 1
       */

        /*
        var solver = new Dfs();

        char[][] maze = {
                {'S', '0', '1', '0'},
                {'1', '0', '1', '0'},
                {'0', '0', '0', 'E'}
        };

        System.out.println("Labirinto:");
        printMaze(maze);

        boolean caminho = solver.solvemaze(maze);
        System.out.println("\nExiste caminho: " + caminho);*/
        // ✅ Saída esperada:
        /*
        Labirinto:
        S 0 1 0
        1 0 1 0
        0 0 0 E

        Existe caminho: true
         */



    }

    private static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    private static void printImage(int[][] image) {
        for (int[] row : image) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }

    private static void printMaze(char[][] maze) {
        for (char[] row : maze) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}
