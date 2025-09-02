package n_np_npcompleto;

import java.util.*;

public class EstrategiaGulosa {
    // Define as notas e moedas disponíveis, do maior para o menor.
    // É uma boa prática tornar essa lista final para que não possa ser alterada.
    private static final double[] NOTAS_E_MOEDAS = {
            100.0, 50.0, 20.0, 10.0, 5.0, 2.0, 1.0,
            0.50, 0.25, 0.10, 0.05, 0.01
    };

    /**
     * Calcula o troco de um valor usando o menor número de notas e moedas.
     * @param valor O valor do troco a ser calculado.
     * @return Um mapa com o valor de cada nota/moeda e a quantidade usada.
     */
    public Map<Double, Integer> calcularTroco(double valor) {
        // Usa um mapa para armazenar o resultado.
        Map<Double, Integer> resultado = new HashMap<>();

        // Loop principal para iterar sobre as notas e moedas.
        for (double nota : NOTAS_E_MOEDAS) {
            // Calcula quantas vezes a nota/moeda cabe no valor restante.
            int quantidade = (int) Math.floor(valor / nota);

            // Se a quantidade for maior que zero, adiciona ao resultado.
            if (quantidade > 0) {
                resultado.put(nota, quantidade);
                // Subtrai o valor total das notas/moedas usadas.
                valor -= quantidade * nota;
            }

            // Arredonda para evitar problemas de precisão com ponto flutuante.
            valor = Math.round(valor * 100.0) / 100.0;
        }

        return resultado;
    }

    /**
     * Resolve o problema da mochila fracionária usando a estratégia gulosa.
     * @param itens Uma lista de itens disponíveis.
     * @param capacidade A capacidade máxima da mochila.
     * @return O valor máximo que pode ser colocado na mochila.
     */
    public double resolverMochila(List<Item> itens, int capacidade) {
        // 1. Classifica os itens pela relação valor/peso, do maior para o menor.
        //itens.sort(Comparator.comparingDouble(item -> item.relacaoValorPeso).reversed());

        double valorTotal = 0.0;
        int pesoAtual = 0;

        // 2. Itera sobre os itens já ordenados.
        for (Item item : itens) {
            // Se o item inteiro couber na mochila
            if (pesoAtual + item.peso <= capacidade) {
                pesoAtual += item.peso;
                valorTotal += item.valor;
                System.out.println("Item " + item + " adicionado por completo. Peso atual: " + pesoAtual);
            } else {
                // Se o item não couber por completo, adiciona uma fração dele.
                int pesoRestante = capacidade - pesoAtual;
                double fracao = (double) pesoRestante / item.peso;
                valorTotal += item.valor * fracao;
                pesoAtual += pesoRestante;
                System.out.println("Item " + item + " adicionado em fração. Peso atual: " + pesoAtual);

                // A mochila está cheia, podemos parar o processo.
                break;
            }
        }

        return valorTotal;
    }

    /**
     * Resolve o problema de seleção de atividades para uma sala de aula.
     * @param atividades A lista de atividades disponíveis.
     * @return Uma lista com as atividades selecionadas.
     */
    public List<Atividade> selecionarAtividades(List<Atividade> atividades){
        // 1. Classifica as atividades com base no horário de témino (crescente).
        // Graças ao método compareTo na classe Atividade, o Collection.sort funciona
        Collections.sort(atividades);

        List<Atividade> cronogramaFinal = new ArrayList<>();

        // Aprimeira atividade a ser agendada é a que termina mais cedo.
        cronogramaFinal.add(atividades.get(0));
        int ultimoFim = atividades.get(0).fim;

        // 2. Intera sobre o restante das atividades.
        for (int i = 1; i < atividades.size(); i++){
            Atividade proximaAtividade = atividades.get(i);

            // 3. Se a atividade puder ser agendada (se ela começar
            // depois ou exatamente quando a anterior terminou).
            if (proximaAtividade.inicio >= ultimoFim){
                cronogramaFinal.add(proximaAtividade);
                ultimoFim = proximaAtividade.fim;
            }
        }

        return cronogramaFinal;
    }

