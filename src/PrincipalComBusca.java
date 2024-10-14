import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
public class PrincipalComBusca {

    private static final String API_URL = "https://v6.exchangerate-api.com/v6/a5c8a707c2b197a29cc627c5/latest/USD";
    private static Map<String, Double> taxasCambio;

    public static void main(String[] args) throws IOException, InterruptedException {
        // Inicializa as taxas de câmbio
        taxasCambio = buscarTaxasCambio();

        if (taxasCambio == null || taxasCambio.isEmpty()) {
            System.out.println("Erro ao obter taxas de câmbio. Verifique sua conexão ou a API.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        int opcao;
        Conversor conversor = new Conversor();  // Instância da classe Conversor

        do {
            // Exibe o menu
            System.out.println("Menu de Conversão:");
            System.out.println("1) Dólar => Peso Argentino");
            System.out.println("2) Peso Argentino => Dólar");
            System.out.println("3) Dólar => Real brasileiro");
            System.out.println("4) Real brasileiro => Dólar");
            System.out.println("5) Dólar => Peso colombiano");
            System.out.println("6) Peso colombiano => Dólar");
            System.out.println("7) Sair");
            System.out.print("Escolha uma opção válida: ");

            opcao = scanner.nextInt();

            if (opcao >= 1 && opcao <= 6) {
                System.out.print("Digite o valor para conversão: ");
                double valor = scanner.nextDouble();
                // Chamada do método na classe Conversor
                conversor.realizarConversao(opcao, valor, taxasCambio);
            } else if (opcao != 7) {
                System.out.println("Opção inválida. Tente novamente.\n");
            }
        } while (opcao != 7);

        System.out.println("Programa encerrado.");
        scanner.close();
    }

    // Método para buscar as taxas de câmbio da API
    private static Map<String, Double> buscarTaxasCambio() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Usa Gson para fazer o parse da resposta JSON
        JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
        JsonObject rates = jsonObject.getAsJsonObject("conversion_rates");

        // Armazena as taxas de câmbio em um mapa
        Map<String, Double> taxas = new HashMap<>();
        taxas.put("ARS", rates.get("ARS").getAsDouble());
        taxas.put("BRL", rates.get("BRL").getAsDouble());
        taxas.put("COP", rates.get("COP").getAsDouble());
        taxas.put("USD", rates.get("USD").getAsDouble());

        return taxas;
    }
}
