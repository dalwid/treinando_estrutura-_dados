import java.util.*;

public class Fbs {

/*
                           O que é Busca em Largura (BFS)?

É uma forma de explorar um grafo em camadas: primeiro os vizinhos diretos (distância 1),
depois os vizinhos dos vizinhos (distância 2), e assim por diante.


            Exercício 1: "Ache o menor caminho em uma grade simples"

Descrição: Dado um mapa 2D (uma grade) com células livres . e paredes #,
encontre o menor número de passos do canto superior esquerdo até o canto inferior direito.
Só pode andar pra cima, baixo, esquerda ou direita.

Exemplo:

Entrada:
. . #
. # .
. . .

Saída: 4
Caminho: (0,0) → (1,0) → (2,0) → (2,1) → (2,2)

-----------------------------------------------------
                    EXPLICAÇÃO
-----------------------------------------------------

🌟 Exercício 1: Menor Caminho em uma Grade
📜 Enunciado:
Você tem uma grade 2D onde:

. representa um espaço livre

# representa uma parede (bloqueado)

Você começa no canto superior esquerdo (0, 0) e quer chegar ao canto inferior direito (n-1, m-1)

Só pode andar para cima, baixo, esquerda ou direita

✅ Objetivo:
Retornar o menor número de passos para chegar ao destino. Se não for possível, retornar -1.


Estratégia (BFS):

1. Coloca o ponto de partida na fila

2. Explora todos os vizinhos possíveis

3. Marca como visitado

4. Quando chega ao destino, retorna a distância

*/
public int menorCaminho(char[][] grade){
    int n = grade.length;
    int m = grade[0].length;

    boolean[][] visitado = new boolean[n][m];
    Queue<int[]> fila = new LinkedList<>();
    fila.add(new int[]{0, 0, 0}); // x, y, passos
    visitado[0][0] = true;

    int[][] movimentos = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    while (!fila.isEmpty()){
        int[] atual = fila.poll();
        int x = atual[0], y = atual[1], passos = atual[2];

        if(x == n - 1 && y == m - 1){
            return passos;
        }

        for (int[] mov : movimentos){
            int nx = x + mov[0];
            int ny = y + mov[1];

            if(nx >= 0 && ny >= 0 && nx < n && ny < m && !visitado[nx][ny] && grade[nx][ny] == '.'){
                visitado[nx][ny] = true;
                fila.add(new int[]{nx, ny, passos + 1});
            }
        }
    }

    return - 1;
}



//    $grade = [
//            ['.', '.', '.', '#'],
//            ['#', '#', '.', '#'],
//            ['.', '.', '.', '.'],
//            ['.', '#', '#', '.']
//            ];
//
//
//#print(menor_caminho(grade))  # Saída esperada: 4



/*
                    Exercício 2: "Contando ilhas"

Descrição: Dada uma matriz de 0 (água) e 1 (terra), conte quantas ilhas separadas existem.
Uma ilha é um grupo de 1s conectados vertical ou horizontalmente.

Exemplo:

Entrada:
1 1 0 0
0 1 0 1
0 0 1 1
Saída: 2

-----------------------------------------------------
                    EXPLICAÇÃO
-----------------------------------------------------

🌊 Exercício 2: Contando Ilhas
📜 Enunciado:
Dada uma matriz com:

1 = terra

0 = água

Conte quantas ilhas separadas existem.
Uma ilha é um grupo de 1s conectados vertical ou horizontalmente.

🧠 Estratégia (BFS):
Vamos percorrer toda a matriz.

Sempre que encontrarmos um 1 não visitado, iniciamos uma busca em largura (BFS) a partir dele.

Durante a BFS, vamos marcar todos os 1s conectados (a mesma ilha).

Repetimos até visitar tudo.
*/
public int contarIlhas(int[][] matriz){
    int n = matriz.length;
    int m = matriz[0].length;

    boolean[][] visitado = new boolean[n][m];
    int[][] direcoes = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    int totalIlhas = 0;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if(matriz[i][j] == 1 && !visitado[i][j]){
                bfs(i, j, matriz, visitado, direcoes);
                totalIlhas++;
            }
        }

    }

    return totalIlhas;
}
private void bfs(int x, int y, int[][] matriz, boolean[][] visitado, int[][] direcoes){
    int n = matriz.length, m = matriz[0].length;
    Queue<int[]> fila = new LinkedList<>();
    fila.add(new int[]{x, y});
    visitado[x][y] = true;

    while (!fila.isEmpty()){
        int[] atual = fila.poll();
        int cx = atual[0], cy = atual[1];

        for (int[] dir : direcoes){
            int nx = cx + dir[0];
            int ny = cy + dir[1];

            if(nx >= 0 && ny >= 0 && nx < n && ny < m &&
                    !visitado[nx][ny] && matriz[nx][ny] == 1){
                visitado[nx][ny] = true;
                fila.add(new int[]{nx, ny});
            }
        }
    }
}


