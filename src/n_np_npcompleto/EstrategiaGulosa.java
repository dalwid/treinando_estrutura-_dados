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

Espero que estas descrições matemáticas ajudem você a se preparar ainda mais. Se precisar de mais detalhes sobre algum deles, é só me dizer.
* */