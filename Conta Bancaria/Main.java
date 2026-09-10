import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ContaPoupanca poupanca = new ContaPoupanca("1001-1", "Ana Silva");
        ContaCorrente corrente = new ContaCorrente("2002-2", "Carlos Souza", 1000.00);
        ContaEmpresarial empresarial = new ContaEmpresarial("0001-9", "Loja Central Ltda.", 5000.00);

        ContaBancaria contaAtual = null;
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n=================================");
            System.out.println("                NuBanko          ");
            System.out.println("=================================");
            System.out.println("1. Acessar Conta Poupança");
            System.out.println("2. Acessar Conta Corrente");
            System.out.println("3. Acessar Conta Empresarial");
            System.out.println("0. Encerrar Sistema");
            System.out.print("Escolha uma conta: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    contaAtual = poupanca;
                    break;
                case 2:
                    contaAtual = corrente;
                    break;
                case 3:
                    contaAtual = empresarial;
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    continue;
                default:
                    System.out.println("Opção inválida!");
                    continue;
            }

            int opOperacao = -1;
            while (opOperacao != 0 && opcao != 0) {
                System.out.println("\n--- CONTA: " + contaAtual.getNumeroConta() + " | TITULAR: "
                        + contaAtual.getTitular() + " ---");
                System.out.println("1. Depositar");
                System.out.println("2. Sacar");
                System.out.println("3. Exibir Extrato");
                System.out.println("0. Voltar ao Menu Principal");
                System.out.print("Escolha a operação: ");

                opOperacao = scanner.nextInt();

                switch (opOperacao) {
                    case 1:
                        System.out.print("Digite o valor para depósito: R$ ");
                        double valorDep = scanner.nextDouble();
                        contaAtual.depositar(valorDep); // Depósitos devem ser maiores que zero[cite: 1]
                        System.out.printf("Saldo após operação: R$ %.2f%n", contaAtual.getSaldo()); // Exibir saldo após
                                                                                                    // operação[cite: 1]
                        break;
                    case 2:
                        System.out.print("Digite o valor para saque: R$ ");
                        double valorSaq = scanner.nextDouble();
                        contaAtual.sacar(valorSaq); // Valida limite, saldo insuficiente e taxas[cite: 1]
                        System.out.printf("Saldo após operação: R$ %.2f%n", contaAtual.getSaldo()); // Exibir saldo após
                                                                                                    // operação[cite: 1]
                        break;
                    case 3:
                        contaAtual.exibirExtrato();
                        break;
                    case 0:
                        System.out.println("Retornando...");
                        break;
                    default:
                        System.out.println("Operação inválida!");
                }
            }
        }
        scanner.close();
    }
}