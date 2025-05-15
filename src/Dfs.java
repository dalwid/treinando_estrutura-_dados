import java.util.ArrayList;
import java.util.List;

/*

📚 O que é DFS (Depth-First Search)?
DFS é uma forma de percorrer os vértices de um grafo (ou os nós de uma árvore)
indo o mais fundo possível primeiro, antes de voltar e tentar outros caminhos.

*/
public class Dfs {
    /*
    🧪 Exemplo 1: DFS simples em grafo não direcionado (com lista de adjacência)
    Problema:
    Dado um grafo com 5 vértices, imprima todos os nós visitados a partir do vértice 0 usando DFS.

    Entrada (grafo):
    0 - 1
    |   |
    2 - 3
    |
    4
    */
    public List<List<Integer>> graph;
    public boolean[] visited;

    // Inciializa o grafo com n vétices
    public void initializeGraph(int n){
        graph   = new ArrayList<>();
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
    }
    // Adicionar aresta entre dois vértices (grafo não direcionado)
    public void eddEdge(int u, int v){
        graph.get(u).add(v);
        graph.get(v).add(u);
    }
    // Algoritmo de DFS
    public void dfs(int node){
        visited[node] = true;
        System.out.println("Visitado: " + node);

        for (int neighbor : graph.get(node)){
            if (!visited[neighbor]){
                dfs(neighbor);
            }
        }
    }


    /*
    🧪 Exercício 2: Detectar Ciclo em Grafo Não Direcionado
    🧩 Problema:
    Dado um grafo não direcionado, determine se ele possui algum ciclo.

    🎯 Exemplo:
    Grafo com ciclo:
    0 - 1
    |   |
    2 - 3

    Sim, tem um ciclo: 0 → 1 → 3 → 2 → 0

    Grafo sem ciclo:
    0 - 1
    |
    2
    */
    // DFS que detecta ciclos
    public boolean hasCycle(int node, int parent){
        visited[node] = true;

        for (int neighbor : graph.get(node)){
            if(!visited[neighbor]){
                // Visita recursiva
                if(hasCycle(neighbor, node)){
                    return true;
                }
            }
            else if (neighbor != parent){
                // Se o vizinho já foi e não é o pai, temos um ciclo!
                return true;
            }
        }

        return false;
    }
    public boolean containsCycle(){
        for(int i = 0; i < visited.length; i++){
            if (!visited[i]){
                if (hasCycle(i, -1)){
                    return true;
                }
            }
        }

        return false;
    }
/*
🧼 Explicação para pato de borracha:
hasCycle(node, parent) faz uma DFS:

Marca o nó como visitado.

Visita todos os vizinhos:

Se não foi visitado, faz DFS recursiva.

Se já foi visitado e não é o pai, então há um ciclo.

containsCycle() chama o DFS a partir de todos os vértices ainda não visitados (pode haver componentes desconexos).
 */


    /*
    🧪 Exercício 3: Detectar Ciclo em Grafo Direcionado
    📘 Problema:
    Dado um grafo direcionado, determine se há algum ciclo usando DFS.

    🎯 Diferença em relação ao anterior:
        Agora as arestas têm direção (de u → v, mas não necessariamente v → u).
        A detecção de ciclo em grafos direcionados usa uma técnica chamada DFS com pilha de recursão.

    📈 Exemplo:
    Grafo com ciclo:
    0 → 1 → 2
    ↑       ↓
    ← ← ← ← 3

    Tem um ciclo: 0 → 1 → 2 → 3 → 0
    */
    private boolean[] inRecursionStack; // ajuda a identificar se um nó já está "em uso" no caminho atual
    public void addEdge(int u, int v){
        graph.get(u).add(v); // apenas uma direção (grafo dirigido)
    }

    // DFS com detecção de ciclos para grafos direcionados
    public boolean hasCycle(int node){
        visited[node] = true;
        inRecursionStack[node] = true;

        for (int neighbor : graph.get(node)){
            if(!visited[neighbor]){
                if(hasCycle(neighbor)){
                    return true;
                }
            }
            else if(inRecursionStack[neighbor]){
                // ciclo encontrado: voltamos para algo que já está na pilha de recursão
                return true;
            }
        }

        inRecursionStack[node] = false; // saiu do caminho atual
        return false;
    }
    /*public boolean containsCycle(){
        for (int i = 0; i < visited.length; i++) {
            if(!visited[i]){
                if(hasCycle(i)){
                    return true;
                }
            }
        }

        return false;
    }*/
    /*
    🧼 Explicação para pato de borracha:
visited[]: marca quais nós já foram vistos.

inRecursionStack[]: marca quais nós estão na pilha de chamada atual (caminho em execução).

Se ao visitar um vizinho o DFS encontra um nó que já está na pilha, então ele detecta um ciclo direcionado.

Ao finalizar o nó, tiramos ele da pilha (inRecursionStack[node] = false).
     */



