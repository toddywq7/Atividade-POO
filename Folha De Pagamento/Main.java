import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        int opcao = -1;

        System.out.println("=========================================");
        System.out.println("   SISTEMA DE FOLHA DE PAGAMENTO         ");
        System.out.println("=========================================");

        while (opcao != 0) {
            System.out.println("\n1. Cadastrar Gerente");
            System.out.println("2. Cadastrar Desenvolvedor");
            System.out.println("3. Cadastrar Vendedor");
            System.out.println("4. Exibir Holerites e Total da Folha");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao >= 1 && opcao <= 3) {
                try {
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();

                    System.out.print("Salário: R$ ");
                    double salario = scanner.nextDouble();

                    if (opcao == 1) {
                        funcionarios.add(new Gerente(nome, cpf, salario));
                        System.out.println("Gerente cadastrado com sucesso!");
                    } else if (opcao == 2) {
                        funcionarios.add(new Desenvolvedor(nome, cpf, salario));
                        System.out.println("Desenvolvedor cadastrado com sucesso!");
                    } else if (opcao == 3) {
                        System.out.print("Total vendido no mês: R$ ");
                        double vendas = scanner.nextDouble();
                        funcionarios.add(new Vendedor(nome, cpf, salario, vendas));
                        System.out.println("Vendedor cadastrado com sucesso!");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("ERRO: " + e.getMessage());
                }
            } else if (opcao == 4) {
                System.out.println("\n--- PROCESSAMENTO DA FOLHA ---");
                double totalFolha = 0;

                for (Funcionario funcionario : funcionarios) {
                    funcionario.exibirHolerite();
                    totalFolha += funcionario.calcularRemuneracaoTotal();
                }

                System.out.printf("Total da folha: R$ %.2f%n", totalFolha);
            }
        }
        scanner.close();
    }
}