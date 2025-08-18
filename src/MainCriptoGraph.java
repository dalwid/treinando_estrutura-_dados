public class MainCriptoGraph {
    public static void main(String[] args) {
        // 🪙 Câmbio entre exchanges (Binance, Coinbase, Kraken)
        // Índices: 0 = Binance, 1 = Coinbase, 2 = Kraken
        CriptoGraph graph = new CriptoGraph(3);

        // Preços relativos entre exchanges
        graph.addEdge(0, 1, 0.98); // Binance  -> Coinbase (queda de 2%)
        graph.addEdge(1, 2, 1.05); // Coinbase -> Kraken (subiu 5%)
        graph.addEdge(2, 0, 1.10); // Kraken   -> Binance (subiu 10%)

        boolean existeArbitragem = graph.detectaLucroArbitrario(0);

        if (existeArbitragem) {
            System.out.println("🤑 Existe uma oportunidade de lucro com arbitragem!");
        } else {
            System.out.println("😞 Nada de arbitragem agora. Continue observando o mercado.");
        }
    }
}
