package ecommerce;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import ecommerce.controller.LojaController;
import ecommerce.model.ProdutosOnline;
import ecommerce.util.Cores;

public class Menu {

	public static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {

		LojaController loja = new LojaController();
		int opcao, numero, estoque;
		String nome, formato;
		float preco;

		while (true) {
			System.out.println(Cores.TEXT_WHITE + Cores.ANSI_BLACK_BACKGROUND
					+ "*********************************************");
			System.out.println("                                             ");
			System.out.println("                   LOJINHA                   ");
			System.out.println("                                             ");
			System.out.println("*********************************************");
			System.out.println("                                             ");
			System.out.println("     1 - Cadastrar Produto                   ");
			System.out.println("     2 - Listar Produtos                     ");
			System.out.println("     3 - Buscar Produto por Numero           ");
			System.out.println("     4 - Atualizar Produto                   ");
			System.out.println("     5 - Remover Produto                     ");
			System.out.println("     6 - Sair                                ");     
			System.out.println("                                             ");
			System.out.println("*********************************************");
			System.out.println("Entre com a opção desejada:                  ");
			System.out.print("" + Cores.TEXT_RESET);
			
			try {
				opcao = leia.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite somente números validos!");
				leia.nextLine();
				opcao = 0;
			}

			switch (opcao) {
			case 1 -> {
				System.out.println("\nCadastro do Produto Digital:");
				leia.nextLine();
				System.out.print("Nome: ");
				nome = leia.nextLine();
				System.out.print("Preço: R$ ");
				preco = leia.nextFloat();
				System.out.print("Estoque: ");
				estoque = leia.nextInt();
				leia.nextLine();
				System.out.print("tipo PDF, MP3: ");
				formato = leia.nextLine();

				loja.cadastrar(new ProdutosOnline(loja.gerarnumero(), nome, preco,estoque, formato));
				keyPress();
			}
			case 2 -> {
				loja.listarTodos();
				keyPress();
			}
			case 3 -> {
				System.out.print("\nDigite o numero do produto: ");
				numero = leia.nextInt();
				loja.procurarPornumero(numero);
				keyPress();
			}
			case 4 -> {
				System.out.print("\nDigite o numero do produto para atualizar: ");
				numero = leia.nextInt();
				leia.nextLine();
				
				System.out.print("Nome: ");
				nome = leia.nextLine();
				
				System.out.print("Preço: R$ ");
				preco = leia.nextFloat();
				
				System.out.print("Estoque: ");
				estoque = leia.nextInt();
				leia.nextLine();
				
				System.out.print("Formato: ");
				formato = leia.nextLine();
				loja.atualizar(new ProdutosOnline(numero, nome, preco, estoque, formato));
				keyPress();
			}
			case 5 -> {
				System.out.print("\nDigite o numero do produto a remover: ");
				numero = leia.nextInt();
				loja.deletar(numero);
				keyPress();
			}
			case 6 -> {
				System.out.println("\nObrigado por usar nossa Lojinha Virtual!");
				System.exit(0);
			}
			default -> {
				System.out.println("\nOpção inválida!");
				keyPress();
			}
			}
		}
	}

	public static void keyPress() {
		try {
			System.out.println("\nPressione Enter para continuar...");
			System.in.read();
		} catch (IOException e) {
			System.out.println("INVALIDO!");
		}
	}
}