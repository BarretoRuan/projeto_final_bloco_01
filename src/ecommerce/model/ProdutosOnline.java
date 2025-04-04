package ecommerce.model;

public class ProdutosOnline extends Produto{
	
	private String tipo;

	public ProdutosOnline(int numero, String nome, float preco, int estoque, String tipo) {
		super(numero, nome, preco, estoque);
		this.tipo = tipo;
	}

	public String gettipo() {
		return tipo;
	}

	public void settipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("tipo: " + this.tipo);
	}

}