//    $entrada = [
//            [1, 1, 0, 0],
//            [0, 1, 0, 1],
//            [0, 0, 1, 1]
//            ];
//
//# print(contar_ilhas(entrada))  # Saída esperada: 2




/*
                        Exercício 3: "Rede de amigos"

Descrição: Você tem um grafo onde cada nó é uma pessoa e uma aresta indica amizade.
Dado um ID de uma pessoa, liste todos os amigos em nível 2 (amigos dos amigos), sem repetir ninguém.


-----------------------------------------------------
                    EXPLICAÇÃO
-----------------------------------------------------

Imagine assim, Pato:

Cada pessoa é uma bolinha (um nó).

Cada amizade é uma linha ligando duas bolinhas (uma aresta).

Agora, o problema é:

Dado um pato, quem são os amigos dos amigos dele?

Passos bem de pato:

Primeiro, olhamos para quem são os amigos diretos (linha ligada direto no pato).

Depois, para cada amigo, olhamos quem são os amigos deles (amigos dos amigos).

Cuidado! Um amigo de amigo pode ser:

Alguém que já era amigo direto (não queremos contar de novo),

O próprio pato (não queremos nos contar também!).

Então, coletamos só os amigos de segundo nível, sem repetir.
*/
public List<String> amigosnivel2(Map<String, List<String>> grafo, String pessoaInicial){
    Map<String, Integer> visitado = new HashMap<>();
    Queue<Pair> fila = new LinkedList<>();
    Set<String> resultado = new HashSet<>();

    fila.add(new Pair(pessoaInicial, 0));
    visitado.put(pessoaInicial, 0);

    while(!fila.isEmpty()){
        Pair atual = fila.poll();
        String pessoa = atual.nome;
        int nivel = atual.nivel;

        if (nivel >= 2){
            continue;
        }

        for (String amigo : grafo.getOrDefault(pessoa, new ArrayList<>())){
            if(!visitado.containsKey(amigo)){
                visitado.put(amigo, nivel + 1);
                fila.add(new Pair(amigo, nivel + 1));

                if (nivel + 1 == 2){
                    resultado.add(amigo);
                }
            }
        }
    }

    return new ArrayList<>(resultado);
}

/*
1 -> 2, 3
2 -> 1, 4
3 -> 1, 5
4 -> 2
5 -> 3, 6
6 -> 5


Se começarmos do 1:

Amigos diretos: 2 e 3

Amigos dos amigos: (4 a partir do 2) e (5 a partir do 3)

Logo, amigos de nível 2 são 4 e 5.

🛑 Não inclui o 1 nem repete 2 ou 3.
*/


