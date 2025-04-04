package ecommerce.repository;

import ecommerce.model.Produto;

public interface ProdutoRepository {

	void procurarPornumero(int numero);
	void listarTodos();
	void cadastrar(Produto produto);
	void atualizar(Produto produto);
	void deletar(int numero);
}
