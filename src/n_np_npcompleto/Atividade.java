package n_np_npcompleto;

public class Atividade implements Comparable<Atividade>{
    public String nome;
    public int inicio;
    public int fim;

    public Atividade(String nome, int inicio, int fim){
        this.nome = nome;
        this.inicio = inicio;
        this.fim = fim;
    }

    // Método de comparação para ordenar as atividades pelo horário de término
    @Override
    public int compareTo(Atividade outraAtividade){
        return Integer.compare(this.fim, outraAtividade.fim);
    }

    @Override
    public String toString(){
        return "Atividade '" + nome + "' [Início: " + inicio + ", Fim: " + fim + "]";
    }
}
