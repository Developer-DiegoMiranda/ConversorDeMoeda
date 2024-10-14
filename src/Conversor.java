import java.util.Map;

public class Conversor {

    // Método responsável por realizar a conversão com base nas taxas obtidas
    public void realizarConversao(int opcao, double valor, Map<String, Double> taxasCambio) {
        double resultado = 0;
        String moedaOrigem = "";
        String moedaDestino = "";

        switch (opcao) {
            case 1:
                moedaOrigem = "USD";
                moedaDestino = "ARS";
                resultado = valor * taxasCambio.get(moedaDestino);
                break;
            case 2:
                moedaOrigem = "ARS";
                moedaDestino = "USD";
                resultado = valor / taxasCambio.get(moedaOrigem);
                break;
            case 3:
                moedaOrigem = "USD";
                moedaDestino = "BRL";
                resultado = valor * taxasCambio.get(moedaDestino);
                break;
            case 4:
                moedaOrigem = "BRL";
                moedaDestino = "USD";
                resultado = valor / taxasCambio.get(moedaOrigem);
                break;
            case 5:
                moedaOrigem = "USD";
                moedaDestino = "COP";
                resultado = valor * taxasCambio.get(moedaDestino);
                break;
            case 6:
                moedaOrigem = "COP";
                moedaDestino = "USD";
                resultado = valor / taxasCambio.get(moedaOrigem);
                break;
        }

        // Exibe o resultado da conversão
        System.out.printf("%.2f %s = %.2f %s\n\n", valor, moedaOrigem, resultado, moedaDestino);
    }
}