    public int problemaAtividadePrazo(List<AtividadeComPrazo> atividades){
        // 1. Classifica as atividades em ordem decrescente de lucro.
        atividades.sort(Comparator.comparingInt(a -> a.lucro));

        // Encontra o maior prazo para definir o tamanho do cronograma.
        int maiorPrazo = 0;
        for (AtividadeComPrazo a : atividades) {
            if (a.prazo > maiorPrazo) {
                maiorPrazo = a.prazo;
            }
        }

        // 2. Inicializa os slots do cronograma.
        String[] cronogramaSlots = new String[maiorPrazo + 1];
        int lucroTotal = 0;

        // 3. Itera sobre as atividades ordenadas e agenda-as.
        for (AtividadeComPrazo atividade : atividades) {
            // Itera de trás para frente, do prazo da atividade até 1.
            for (int i = atividade.prazo; i >= 1; i--) {
                if (cronogramaSlots[i] == null) {
                    cronogramaSlots[i] = atividade.nome;
                    lucroTotal += atividade.lucro;
                    break; // Sai do laço interno após agendar.
                }
            }
        }

        System.out.println("Cronograma final:");
        for (int i = 1; i < cronogramaSlots.length; i++) {
            System.out.println("Slot " + i + ": " + (cronogramaSlots[i] != null ? cronogramaSlots[i] : "Vazio"));
        }

        return lucroTotal;
    }