    /*

    🧪 Exercício 4: Contar Componentes Conexas em um Grafo Não Direcionado
    📘 Problema:
    Dado um grafo não direcionado, conte quantos grupos isolados de nós conectados (componentes conexas) existem.

    🎯 Exemplo:
    Entrada:
    0 - 1       2       3 - 4
    Saída:
    3 componentes conexas
    */
    /*public void dfs(int node) {
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }*/
    // Conta quantos componentes separadso existem
    public int countComponents(){
        int count = 0;
        for(int i = 0; i < visited.length; i++){
            if (!visited[i]){
                dfs(i); // começa nova busca = novo componente
                count++;
            }
        }

        return count;
    }

    
    /*
    ✅ Saída esperada:
    Total de componentes conexas: 3

    🧼 Explicação para pato de borracha:
Criamos um grafo com n vértices e usamos addEdge para ligar os vértices.

A função dfs(node) visita todos os vértices conectados diretamente e indiretamente ao node.

A função countComponents() percorre todos os vértices:

Se um vértice ainda não foi visitado, iniciamos uma nova DFS a partir dele → isso representa uma nova componente.

Incrementamos o contador de componentes.

Vértices isolados (sem vizinhos) também contam como uma componente.
     */



    /*
    🧪 Exercício 5: Encontrar um Caminho entre Dois Vértices usando DFS
    📘 Problema:
    Dado um grafo não direcionado, e dois vértices start e end, encontre um caminho qualquer entre eles usando busca em profundidade.

    🎯 Exemplo:
    Grafo:
    0 - 1 - 2
        |
        3

    Entrada:
    start = 0, end = 3

    Saída (um possível caminho):
    0 → 1 → 3
    */
    private List<Integer> path; // armazena o caminho atual
    private boolean found = false;
    public List<Integer> findPath(int start, int end){
        path = new ArrayList<>();
        found = false;
        dfs(start, end);
        return path;
    }

    private void dfs(int current, int target){
        if(found) return; // já encontramos, não continua
        visited[current] = true;
        path.add(current); // adiciona o nó atual ao caminho

        if(current == target){
            found = true;
            return;
        }

        for (int neighbor : graph.get(current)){
            if(!visited[neighbor]){
                dfs(neighbor, target);
            }
        }

        if(!found){
            path.remove(path.size() - 1); // remove se não leva ao alvo
        }
    }
    /*
    🧼 Explicação para pato de borracha:
A função dfs(current, target) começa no nó atual.

Adicionamos current ao caminho.

Se ele é o target, marcamos que encontramos e retornamos.

Senão, exploramos todos os vizinhos com DFS recursiva.

Se sair do vizinho e ainda não achou, remove o nó do caminho.

A busca termina quando found == true.
     */



    /*
    🧪 Exercício 6: Imprimir Todos os Caminhos Possíveis entre Dois Vértices usando DFS
    📘 Problema:
        Dado um grafo não direcionado e dois nós start e end,
        imprima todos os caminhos possíveis entre eles usando busca em profundidade (DFS).

     🎯 Exemplo:
     Grafo:
     0 - 1 - 3
     \  |
       2

     Entrada:
     start = 0, end = 3

     Saída:
     0 → 1 → 3
     0 → 1 → 2 → 1 → 3 ← (mas aqui evita ciclos)
     0 → 2 → 1 → 3

     Mas como evitamos visitar o mesmo nó mais de uma vez por caminho, os caminhos válidos são:
     0 → 1 → 3
     0 → 2 → 1 → 3
     */
    // Chamada externa para listar todos os caminhos
    public void printAllPaths(int start, int end){
        List<Integer> path = new ArrayList<>();
        dfs(start, end, path);
    }
    private void dfs(int current, int target, List<Integer> path){
        visited[current] = true;
        path.add(current);

        if(current == target){
            // achamos um caminho do início até  ofim
            System.out.println(path);
        }
        else{
            for (int neighbor : graph.get(current)){
                if (!visited[neighbor]){
                    dfs(neighbor, target, path);
                }
            }
        }

        // Voltando: desfaz o caminho para tentar outra rota
        visited[current] = false;
        path.remove(path.size() - 1);
    }
    /*
    🧼 Explicação para pato de borracha:
Cada vez que entramos em dfs, marcamos o nó como visitado (visited[current] = true) e o adicionamos ao caminho atual.

Se chegamos ao target, imprimimos o caminho.

Após visitar todos os caminhos possíveis a partir de um nó, desmarcamos ele (visited[current] = false) e removemos ele da lista.

Isso permite que o nó seja usado novamente em outro caminho separado.

     */



