import java.io.*;
import java.util.Arrays;

public class Exercicios {
    private int teste1[] = new int [10];
    private int teste2[] = new int [10];

    private BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

    private float x;
    private int min;

    public void Teste(){
        try {
            for (int i = 0; i < 10; i++){
                System.out.println("Qual o número?");
                teste1[i] = Integer.parseInt(entrada.readLine());
            }

            for (int i = 0; i < 10; i++){
                if(i % 2 == 0) teste2[i] = teste1[i] * 5; else teste2[i] = teste1[i] + 5;
            }
            System.out.println();

            System.out.println("Resultado: ");
            for (int i = 0; i < 10; i++){
                System.out.println("teste1["+ i + "] = "+ teste1[i] + "\t");
                System.out.println("teste2["+ i + "] = "+ teste2[i]);
            }

        }catch (Exception e){
            System.out.println("Ocorreu um erro durante a leitura!");
        }
    }

    public void ordenando(float[] temperaturas){
        for (int i = 0; i < temperaturas.length - 1; i++){
            min = i;
            for(int j = i +1; j < temperaturas.length; j++){
                if(temperaturas[j] < temperaturas[min]){
                    min = j;
                    x = temperaturas[min];
                    temperaturas[min] = temperaturas[i];
                    temperaturas[i] = x;
                }
            }
        }
    }
}
