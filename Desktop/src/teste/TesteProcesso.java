package teste;

import javax.swing.JOptionPane;

import model.ProcessoDAO;

public class TesteProcesso {

	public static void main(String[] args) {
		
		ProcessoDAO p = new ProcessoDAO();
		
		/**
		 * p.setIdProcesso(1);
		p.setIdFuncionario(2);
		p.setDescricao("Manutenção");
		JOptionPane.showMessageDialog(null, p.gravar());
		 */
		
		p.setIdProcesso(2);
		p.setIdFuncionario(2);
		p.setDescricao("Teste");
		p.setId(1);
		JOptionPane.showMessageDialog(null, p.atualizar());

	}

}
