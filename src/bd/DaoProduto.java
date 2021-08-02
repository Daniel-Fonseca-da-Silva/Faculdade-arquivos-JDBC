package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import negocio.Produto;

public class DaoProduto {
	
	private Connection con = null;
	private PreparedStatement st = null;
	private ResultSet rs = null;
	
	public DaoProduto() throws Exception // Trata essa exceção na classe Tela
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/alunos", "root", "123");
		
	}
	
	// Metódos que jogam os valores para o SGBD
	
	public void incluir(Produto produto) throws Exception
	{
		st = con.prepareStatement("INSERT INTO mercado.produtos VALUES(?, ?, ?, ?)");
		
		st.setString(1, produto.getCodigo());
		st.setString(2, produto.getDescricao());
		st.setDouble(3, produto.getValorUnit());
		st.setInt(4, produto.getQtEstoque());
		
		st.execute();
		st.close();
	}
	
	public void excluir(Produto produto) throws Exception
	{
		st = con.prepareStatement("DELETE FROM mercado.produtos WHERE codigo = (?)");
		st.setString(1, produto.getCodigo());
		
		st.execute();
		st.close();
	}
	public void alterar(Produto produto) throws Exception
	{
		st = con.prepareStatement("UPDATE mercado.produtos SET descricao = ?, valorUnit = ?, qtEstoque = ? WHERE codigo = ?");
		
		st.setString(1, produto.getDescricao());	
		st.setDouble(2, produto.getValorUnit());
		st.setInt(3, produto.getQtEstoque());
		st.setString(4, produto.getCodigo());
		
		st.execute();
		st.close();
	}
	public void consultar(Produto produto) throws Exception
	{
		st = con.prepareStatement("SELECT * FROM mercado.produtos WHERE codigo = ?");
		
		st.setString(1, produto.getCodigo());
		
		rs = st.executeQuery();
		
		if(rs.next())
		{
			produto.setCodigo(rs.getString(1));
			produto.setDescricao(rs.getString(2));
			produto.setValorUnit(rs.getDouble(3));
			produto.setQtEstoque(rs.getInt(4));
			
		}
		
		st.execute();
		st.close();
	}
	
}