    /*
    🧪 Exercício 7: Contar o Número de Ilhas (DFS em matriz 2D)
    📘 Problema:
    Dada uma matriz binária (1 = terra, 0 = água), conte quantas ilhas existem.
    Uma ilha é um grupo de 1s conectados vertical ou horizontalmente.

    🎯 Exemplo:
    Entrada:
    1 1 0 0 0
    1 1 0 0 0
    0 0 1 0 0
    0 0 0 1 1

    Saída:
    Número de ilhas: 3
    */
    private int rows, cols;
    private boolean[][] visitedd;
    // DFS que marca a terra conectada como visitada
    private void dfs(char[][] grid, int r, int c){
        // Fora dos limites ou água ou já visitado
        if (r < 0 || r >= rows || c < 0 || c >= cols ||
                grid[r][c] == '0' || visitedd[r][c]) {
            return;
        }

        visitedd[r][c] = true;

        // Verifica vizinhos (cima, baixo, esquerda, direita)
        dfs(grid, r - 1, c); // cima
        dfs(grid, r + 1, c); // baixo
        dfs(grid, r, c - 1); // esquerda
        dfs(grid, r, c + 1); // direita
    }
    // Conta ilhas
    public int countIsland(char[][] grind){
        if(grind == null || grind.length == 0)
            return 0;

        rows = grind.length;
        cols = grind[0].length;
        visitedd = new boolean[rows][cols];

        int count = 0;
        for (int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if (grind[r][c] == '1' && !visitedd[r][c]){
                    dfs(grind, r, c); // começa nova ilha
                    count++;
                }
            }
        }

        return count++;
    }
/*
🧼 Explicação para pato de borracha:
Percorremos cada célula da matriz.

Se encontramos 1 e não foi visitado ainda, é uma nova ilha.

Chamamos dfs para "afundar" toda a ilha conectada, marcando tudo como visitado.

Cada chamada nova de DFS que começa em 1 representa uma nova ilha encontrada.
 */




    /*
    🧪 Exercício 8: Capturar Regiões Cercadas (DFS em Grade 2D)
    📘 Problema:
        Dada uma matriz com 'X' e 'O', capture todas as regiões cercadas por 'X'.
        Uma região é cercada se nenhum 'O' nela toca a borda da matriz.
        Substitua 'O' por 'X' se estiver completamente cercado.

    🎯 Exemplo:
    Entrada:
    X X X X
    X O O X
    X X O X
    X O X X

    Saída:
    X X X X
    X X X X
    X X X X
    X O X X

    🧠 Por quê?
        O 'O' da última linha não é cercado (está na borda).
        Os 'O' internos (2ª e 3ª linha) estão cercados por 'X'.
    */
    public void solve(char[][] board){
        if(board == null || board.length == 0)
            return;

        rows = board.length;
        cols = board[0].length;

        // Marcar todos os 'O' conectados à borda como seguros
        for (int r = 0; r < rows; r++){
            dfsII(board, r, 0);         // esquerda
            dfsII(board, r, cols - 1);  // direita
        }
        for (int c = 0; c < cols; c++){
            dfsII(board, 0, c);        // topo
            dfsII(board, rows - 1, c); // base
        }

        // Agora converte os 'O' internos e restaura os seguros
        for (int r = 0; r < rows; r++){
            for (int c = 0; c < cols; c++){
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';  // cercado: captura
                }
                else if (board[r][c] == '*') {
                    board[r][c] = 'O';  // seguro: restaura
                }
            }
        }
    }
    private void dfsII(char[][] board, int r, int c) {
        if (r < 0 || r >= rows || c < 0 || c >= cols || board[r][c] != 'O') {
            return;
        }

        board[r][c] = '*'; // 🦆 marca como seguro

        dfsII(board, r - 1, c); // cima
        dfsII(board, r + 1, c); // baixo
        dfsII(board, r, c - 1); // esquerda
        dfsII(board, r, c + 1); // direita
    }
