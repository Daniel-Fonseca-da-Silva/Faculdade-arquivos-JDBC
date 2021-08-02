package negocio;

public class Produto {
	
	private String codigo;
	private String descricao;
	private double valorUnit;
	private int qtEstoque;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValorUnit() {
		return valorUnit;
	}
	public void setValorUnit(double valorUnit) {
		this.valorUnit = valorUnit;
	}
	public int getQtEstoque() {
		return qtEstoque;
	}
	public void setQtEstoque(int qtEstoque) {
		this.qtEstoque = qtEstoque;
	}
	
	
	
}
