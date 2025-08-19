import n_np_npcompleto.Atividade;
import n_np_npcompleto.EstrategiaGulosa;
import n_np_npcompleto.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main_N_Np_NpCompleto {
    public static void main(String[] args) {
        // Define o valor do troco.
        double valorDoTroco = 3.75;

        // Cria uma instância da nossa calculadora de troco.
        var calculadora = new EstrategiaGulosa();

        // Chama o método para calcular o troco.
        Map<Double, Integer> trocoCalculado = calculadora.calcularTroco(valorDoTroco);

        // Imprime o resultado para usuário.
        //System.out.println("O troco para R$" + String.format("%.2f", valorDoTroco));

        // Intera sobre o mapa para exibir as notas e moedas.
        // O método forEach do mapa itera sobre os dados do mapa.
        // Ele cria duas variáveis LOCAIS para cada iteração: 'nota' (a chave)
        // e 'quantidade' (o valor). Elas não têm nada a ver com as variáveis
        // da classe CalculadoraDeTroco.
        /*trocoCalculado.forEach((nota, quantidade) ->
                        System.out.println(quantidade + " x R$" + String.format("%.2f", nota))
        );*/


        // Cria a lista de itens.
        List<Item> itens = new ArrayList<>();
        itens.add(new Item(10, 60)); // Item de 10kg com valor 60
        itens.add(new Item(20, 100)); // Item de 20kg com valor 100
        itens.add(new Item(30, 120)); // Item de 30kg com valor 120

        // Define a capacidade da mochila.
        int capacidadeMochila = 50;

        // Cria uma instância da nossa calculadora de mochila.
        EstrategiaGulosa mochila = new EstrategiaGulosa();

        // Resolve o problema e obtém o valor máximo.
        double valorMaximo = mochila.resolverMochila(itens, capacidadeMochila);

        // Imprime o resultado final.
        //System.out.println("\nO valor total máximo que pode ser obtido é: " + valorMaximo);

        // Cria a lista de atividades com seus horários de início e término.
        List<Atividade> atividades = new ArrayList<>();
        atividades.add(new Atividade("A1", 10, 11)); // termina cedo
        atividades.add(new Atividade("A2", 9, 12));
        atividades.add(new Atividade("A3", 11, 13)); // pode ser agendada logo depois de A1
        atividades.add(new Atividade("A4", 14, 15)); // pode ser agendada depois
        atividades.add(new Atividade("A5", 13, 16)); // também pode

        // Cria uma instância do gerenciador.
        var gerenciador = new EstrategiaGulosa();

        // Resolve o problema e obtém a lista de atividades selecionadas.
        List<Atividade> cronograma = gerenciador.selecionarAtividades(atividades);

        // Imprime o resultado final.
        System.out.println("O cronograma ideal de atividades é:");
        for (Atividade atividade : cronograma) {
            System.out.println(atividade);
        }

    }
}