/*
🧼 Explicação para pato de borracha:
DFS nas bordas: Marca todos os 'O' conectados à borda com '*' → são seguros.

Varre tudo:

'O' não marcado? → está cercado → vira 'X'.

'*'? → é seguro → vira 'O' de volta.

O resultado final mostra as regiões capturadas corretamente.
 */



    /*
    🧪 Exercício 9: Flood Fill (Pintura de Área)
    📘 Problema:
        Dada uma matriz de cores (números inteiros), uma posição inicial (sr, sc) e uma nova cor,
        pinte toda a área conectada à cor original com a nova cor usando DFS.

    🎯 Exemplo:
    Entrada:
    image = {
        {1, 1, 1},
        {1, 1, 0},
        {1, 0, 1}
    };
    start = (1, 1), newColor = 2


    Saída:
    {
        {2, 2, 2},
        {2, 2, 0},
        {2, 0, 1}
    }
    */
    private int originalColor;
    private int[][] image;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor){
        rows = image.length;
        cols = image[0].length;
        this.image = image;
        originalColor = image[sr][sc];

        if(originalColor != newColor){
            dfs(sr, sc, newColor);
        }

        return image;
    }
    private void dfs(int r, int c, int newColor){
        if(r < 0 || r >= rows || c < 0 || c >= cols)
            return;

        if (image[r][c] != originalColor)
            return;

        image[r][c] = newColor;

        dfs(r - 1, c, newColor); // cima
        dfs(r + 1, c, newColor); // baixo
        dfs(r, c - 1, newColor); // esquerda
        dfs(r, c + 1, newColor); // direita
    }
    /*
    🧼 Explicação para pato de borracha:
Pegamos a cor original da posição inicial.

Começamos a DFS só se a nova cor for diferente (evita laços infinitos).

Em cada passo:

Se o pixel tem a cor original, trocamos pela nova.
Chamamos DFS nos 4 lados (cima, baixo, esquerda, direita).
Paramos quando os pixels ao redor têm outra cor ou saímos dos limites.

🖌️ Resumo:
Você agora sabe pintar áreas com DFS como o "balde de tinta" no Paint!
     */




    /*
    🧪 Exercício 10: Resolver um Labirinto com DFS
    📘 Problema:
    Dado um labirinto representado por uma matriz, encontre se há um caminho entre o ponto S (start) e o E (end).

    O labirinto é feito de:
    0 = caminho livre

    1 = parede

    S = início

    E = saída

    Queremos saber se existe um caminho possível de S até E usando DFS.

    🎯 Exemplo:
    Entrada:
    S 0 1 0
    1 0 1 0
    0 0 0 E

    Saída:
    Existe caminho: true
    */
    private char[][] maze;
    private boolean foundd  = false;

    public boolean solvemaze(char[][] maze){
        this.maze = maze;
        rows = maze.length;
        cols = maze[0].length;
        visitedd = new boolean[rows][cols];

        int startRow = 1, startCol = - 1;

        // Encontrar o ponto 'S'
        for (int r = 0; r < rows; r++){
            for (int c = 0; c < cols; c++ ){
                if (maze[r][c] == 'S'){
                    startRow = r;
                    startCol = c;
                    break;
                }
            }
        }

        if (startRow == -1)
            return false; // sem ponto de início!

        dfsIII(startRow, startCol);
        return foundd;
    }
    private void dfsIII(int r, int c){
        if (r < 0 || r >= rows || c < 0 || c >= cols ||
        maze[r][c] == '1' || visitedd[r][c] || foundd){
            return;
        }

        if (maze[r][c] == 'E'){
            foundd = true;
            return;
        }

        visitedd[r][c] = true;

        dfsIII(r - 1, c); // cima
        dfsIII(r + 1, c); // baixo
        dfsIII(r, c - 1); // esquerda
        dfsIII(r, c + 1); // direita
    }
    /*
    🧼 Explicação para pato de borracha:
Procuramos o ponto 'S' no labirinto.

A partir dele, fazemos DFS para todos os lados.

Se encontrarmos o 'E', marcamos found = true.

A DFS para quando:

Saímos dos limites,

Encontramos uma parede (1),

Já visitamos,

Ou já encontramos a saída (found = true).

No final, retornamos se conseguimos ou não encontrar a saída.
     */

}