    public List<Set<String>> coberturaDeConjuntosGuloso(Set<String> universo, List<Set<String>> subconjuntos){
        Set<String> elementosNaoCobertos = new HashSet<>(universo);
        List<Set<String>> coberturaFinal = new ArrayList<>();

        while (!elementosNaoCobertos.isEmpty()) {
            Set<String> melhorSubconjunto = null;
            int elementosNovosCobertos = 0;

            for (Set<String> subconjunto : subconjuntos) {
                // Encontra a interseção para saber quantos novos elementos este subconjunto cobriria
                Set<String> intersecao = new HashSet<>(subconjunto);
                intersecao.retainAll(elementosNaoCobertos);

                if (intersecao.size() > elementosNovosCobertos) {
                    elementosNovosCobertos = intersecao.size();
                    melhorSubconjunto = subconjunto;
                }
            }

            if (melhorSubconjunto == null) {
                // Se não há mais subconjuntos que cubram elementos restantes
                break;
            }

            coberturaFinal.add(melhorSubconjunto);
            elementosNaoCobertos.removeAll(melhorSubconjunto);
        }

        return coberturaFinal;
    }
}
/*
*
1. O Problema do Troco

A estratégia gulosa para o problema do troco (usando o menor número de moedas) funciona com um princípio simples,
mas poderoso. Embora não haja uma "fórmula" única no sentido tradicional (como E=mc2), o algoritmo pode ser descrito matematicamente.

    Problema: Dado um conjunto de moedas C={c1​,c2​,...,cn​} e um valor de troco V,
     encontre um conjunto de moedas M={m1​,m2​,...,mk​} tal que a soma de seus valores seja igual
     a V e o número de moedas ∣M∣ seja o menor possível.

    Condição para o Algoritmo Guloso:
      O algoritmo guloso só garante a solução ótima se o conjunto de moedas for canônico.
      Um sistema de moedas é canônico se o algoritmo guloso sempre produzir a solução com o menor número
      de moedas para qualquer valor de troco. A maioria das moedas em circulação (Real, Dólar, Euro) formam um sistema canônico.

    Fórmula (Descrição Matemática do Algoritmo):
        Ordem: Moedas devem estar em ordem decrescente de valor: c1​>c2​>...>cn​.
        Laço (iteração): Para cada moeda ci​ da maior para a menor:
        Cálculo da Quantidade: A quantidade de moedas ci​ a ser usada é qi​=⌊ci​Vrestante​​⌋.
        Atualização: O valor restante a ser pago se torna Vrestante​=Vrestante​−qi​×ci​.

A solução final é o conjunto de pares (qi​,ci​) para todas as moedas.

2. O Problema da Mochila (Fracionária)

Este problema tem uma base matemática clara, focada na maximização do valor.

    Problema: Dado um conjunto de itens I={i1​,i2​,...,in​}, onde cada item ij​ tem um peso pj​ e um valor vj​,
    e uma mochila com capacidade máxima W. Encontre uma quantidade de cada item xj​ (onde 0≤xj​≤1) para maximizar
    o valor total ∑j=1n​xj​vj​ sob a restrição de peso ∑j=1n​xj​pj​≤W.

    Fórmula (Descrição Matemática do Algoritmo):
        Cálculo da Eficiência: Para cada item ij​, calcule a relação valor/peso: rj​=pj​vj​​.
        Ordem: Ordene os itens em ordem decrescente de eficiência: r1​≥r2​≥...≥rn​.

        Seleção (Laço): Para cada item ij​ já ordenado:
            Se o peso do item pj​ for menor ou igual à capacidade restante Wrestante​, selecione o item inteiro:
               xj​=1. O valor total é aumentado em vj​ e a capacidade restante é Wrestante​=Wrestante​−pj​.
            Senão (se o item não couber inteiro), selecione uma fração do item: xj​=pj​Wrestante​​.
              O valor total é aumentado em xj​×vj​ e a capacidade restante se torna 0.

O algoritmo termina quando a mochila está cheia.

3. O Problema do Cronograma da Sala de Aula

Este problema de seleção de atividades é resolvido com uma prova por troca, que demonstra a otimalidade do algoritmo guloso.

    Problema: Dado um conjunto de atividades A={a1​,a2​,...,an​},
     onde cada atividade ai​ tem um horário de início si​ e um horário de término fi​.
      Encontre um subconjunto de atividades S⊆A onde nenhuma atividade se sobrepõe, e o número de atividades ∣S∣ é maximizado.

    Condição para o Algoritmo Guloso:
     A estratégia gulosa funciona se as atividades forem mutuamente compatíveis (não se sobrepõem) e o objetivo for maximizar o número de atividades.

    Fórmula (Descrição Matemática do Algoritmo):

        Ordem: Ordene as atividades em ordem crescente de horário de término: f1​≤f2​≤...≤fn​.

        Seleção (Laço):

            Selecione a primeira atividade a1​ da lista ordenada.

            Para cada atividade subsequente ai​ (começando de a2​):

            Se o horário de início da atividade atual si​ for maior ou igual ao horário de término da última atividade selecionada fuˊltima​:

            Selecione a atividade ai​.

O algoritmo continua até que todas as atividades tenham sido analisadas.
Entender a lógica gulosa, saber quando ela é aplicável (nem sempre ela gera a solução ótima, como na versão "0/1" do problema da mochila)
e conhecer a prova de otimalidade por trás dela são pontos-chave para se destacar.


*
o Problema da Atividade com Prazos é um excelente desafio para aprimorar o pensamento guloso.
A grande sacada aqui é que o critério de escolha muda. Em vez de simplesmente pegar a atividade que termina mais cedo,
a melhor estratégia é focar nas atividades que "vencem" primeiro.

A lógica é a seguinte: se uma atividade tem um prazo muito apertado, é melhor tentar agendá-la primeiro para garantir que você não perca o lucro.
*
O Problema da Atividade com Prazos (Formulação Matemática)

    Problema: Dado um conjunto de atividades A={a1​,a2​,...,an​}.
    Cada atividade ai​ tem um lucro Li​ e um prazo Pi​.
    O objetivo é selecionar um subconjunto de atividades S⊆A para agendar em slots de tempo discretos,
    começando do slot 1, de modo que cada atividade selecionada ai​∈S seja concluída no máximo no slot Pi​,
    e o lucro total ∑ai​∈S​Li​ seja maximizado. A restrição é que apenas uma atividade pode ser agendada por slot.

O Algoritmo Guloso e Sua Justificativa Matemática

A estratégia gulosa para este problema se baseia em uma observação fundamental: para maximizar o lucro,
devemos sempre priorizar as atividades mais lucrativas. O desafio é que uma atividade de alto lucro pode ter um prazo apertado,
competindo por um slot de tempo com outras atividades.

A chave para o algoritmo é o critério de seleção e a regra de agendamento.

    Critério Guloso: Selecione as atividades em ordem decrescente de lucro.

    Regra de Agendamento: Tente agendar a atividade no último slot disponível antes ou no seu prazo.

A formalização matemática desse processo é a seguinte:

    Ordenação: Ordene as atividades A em uma nova lista A′ de forma que para todas as atividades ai​,aj​∈A′, se i<j, então Li​≥Lj​.

    Agendamento: Crie uma matriz (ou array) de slots de tempo S de tamanho igual ao maior prazo entre todas as atividades.
    Inicialize todos os slots como "vazio".

    Laço de Seleção: Para cada atividade ai​ na lista ordenada A′:

        Itere através dos slots de tempo de trás para frente, do slot Pi​ até o slot 1.

        Encontre o primeiro slot sk​ que está "vazio" (S[k]=vazio).

        Se um slot vazio for encontrado, agende a atividade ai​ neste slot (S[k]=ai​) e pare a busca por slots para esta atividade.

A prova de que esta estratégia gulosa é ótima se baseia na técnica de prova por troca. Se uma solução ótima O contém
uma atividade de menor lucro que está agendada no mesmo slot ou em um slot anterior ao de uma atividade de maior lucro que não foi selecionada,
podemos "trocar" as atividades. A nova solução teria um lucro igual ou maior, mostrando que a solução gulosa é, de fato, a ótima.

Por exemplo, imagine que você tem duas atividades:

    A1​: lucro 10, prazo 2

    A2​: lucro 8, prazo 2

A estratégia gulosa seleciona A1​ primeiro (maior lucro). A agenda no slot 2 (o último slot disponível antes ou no prazo).
Depois, ela considera A2​. O slot 2 está ocupado, então a agenda no slot 1. O lucro total é 18. Se você tivesse agendado A2​ primeiro,
ainda agendaria A1​ no slot 1, e o lucro seria o mesmo. O algoritmo garante a maximização.
*
*
O Problema de Cobertura de Conjuntos (Set Cover Problem)

O Problema de Cobertura de Conjuntos é um dos problemas mais famosos da ciência da computação,
mas aqui está a pegadinha: ele não pode ser resolvido de forma ótima com um algoritmo guloso! No entanto,
a estratégia gulosa oferece uma solução de aproximação muito boa e, em muitos casos, a melhor que podemos conseguir em tempo hável.

A solução gulosa para o Problema de Cobertura de Conjuntos é um exemplo perfeito de como a abordagem
"tomar a melhor decisão no momento" nem sempre leva à resposta exata, mas ainda assim é extremamente útil.

A Lógica do Algoritmo Guloso (Solução de Aproximação)

Imagine o seguinte cenário: você é o líder de uma campanha de marketing e precisa alcançar um conjunto de pessoas.
Você tem várias equipes de influenciadores, e cada equipe (um conjunto) alcança um grupo específico de pessoas (elementos).
Contratar uma equipe custa caro. Seu objetivo é contratar o menor número de equipes para que todas as pessoas que você quer alcançar sejam cobertas.

A estratégia gulosa para resolver isso é a seguinte:

    Encontre a melhor equipe: Em cada passo, selecione a equipe que cobre o maior número de pessoas que ainda não foram alcançadas.

    Repita: Adicione essa equipe à sua lista de equipes contratadas e remova as pessoas que ela alcança do seu conjunto de "não alcançados".

    Continue até que todas as pessoas tenham sido alcançadas.

Essa abordagem não garante a solução ótima (o menor número absoluto de equipes), mas costuma chegar muito perto e é
muito mais rápida de calcular do que a solução exata (que é um problema NP-difícil).

A principal diferença entre este problema e os anteriores é que a estratégia gulosa não é garantidamente ótima,
mas sim uma aproximação eficaz. Por ser um problema de otimização combinatória, encontrar a solução exata é computacionalmente caro.
A abordagem gulosa oferece um excelente trade-off entre performance e qualidade da solução.
*
A Matemática por Trás do Problema de Cobertura de Conjuntos

Você está certo em buscar a formulação matemática, pois é ela que nos ajuda a entender por que o algoritmo guloso para o
Problema de Cobertura de Conjuntos é uma aproximação e não a solução exata.

O problema de Cobertura de Conjuntos é um problema clássico de otimização combinatória e é considerado NP-difícil.
Isso significa que, para a maioria dos casos, não existe um algoritmo que garanta a solução ótima (a menor quantidade de conjuntos)
em um tempo polinomial.

Formulação Matemática

    Universo (U): Um conjunto finito de elementos que precisam ser cobertos. Exemplo: U={1,2,3,...,n}.

    Família de Subconjuntos (F): Uma coleção de subconjuntos de U. Cada subconjunto Si​∈F é um candidato para a nossa solução.
     Exemplo: F={S1​,S2​,...,Sm​}, onde Si​⊆U.

O objetivo é encontrar um subconjunto de F, digamos C⊆F, tal que a união de todos os conjuntos em C seja igual a U, e
o tamanho de C seja o menor possível.

min∣C∣sujeito aSi​∈C⋃​Si​=U

Por que o Algoritmo Guloso é uma Aproximação?

A estratégia gulosa de escolher o conjunto que cobre o maior número de elementos restantes parece intuitiva,
mas um contra-exemplo simples pode mostrar que ela não é ótima.

Exemplo:

    U={1,2,3,4,5,6}

    F={S1​,S2​,S3​}, com:

        S1​={1,2,3}

        S2​={4,5,6}

        S3​={1,2,3,4,5}

Solução Ótima (Exata):
A solução ótima é S1​ e S2​. Juntos, eles cobrem o universo U. O tamanho da solução é 2.

Solução Gulosa:

    O algoritmo guloso olha para os conjuntos e vê quantos elementos únicos cada um pode cobrir.

        S1​ cobre 3 elementos.

        S2​ cobre 3 elementos.

        S3​ cobre 5 elementos.

    O algoritmo guloso escolhe o conjunto que cobre o maior número de elementos: S3​.

    O universo restante é agora U−S3​={6}.

    O algoritmo guloso precisa cobrir o elemento 6. O único conjunto que cobre o 6 é o S2​.

    O algoritmo guloso escolhe S2​.

    A solução gulosa é {S3​,S2​}, com um tamanho de 2.

Neste caso, a solução gulosa coincidiu com a ótima. Agora, vamos alterar um pouco o exemplo para mostrar um cenário em que a solução gulosa falha.

Exemplo 2:

    U={1,2,...,100} (100 elementos)

    F={SA​,SB​,SC​,...,SZ​}

    SA​ cobre 51 elementos do universo (ex: elementos de 1 a 51).

    Os outros subconjuntos, juntos, podem cobrir todos os 100 elementos em um número menor de conjuntos.
    Exemplo: 20 conjuntos de 5 elementos cada, que cobrem os elementos de 1 a 100 sem se sobrepor.

Solução Gulosa:

    O algoritmo guloso escolhe SA​ porque ele sozinho cobre 51 elementos, o maior número inicial.

    Agora, restam 49 elementos a serem cobertos. O algoritmo precisará de mais conjuntos para cobrir esses 49.

    A solução final do algoritmo guloso terá SA​ mais o conjunto de 49 elementos restantes, que pode ser coberto por vários outros conjuntos.

Em contrapartida, a solução ótima pode existir sem a necessidade de SA​. Por exemplo, 20 conjuntos de 5 elementos cada que,
juntos, cobrem todo o universo.

A Razão da Aproximação

O algoritmo guloso para o problema de cobertura de conjuntos é uma heurística, ou seja,
uma abordagem prática que busca uma solução boa,
mesmo que não seja a melhor. Ele se baseia na prova da razão de aproximação,
que mostra que a solução gulosa nunca é mais do que ln(∣U∣)+1 vezes pior que a solução ótima.
Essa é uma garantia matemática de quão "próximo" o algoritmo guloso consegue chegar do ideal.

Em resumo, a matemática por trás do Problema de Cobertura de Conjuntos nos mostra que ele é complexo demais
para um algoritmo guloso encontrar a resposta exata, mas que essa mesma abordagem é a melhor para encontrar
uma solução satisfatória de forma eficiente.

* */