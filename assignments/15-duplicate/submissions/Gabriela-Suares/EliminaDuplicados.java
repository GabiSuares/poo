import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class EliminaDuplicados {

    private static String capitalizar(String nome) {
    if (nome == null || nome.isEmpty()) return nome;
    return nome.substring(0, 1).toUpperCase() + nome.substring(1).toLowerCase();
}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<String> nomes = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

System.out.println("=====================================");
System.out.println("  Cadastro de Nomes (sem duplicados)");
System.out.println("=====================================\n");

        System.out.println("Digite os nomes (digite 'fim' para encerrar):");

        while (true) {
System.out.print("> ");
            String entrada = sc.nextLine().trim();
            if (entrada.equalsIgnoreCase("fim")) break;

            if (!entrada.isEmpty()) {
            String nomeFormatado = capitalizar(entrada);
            boolean adicionado = nomes.add(nomeFormatado);

                if (!adicionado) {
System.out.println("⚠️  Nome já cadastrado! Ignorando duplicata.");
                }
            }
        }

System.out.println("\n=====================================");
System.out.println("          Nomes Cadastrados");
System.out.println("=====================================");
        if (nomes.isEmpty()) {
System.out.println("Nenhum nome foi cadastrado.");
        } else {
        for (String nome : nomes) {
System.out.println("- " + nome);
            }
        }

System.out.println("\n=====================================");
System.out.println("           Busca de Nomes");
System.out.println("=====================================");
System.out.println("Digite um nome para buscar (ou 'sair' para encerrar):");

        while (true) {
            System.out.print("> ");
            String busca = sc.nextLine().trim();
            if (busca.equalsIgnoreCase("sair")) break;

            if (nomes.contains(busca)) {
                System.out.println("✅ Nome encontrado!");
            } else {
                System.out.println("❌ Nome não encontrado.");
            }
        }

        System.out.println("\nEncerrando programa. Até mais!");
        sc.close();
    }
}