/*
        Exercício 4: "Distância mais curta entre dois pontos em um labirinto"

Descrição: Parecido com o Exercício 1, mas agora você pode escolher
qualquer ponto inicial e final na grade, e precisa encontrar o caminho mais curto.



                Imagine, Pato:

O labirinto é uma tabela quadrada (tipo um tabuleiro).

Cada quadradinho pode ser:

Livre (você pode andar nele) → vamos representar como 0

Parede (você não pode passar) → vamos representar como 1

Você pode andar:

Para cima, para baixo, para a esquerda ou para a direita (não pode andar na diagonal).

Agora o desafio é:

Dado um quadradinho de partida e um de chegada, achar o menor número de passos para ir de um até o outro.

Se não der para chegar, falamos: "não tem caminho".

Passos de pato:

Comece do ponto inicial.

Tente ir para todos os lados (mas só onde for livre, sem bater na parede e sem sair do tabuleiro).

Conte quantos passos você andou.

Continue andando até achar o destino.

Assim que achar, o número de passos que gastamos é o menor caminho (porque usamos BFS — que anda nível por nível).

*/
public int menorDistancia(int[][] labirinto, int inicioLinha, int inicioColuna, int fimColuna, int fimLinha){
    int n = labirinto.length;
    int m = labirinto[0].length;

    boolean[][] visitado = new boolean[n][m];
    Queue<Ponto> fila = new LinkedList<>();
    fila.add(new Ponto(inicioLinha, inicioColuna, 0));
    visitado[inicioLinha][inicioColuna] = true;

    int[] dLinha  = {-1, 1, 0, 0}; // cima, baixo
    int[] dColuna = {0, 0, -1, 1}; // esquerda, direita

    while (!fila.isEmpty()){
        Ponto atual = fila.poll();

        if(atual.linha == fimLinha && atual.coluna == fimColuna){
            return atual.passos;
        }

        for (int i = 0; i < 4; i++){
            int novaLinha  = atual.linha + dLinha[i];
            int novaColuna = atual.coluna + dColuna[i];

            if (novaLinha >= 0 && novaLinha < n && novaColuna >= 0 && novaColuna < m){
                if (!visitado[novaLinha][novaColuna] && labirinto[novaLinha][novaColuna] == 0){
                    visitado[novaLinha][novaColuna] = true;
                    fila.add(new Ponto(novaLinha, novaColuna, atual.passos + 1));
                }
            }
        }
    }

    return - 1; // não tem caminho
}

/*
0 1 0 0 0
0 1 0 1 0
0 0 0 1 0
0 1 1 1 0
0 0 0 0 0


Queremos sair do canto superior esquerdo (0,0) até o canto inferior direito (4,4).

Resposta: 12 passos.
*/

/*

            Exercício 5: "Espalhamento de informação"

Descrição: Dado um grafo e um nó inicial, cada pessoa avisa os seus amigos em 1 minuto.
Quanto tempo leva para todo mundo saber da notícia?



                Imagine, Pato:

Temos um grupo de patos (pessoas), cada um é uma bolinha.

Cada linha entre eles indica que um pode falar com outro (amizade).

Quando um pato descobre uma notícia, ele avisa seus amigos.

Cada 1 minuto, um pato consegue avisar todos os seus amigos.

Cada amigo, no minuto seguinte, avisa os amigos dele, e assim por diante.

O objetivo é:

Quanto tempo leva para todo mundo saber da notícia?

Passos de pato:

Começamos pelo pato que sabe da notícia (nó inicial).

No primeiro minuto, avisamos todos os amigos diretos.

No segundo minuto, esses amigos avisam os amigos deles que ainda não sabem.

E assim vai.

Quando todo mundo estiver avisado, paramos e contamos quantos minutos passaram.

Se ficar algum pato que não consegue ser avisado (porque ele está isolado), dizemos que não dá.

*/
public int tempoParaEspalhar(Map<Integer,List<Integer>> grafo, int idInicial){
    Set<Integer> avisados = new HashSet<>();
    Queue<Integer> fila = new LinkedList<>();

    fila.add(idInicial);
    avisados.add(idInicial);

    int minutos = 0;

    while (!fila.isEmpty()) {
        int tamanhoNivel = fila.size();
        boolean espalhouNesteMinuto = false;

        for (int i = 0; i < tamanhoNivel; i++) {
            int atual = fila.poll();
            for (Integer amigo : grafo.getOrDefault(atual, new ArrayList<>())) {
                if (!avisados.contains(amigo)) {
                    fila.add(amigo);
                    avisados.add(amigo);
                    espalhouNesteMinuto = true;
                }
            }
        }

        if (espalhouNesteMinuto) {
            minutos++;
        }
    }

    // Verifica se alguém ficou de fora
    if (avisados.size() < grafo.size()) {
        return -1; // Nem todo mundo recebeu a notícia
    }

    return minutos;
}

