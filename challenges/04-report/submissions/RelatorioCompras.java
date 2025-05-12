import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class RelatorioCompras {
    public static void main(String[] args) {
        if (args.length != 2) return;

        Path entrada = Path.of(args[0]);
        Path saida = Path.of(args[1]);

        ArrayList<String> clientes = new ArrayList<>();
        ArrayList<Double> totais = new ArrayList<>();

        try {
            for (String linha : Files.readAllLines(entrada)) {
                String[] partes = linha.split(",");
                if (partes.length < 3) continue;

                String nome = partes[0].trim();
                double valor;

                try {
                    valor = Double.parseDouble(partes[2].trim());
                } catch (NumberFormatException e) {
                    continue;
                }

                int i = clientes.indexOf(nome);
                if (i >= 0) {
                    totais.set(i, totais.get(i) + valor);
                } else {
                    clientes.add(nome);
                    totais.add(valor);
                }
            }

            List<String> resultado = new ArrayList<>();
            for (int i = 0; i < clientes.size(); i++) {
                resultado.add(clientes.get(i) + ": " + totais.get(i));
            }

            Files.write(saida, resultado);
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
