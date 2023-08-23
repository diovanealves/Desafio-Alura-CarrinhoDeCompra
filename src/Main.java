import models.CartaoDeCredito;
import models.Compra;

import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 1;

        System.out.println("Infome o limite do cartão");
        int limite = scanner.nextInt();
        CartaoDeCredito cartaoDeCredito = new CartaoDeCredito(limite);

        do {
            System.out.println("Informa a descrição do produto:");
            String descricao = scanner.next();

            System.out.println("Informe o valor da Compra:");
            double valorCompra = scanner.nextDouble();

            Compra compra = new Compra(descricao, valorCompra);
            if (cartaoDeCredito.adicionarCompra(compra)) {
                System.out.println("Compra realizada! ");
                System.out.println("Digite 0 para sair ou 1 para adicionar mais uma compra");
                opcao = scanner.nextInt();
            } else {
                System.out.println("Saldo insuficiente!");
                opcao = 0;
            }
        } while (opcao != 0);

        System.out.println("*********************");
        System.out.println("Compras Realizadas: \n");
        Collections.sort(cartaoDeCredito.getCompras());
        for (Compra compra : cartaoDeCredito.getCompras()) {
            System.out.println(compra.getDescricao() + " - " + compra.getValor());
        }
        System.out.println("\n *********************");
        System.out.println("\n Saldo do cartão: " + cartaoDeCredito.getSaldo());
    }

}