/*
1 -> 2, 3
2 -> 1, 4
3 -> 1
4 -> 2, 5
5 -> 4

No minuto 0: Só o 1 sabe.

No minuto 1: 2 e 3 ficam sabendo.

No minuto 2: 4 fica sabendo.

No minuto 3: 5 fica sabendo.

Resposta final: 3 minutos.
 */



/*
            Exercício 6: "Conversão de palavras (Word Ladder)"

Descrição: Transforme uma palavra em outra, trocando uma letra por vez, mas cada
nova palavra precisa existir num dicionário. Use BFS para encontrar o menor número de passos.

Exemplo: hit → hot → dot → dog → cog


        Imagine assim, Pato:

Você tem uma palavra inicial (tipo "hit")

Quer chegar numa palavra final (tipo "cog")

Pode mudar uma letra por vez (ex: "hit" → "hot" é válido)

Mas: só pode usar palavras reais, que estejam num dicionário (uma lista).

O objetivo é:
    Descobrir qual é o menor número de passos para transformar a palavra inicial na final,
    trocando uma letra por vez e só usando palavras do dicionário.


                🧠 Como funciona (passos de pato):
Cada palavra é como um nó num grafo.

Se você pode transformar uma palavra em outra (trocando só uma letra), então elas estão conectadas.
Começamos da palavra inicial.

A cada passo, tentamos mudar uma letra de cada posição da palavra, e vemos se a nova palavra está no dicionário.
Usamos BFS (busca em largura) para explorar todas as possibilidades e achar o caminho mais curto até chegar na palavra final.
*/
public int ladderLength(String inicio, String fim, List<String> dicionario){
    Set<String> wordSet = new HashSet<>(dicionario);

    if(!wordSet.contains(fim)){
        return 0;
    }

    Queue<String> fila = new LinkedList<>();
    fila.add(inicio);

    Set<String> visitado = new HashSet<>();
    visitado.add(inicio);

    int passos = 1;

    while(!fila.isEmpty()){
        int tamanhoNivel = fila.size();

        for (int i = 0; i < tamanhoNivel; i++) {
            String palavraAtual = fila.poll();
            if(palavraAtual.equals(fim)){
                return passos;
            }

            for (String vizinha : gerarVizinhancas(palavraAtual)){
                if (wordSet.contains(vizinha) && !visitado.contains(vizinha)){
                    fila.add(vizinha);
                    visitado.add(vizinha);
                }
            }
        }
        passos++;
    }

    return 0; // Não há caminho
}
private List<String> gerarVizinhancas(String palavra){
    List<String> vizinhas = new ArrayList<>();
    char[] letras = palavra.toCharArray();

    for (int i = 0; i < letras.length; i++) {
        char original = letras[i];
        for (char c = 'a'; c <= 'z'; c++){
            if (c == original){
                continue;
            }
            letras[i] = c;
            vizinhas.add(new String(letras));
        }
        letras[i] = original;
    }

    return vizinhas;
}

/*
            📋 Resultado:
Transformar "hit" em "cog" com o dicionário:
"hot", "dot", "dog", "lot", "log", "cog"

Caminho mais curto:

hit → hot → dot → dog → cog

🧮 4 passos entre palavras, mas como contamos o hit também:
Resposta: 5 passos (incluindo o início e o fim)
 */



/*
            Exercício 7: "Transformação de número"

Descrição: Você pode transformar um número x em y com as operações: x*2, x+1.
Encontre o número mínimo de operações para chegar em y a partir de x.


Imagine, Pato:

Você tem um número x.

Quer transformar ele em um número y.

Pode fazer duas coisas:

Multiplicar por 2 → x * 2

Somar 1 → x + 1

O objetivo é:

Descobrir qual é o menor número de operações para transformar x em y.

🧠 Como funciona (passos de pato):
Cada número é como um nó.

De cada número, você pode ir para:

Ele * 2

Ele + 1

Fazemos uma busca em largura (BFS) a partir de x.

A cada passo, testamos as duas operações e vemos se chegamos em y.

Assim que alcançarmos y, retornamos o número de passos feitos.
*/
public int transformarNumero(int x, int y){
    Queue<int[]> fila = new LinkedList<>();
    Set<Integer> visitado = new HashSet<>();

    fila.add(new int[]{x, 0});
    visitado.add(x);

    while(!fila.isEmpty()){
        int[] atual = fila.poll();
        int numero = atual[0];
        int passos = atual[1];

        if(numero == y){
            return passos;
        }

        // Operações possíveis
        int[] proximos = {numero * 2, numero + 1};

        for (int prox : proximos){
            if(!visitado.contains(prox) && prox <= y * 2){
                fila.add(new int[]{prox, passos + 1});
                visitado.add(prox);
            }
        }
    }

    return - 1; // Não deve acontecer
}

