package tela;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bd.DaoProduto;
import javafx.scene.control.Alert;
import negocio.Produto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.SystemColor;

public class Tela extends JFrame implements ActionListener{

	private JPanel telaInicial;
	private JTextField textCodigo;
	private JTextField textDescricao;
	private JTextField textEstoque;
	private JTextField textValorUnit;
	private JButton btnIncluir;
	private JButton btnExcluir;
	private JButton btnAlterar;
	private JButton btnConsultar;
	private JButton btnLimpar;
	private JButton btnSair;

	private DaoProduto dao = null;
	private Produto produto = null; 
	
	public Tela() {
		
		try // tente
		{
		
		// Configurações da telaInicial
		setTitle("Conectador de Banco de Dados com JDBC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 373);
		telaInicial = new JPanel();
		telaInicial.setBackground(new Color(56, 80, 129));
		telaInicial.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(telaInicial);
		telaInicial.setLayout(null);
		
		// Criação de objetos 
		dao = new DaoProduto();
		
		// Texto de exibições
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(114, 24, 70, 15);
		lblCodigo.setForeground(new Color(255, 255, 255));
		telaInicial.add(lblCodigo);
		
		JLabel lblDescricao = new JLabel("Descrição:");
		lblDescricao.setBounds(114, 82, 88, 15);
		lblDescricao.setForeground(new Color(255, 255, 255));
		telaInicial.add(lblDescricao);
		
		JLabel lblEstoque = new JLabel("Estoque: ");
		lblEstoque.setBounds(114, 144, 88, 15);
		lblEstoque.setForeground(new Color(255, 255, 255));
		telaInicial.add(lblEstoque);
		
		JLabel lblValorUnit = new JLabel("Valor Unitário:");
		lblValorUnit.setBounds(114, 210, 103, 15);
		lblValorUnit.setForeground(new Color(255, 255, 255));
		telaInicial.add(lblValorUnit);
		
		// textos de entrada
		
		Font font = new Font("Calibri", Font.BOLD, 15); // Configura a fonte dos JTextFields
		
		textCodigo = new JTextField();
		textCodigo.setBounds(235, 22, 482, 19);
		textCodigo.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		textCodigo.setFont(font);
		telaInicial.add(textCodigo);
		textCodigo.setColumns(10);
		
		textDescricao = new JTextField();
		textDescricao.setBounds(235, 80, 482, 19);
		textDescricao.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); 
		textDescricao.setFont(font);
		telaInicial.add(textDescricao);
		textDescricao.setColumns(10);
		
		textEstoque = new JTextField();
		textEstoque.setBounds(235, 142, 482, 19);
		textEstoque.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); 
		textEstoque.setFont(font);
		telaInicial.add(textEstoque);
		textEstoque.setColumns(10);
		
		textValorUnit = new JTextField();
		textValorUnit.setBounds(235, 208, 482, 19);
		textValorUnit.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); 
		textValorUnit.setFont(font);
		telaInicial.add(textValorUnit);
		textValorUnit.setColumns(10);
		
