package src.loja.model.armazenamento;


public abstract class Armazenamento {
	protected static final int CAPACIDADE_MAXIMA = 100;
	protected int tamanho = 0;
	protected int tamanhoAux = 0;
	
	public boolean estaCheio() {
		return tamanho >= CAPACIDADE_MAXIMA;
	}
	public int capacidadeRestante() {
		return CAPACIDADE_MAXIMA - tamanho;
	}
}