/*
            📋 Exemplo: x = 3, y = 11
Caminho possível:

3 → 6 → 7 → 8 → 9 → 10 → 11 (6 passos)

Melhor caminho: 3 → 4 → 5 → 10 → 11 (4 passos)

O algoritmo encontra o caminho mais curto automaticamente com BFS.
 */



/*
            Exercício 8: "Zumbis invadindo a cidade"

Descrição: Matriz com 1 para zumbis e 0 para humanos. A cada minuto,
zumbis infectam humanos ao lado (vertical e horizontal).
Descubra quantos minutos até todos virarem zumbis (ou retorne -1 se alguém nunca for infectado).


            Imagine, Pato:

Você tem uma matriz (como um tabuleiro) cheia de:

1 = zumbis 🧟

0 = humanos 😨

A cada minuto, qualquer zumbi consegue transformar os humanos ao lado dele (cima, baixo, esquerda, direita) em zumbis.

Zumbis não andam na diagonal!

O objetivo é:

Descobrir quantos minutos vai levar para todos os humanos virarem zumbis.
Se sobrar algum humano que nunca pode ser infectado, retornamos -1.


            🧠 Como funciona (passos de pato):
Começamos com todos os zumbis na fila (como fontes de infecção).

A cada minuto:

Cada zumbi infecta os humanos vizinhos.

Esses novos zumbis entram na fila para infectar no próximo minuto.

Contamos quantos minutos se passaram.

No final, verificamos se ainda sobrou algum 0 na matriz.

*/
public int minutosParaInfeccaoTotal(int[][] cidade){
    int linhas = cidade.length;
    int colunas = cidade[0].length;

    Queue<int[]> fila = new LinkedList<>();
    int humanos = 0;

    // Passo 1: localizar zumbis e contar humanos
    for (int i = 0; i < linhas; i++) {
        for (int j = 0; j < colunas; j++) {
            if (cidade[i][j] == 1){
                fila.add(new int[]{i, j});
            }
            else if(cidade[i][j] == 0){
                humanos++;
            }
        }
    }

    if (humanos == 0){
        return 0;
    }

    int minutos = 0;
    int[][] direcoes = {{0,1}, {1, 0}, {0,-1}, {-1, 0}}; // direita, baixo, esquerda, cima

    while (!fila.isEmpty()){
        int tamanho = fila.size();
        boolean infectou = false;

        for (int i = 0; i < tamanho; i++) {
            int[] atual = fila.poll();
            int x = atual[0], y = atual[1];

            for (int[] d : direcoes){
                int nx = x + d[0], ny = y + d[1];
                if(nx >= 0 && ny >= 0 && nx < linhas && ny < colunas && cidade[nx][ny] == 0){
                    cidade[nx][ny] = 1;
                    fila.add(new int[]{nx, ny});
                    humanos--;
                    infectou = true;
                }
            }
        }

        if (infectou)
            minutos++;
    }

    return humanos == 0 ? minutos : - 1;
}
/*
📋 Resultado para o exemplo:
Entrada:
0 1 0
0 0 0
1 0 0

Minuto 0: zumbis em (0,1) e (2,0)

Minuto 1: infecta (0,0), (1,1), (2,1)

Minuto 2: infecta (1,0), (1,2), (2,2)

Resposta: 2 minutos
 */

