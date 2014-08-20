package teste;

import model.ProcessoDAO;

public class TesteProcesso {

	public static void main(String[] args) {
		
		ProcessoDAO p = new ProcessoDAO();
		
		p.setIdProcesso(3);
		p.setIdFuncionario(2);
		p.setDescricao("Testando Update");
		System.out.println(p.gravar());

	}

}
