import java.util.Scanner;

public class AppBancoDigital {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ContaDigital conta = new ContaDigital("João da Silva", "AG123-45", 1000.00);

        while (true) {
            System.out.println("\n====== BANCO DIGITAL ======");
            System.out.println("1. Creditar valor");
            System.out.println("2. Debitar valor");
            System.out.println("3. Transferir para outra conta");
            System.out.println("4. Pagar título");
            System.out.println("5. Encerrar sessão");
            System.out.print("Escolha a opção desejada: ");
            String opcao = input.nextLine();

            switch (opcao) {
                case "1":
                    System.out.print("Valor para depósito: R$ ");
                    double valorCredito = Double.parseDouble(input.nextLine());
                    if (conta.creditar(valorCredito)) {
                        System.out.println("✓ Crédito realizado.");
                    } else {
                        System.out.println("✗ Valor inválido.");
                    }
                    break;

                case "2":
                    System.out.print("Valor para saque: R$ ");
                    double valorDebito = Double.parseDouble(input.nextLine());
                    if (conta.debitar(valorDebito)) {
                        System.out.println("✓ Débito realizado.");
                    } else {
                        System.out.println("✗ Saldo insuficiente ou valor inválido.");
                    }
                    break;

                case "3":
                    System.out.print("Valor a transferir: R$ ");
                    double valorTransferencia = Double.parseDouble(input.nextLine());
                    ContaDigital destino = new ContaDigital("Maria Oliveira", "AG789-01", 500.00);
                    if (conta.transferirPara(destino, valorTransferencia)) {
                        System.out.println("✓ Transferência realizada.");
                        System.out.printf("Saldo destinatário: R$ %.2f%n", destino.consultarSaldo());
                    } else {
                        System.out.println("✗ Transferência não realizada.");
                    }
                    break;

                case "4":
                    System.out.print("Valor do pagamento: R$ ");
                    double valorPagamento = Double.parseDouble(input.nextLine());
                    if (conta.pagarTitulo(valorPagamento)) {
                        System.out.println("✓ Pagamento efetuado.");
                    } else {
                        System.out.println("✗ Pagamento não realizado.");
                    }
                    break;

                case "5":
                    System.out.println("Sessão encerrada. Obrigado por utilizar nosso banco!");
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

            System.out.printf("Saldo atual: R$ %.2f (inclui taxas)%n", conta.consultarSaldo());
        }
    }
}
