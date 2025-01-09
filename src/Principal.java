import java.util.Collections;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        String pulaLinha = "****************************";
        Scanner leitura = new Scanner(System.in);
        int opcao = 0;

        System.out.println(pulaLinha);
        System.out.println("************ Seja Bem-Vindo!!! ************");
        System.out.println("\nDigite o limite do cartão: ");
        double limite = leitura.nextDouble();
        leitura.nextLine(); // Consumir quebra de linha pendente
        CartaoDeCredito cartao = new CartaoDeCredito(limite);

        while (opcao != 4) {
            System.out.println(pulaLinha);
            System.out.println("Menu de opções!!");
            System.out.println("1- Efetuar uma compra");
            System.out.println("2- Visualizar lista de compras");
            System.out.println("3- Saldo disponível");
            System.out.println("4- Finalizar!");
            System.out.println(pulaLinha);

            opcao = leitura.nextInt();
            leitura.nextLine(); // Consumir quebra de linha pendente

            switch (opcao) {
                case 1:
                    System.out.println("Nome do produto: ");
                    String descricao = leitura.nextLine();

                    System.out.println("Digite o valor: ");
                    double valor = leitura.nextDouble();
                    leitura.nextLine(); // Consumir quebra de linha pendente

                    Compra compra = new Compra(descricao, valor);
                    boolean compraRealizada = cartao.lancaCompra(compra);

                    if (compraRealizada) {
                        System.out.println("Compra realizada com sucesso!");
                    } else {
                        System.out.println("Saldo insuficiente para esta compra!");
                    }
                    break;

                case 2:
                    System.out.println("Lista de Compras:");
                    Collections.sort(cartao.getCompras());
                    if (cartao.getCompras().isEmpty()) {
                        System.out.println("Nenhuma compra realizada.");
                    } else {
                        for (Compra c : cartao.getCompras()) {
                            System.out.println("Produto: " + c.getDescricao() + " | Valor: R$ " + c.getValor());
                        }
                    }
                    break;

                case 3:
                    System.out.println("Saldo disponível: R$ " + cartao.getSaldo());
                    break;

                case 4:
                    System.out.println("Finalizando o programa... Obrigado!");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        leitura.close();
    }
}
