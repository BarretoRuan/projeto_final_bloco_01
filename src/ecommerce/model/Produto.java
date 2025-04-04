package ecommerce.model;

public abstract class  Produto {
	
	private int numero;
	private String nome;
	private float preco;
	private int estoque;

	public Produto(int numero, String nome, float preco, int estoque) {
		this.numero = numero;
		this.nome = nome;
		this.preco = preco;	
		this.estoque = estoque;
	}

	public int getnumero() {
		return numero;
	}

	public void setnumero(int numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}


	public void visualizar() {
		System.out.println("\n---------------------------");
		System.out.println("Numero: " + numero);
		System.out.println("Nome: " + nome);
		System.out.println("Preço: R$" + preco);
		System.out.println("Estoque: " + estoque + " unidades");
	}

}
