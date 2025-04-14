import java.util.HashMap;
import java.util.Map;

public class HashTableII {

    // 7. Criar uma função que converte um array de pares chave-valor em uma tabela hash
    public Map<String, Object> arrayParaHash(String[][] pares){

        Map<String, Object> map = new HashMap<>();
        for(String[] par : pares){
            map.put(par[0], par[1]);
        }

        return map;
    }

    // 9. Criar um cache simples com tabela hash
    public int calcular(String chave, Map<String, Integer> cache, java.util.function.Supplier<Integer> func){
        return cache.computeIfAbsent(chave, k -> func.get());
    }

    // 10. Criar um sistema de contagem de palavras usando tabela hash
    public Map<String, Integer> contarPalavras(String texto){
        Map<String, Integer> contagem = new HashMap<>();
        String[] palavras = texto.toLowerCase().split("\\W+");

        for (String palavra : palavras){
            if(palavra.isBlank()){
                continue;
            }
            contagem.put(palavra, contagem.getOrDefault(palavra, 0) + 1);
        }

        return contagem;
    }

}
