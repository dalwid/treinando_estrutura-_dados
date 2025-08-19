package n_np_npcompleto;

public class Item {
    public int peso;
    public int valor;
    public double relacaoValorPeso;

    public Item(int peso, int valor){
        this.peso  = peso;
        this.valor = valor;
        // Calcular a relação valor no construtor
        this.relacaoValorPeso = (double) valor / peso;
    }

    public Item(){}
}
