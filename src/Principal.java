import java.awt.EventQueue;

import tela.Tela;

public class Principal {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try {
					Tela tela = new Tela();
					tela.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});

	}

}
