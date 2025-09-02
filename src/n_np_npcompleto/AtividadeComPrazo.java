package n_np_npcompleto;

public class AtividadeComPrazo {
    public String nome;
    public int lucro;
    public int prazo;

    public AtividadeComPrazo(String nome, int lucro, int prazo){
        this.nome  = nome;
        this.lucro = lucro;
        this.prazo = prazo;
    }

    @Override
    public String toString(){
        return "Atividade '" + nome + "' (lucro: " + lucro + ", Prazo" + prazo + ")";
    }
}