/*
                             Exercício 9: "Cavalo no tabuleiro de xadrez"

Descrição: Dado um tabuleiro n x n e a posição de um cavalo, ache o número mínimo de movimentos para chegar até outra posição.



        Imagine, Pato:

Você tem um tabuleiro n x n.

Um cavalo começa em uma certa posição.

Ele se move em "L": 2 casas numa direção + 1 na perpendicular (como no xadrez!).

Seu objetivo é:

Descobrir o número mínimo de movimentos que o cavalo precisa fazer para chegar até outra posição no tabuleiro.


                    🧠 Como funciona (passos de pato):
Cada casa do tabuleiro é um nó.

O cavalo pode ir para no máximo 8 posições diferentes a partir de qualquer ponto.

A cada movimento, você tenta todos os pulos possíveis.

Usamos BFS (busca em largura) para garantir que achamos o caminho mais curto.

*/
int[][] movimentos = {
        {2, 1}, {1, 2}, {-1, 2}, {-2, 1},
        {-2, -1}, {-1, -2}, {1, -2}, {2, -1}
};
public int minMovimentos(int n, int[] inicio, int[] fim){
    boolean[][] visitado = new boolean[n][n];
    Queue<int[]> fila = new LinkedList<>();
    fila.add(new int[]{inicio[0], inicio[1], 0});
    visitado[inicio[0]][inicio[1]] = true;

    while (!fila.isEmpty()) {
        int[] atual = fila.poll();
        int x = atual[0], y = atual[1], passos = atual[2];

        if (x == fim[0] && y == fim[1]) {
            return passos;
        }

        for (int[] mov : movimentos) {
            int nx = x + mov[0];
            int ny = y + mov[1];

            if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visitado[nx][ny]) {
                fila.add(new int[]{nx, ny, passos + 1});
                visitado[nx][ny] = true;
            }
        }
    }

    return -1; // Se for impossível (mas não deveria num tabuleiro padrão)
}
/*
📋 Exemplo:
Tabuleiro 8x8
De (0, 0) até (7, 7)

➡️ A resposta é: 6 movimentos
 */


/*
                             Exercício 10: "Verificando se o grafo é bipartido"

Descrição: Use BFS para tentar colorir os vértices com 2 cores. Se conseguir sem dois vizinhos com a mesma cor, então o grafo é bipartido.


                Pensa comigo, Pato:

Você tem um grafo com vértices conectados por arestas.

Você quer saber se é possível pintar os vértices com duas cores apenas (por exemplo, vermelho e azul).

Mas tem uma regrinha:

Nenhum vizinho pode ter a mesma cor!

Se der pra fazer isso com todo o grafo, ele é bipartido. Caso contrário, não é.


            🧠 Como funciona (passos de pato):
Pegamos qualquer vértice e pintamos com a cor 0.

Usamos BFS:

Cada vez que visitamos um vizinho, pintamos ele com a cor oposta.

Se encontramos alguém já pintado com a mesma cor que o atual, então o grafo não é bipartido.

Precisamos repetir isso para todos os componentes do grafo (em caso de grafos desconexos).


*/
public boolean ehBipartido(List<List<Integer>> grafo){
    int n = grafo.size();
    int[] cor = new int[n];
    Arrays.fill(cor, -1); // -1 = sem cor

    for (int i = 0; i < n; i++) {
        if (cor[i] == -1) {
            if (!bfs(grafo, i, cor)) {
                return false;
            }
        }
    }

    return true;
}
private boolean bfs(List<List<Integer>> grafo, int inicio, int[] cor){
    Queue<Integer> fila = new LinkedList<>();
    fila.add(inicio);
    cor[inicio] = 0;

    while (!fila.isEmpty()) {
        int atual = fila.poll();

        for (int vizinho : grafo.get(atual)) {
            if (cor[vizinho] == -1) {
                cor[vizinho] = 1 - cor[atual]; // Pinta com a cor oposta
                fila.add(vizinho);
            } else if (cor[vizinho] == cor[atual]) {
                return false; // Vizinho tem a mesma cor? Falhou!
            }
        }
    }

    return true;
}
/*
📋 Exemplo:
Grafo:
0 -- 1
|    |
3 -- 2


Pode pintar:
0 e 2 com vermelho
1 e 3 com azul ✅
Resposta: bipartido
 */

}