		// Botões
		btnIncluir = new JButton("Incluir");
		btnIncluir.setBounds(12, 293, 117, 25);
		btnIncluir.setBackground(new Color(46, 208, 110));
		btnIncluir.setForeground(new Color(255, 255, 255));
		btnIncluir.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); 
		btnIncluir.setSize(100, 30);
		telaInicial.add(btnIncluir);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(146, 293, 117, 25);
		btnExcluir.setBackground(new Color(0, 185, 250));
		btnExcluir.setForeground(new Color(255, 255, 255));
		btnExcluir.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); 
		btnExcluir.setSize(100, 30);
		telaInicial.add(btnExcluir);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(280, 293, 117, 25);
		btnAlterar.setBackground(new Color(0, 185, 250));
		btnAlterar.setForeground(new Color(255, 255, 255));
		btnAlterar.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); 
		btnAlterar.setSize(100, 30);
		telaInicial.add(btnAlterar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(416, 293, 117, 25);
		btnConsultar.setBackground(new Color(0, 185, 250));
		btnConsultar.setForeground(new Color(255, 255, 255));
		btnConsultar.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); 
		btnConsultar.setSize(100, 30);
		telaInicial.add(btnConsultar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(555, 293, 117, 25);
		btnLimpar.setBackground(new Color(0, 185, 250));
		btnLimpar.setForeground(new Color(255, 255, 255));
		btnLimpar.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); 
		btnLimpar.setSize(100, 30);
		telaInicial.add(btnLimpar);
		
		btnSair = new JButton("Sair");
		btnSair.setBounds(694, 293, 117, 25);
		btnSair.setBackground(new Color(237, 85, 101));
		btnSair.setForeground(new Color(255, 255, 255));
		btnSair.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); 
		btnSair.setSize(100, 30);
		telaInicial.add(btnSair);
		
		// Registra listeners
		btnIncluir.addActionListener(this);
		btnConsultar.addActionListener(this);
		btnExcluir.addActionListener(this);
		btnAlterar.addActionListener(this);
		btnLimpar.addActionListener(this);
		btnSair.addActionListener(this);
		
		setLocationRelativeTo(null);// Centraliza tela
		
		} catch(Exception e)
		{
			JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro inesperado ao acessar " + e.getMessage());
		}
		
	}
	// Tratamento de ação
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnIncluir)
		{
			incluir();
		}
		else if(e.getSource() ==  btnAlterar)
		{
			alterar();
		}
		else if(e.getSource() == btnConsultar)
		{
			consultar();
		}
		else if(e.getSource() == btnExcluir)
		{
			excluir();
		}
		else if(e.getSource() == btnLimpar)
		{
			limpar();
		}
		else
		{
			sair();
		}
		
	}

	// Metódos que capturam os valores digitados nos botões
	private void incluir() 
	{
		try // Tente
		{
		produto = new Produto();
		
		produto.setCodigo(textCodigo.getText());// Pega texto inserido no codigo
		produto.setDescricao(textDescricao.getText()); // Pega texto inserido na descricao
		produto.setValorUnit(Double.parseDouble(textValorUnit.getText())); // Conveter e pega o valor 
		produto.setQtEstoque(Integer.parseInt(textEstoque.getText())); // Converte e pega o estoque
		
		dao.incluir(produto); // Passa produto como argumento para DaoProduto
		JOptionPane.showMessageDialog(rootPane, "Inclusão efetuada com sucesso!");
		
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro de inclusão " + e.getMessage());
		}

	}
	
	private void alterar() 
	{
		try // tente
		{
			produto = new Produto();
			
			produto.setCodigo(textCodigo.getText());
			produto.setDescricao(textDescricao.getText());
			produto.setValorUnit(Double.parseDouble(textValorUnit.getText()));
			produto.setQtEstoque(Integer.parseInt(textEstoque.getText()));
			
			dao.alterar(produto);
			JOptionPane.showMessageDialog(rootPane, "Alteração efetuada com sucesso!");
			
			
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro de alteração!. " + e.getMessage());
		}
	}
	private void consultar() 
	{
		try // tente
		{
			produto = new Produto();
			produto.setCodigo(textCodigo.getText());
			
			dao.consultar(produto);
			
			textCodigo.setText(produto.getCodigo());
			textDescricao.setText(produto.getDescricao());
			textValorUnit.setText(Double.toString(produto.getValorUnit()));
			textEstoque.setText(Integer.toString(produto.getQtEstoque()));
			
			
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro ao consultar. " + e.getMessage());
		}
	}
	private void excluir() 
	{
		try // tente
		{
			produto = new Produto();
			
			produto.setCodigo(textCodigo.getText());
			
			dao.excluir(produto);
			
			JOptionPane.showMessageDialog(rootPane, "Exlusão efetuada com sucesso!");
			
			
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro de alteração. " + e.getMessage());
		}
	}
	private void limpar() 
	{
		try // tente
		{
			// Reseta valores
			textCodigo.setText("");
			textDescricao.setText("");
			textValorUnit.setText("");
			textEstoque.setText("");
			
			
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro ao limpar dados " + e.getMessage());
		}
	}
	private void sair() 
	{
		try // tente
		{
			int entrada = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "alert", JOptionPane.OK_CANCEL_OPTION);
			
			if(entrada == 0)
			{
				dispose(); // Sai do programa
			}
			
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro ao tentar sair. " + e.getMessage()); 
		}
	}
}
