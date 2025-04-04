package ecommerce.controller;

import java.util.ArrayList;

import ecommerce.model.Produto;
import ecommerce.repository.ProdutoRepository;

public class LojaController implements ProdutoRepository{
	
	private ArrayList<Produto> listaProdutos = new ArrayList<>();
	private int numero = 0;

	@Override
	public void procurarPornumero(int numero) {
		var produto = buscarNaCollection(numero);
		if (produto != null)
			produto.visualizar();
		else
			System.out.println("\nProduto não encontrado.");
	}

	@Override
	public void listarTodos() {
		for (Produto produto : listaProdutos) {
			produto.visualizar();
		}
	}

	@Override
	public void cadastrar(Produto produto) {
		listaProdutos.add(produto);
		System.out.println("\nProduto cadastrado com sucesso!");
	}

	@Override
	public void atualizar(Produto produto) {
		Produto antigo = buscarNaCollection(produto.getnumero());
		if (antigo != null) {
			listaProdutos.set(listaProdutos.indexOf(antigo), produto);
			System.out.println("\nProduto atualizado!");
		} else {
			System.out.println("\nProduto não encontrado.");
		}
	}

	@Override
	public void deletar(int numero) {
		Produto produto = buscarNaCollection(numero);
		if (produto != null) {
			listaProdutos.remove(produto);
			System.out.println("\nProduto removido.");
		} else {
			System.out.println("\nProduto não encontrado.");
		}
	}

	public int gerarnumero() {
		return ++numero;
	}

	public Produto buscarNaCollection(int numero) {
		for (Produto produto : listaProdutos) {
			if (produto.getnumero() == numero)
				return produto;
		}
		return null;
	}
}
