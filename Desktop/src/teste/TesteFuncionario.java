package teste;

import model.*;

public class TesteFuncionario {

	public static void main(String[] args) {
		
		FuncionarioDAO f = new FuncionarioDAO();
		
		f.setNome("Marlon");
		f.setSobrenome("Silva");
		f.setCpf("00000000");
		f.setRg("0000000");
		f.setEmail("sdf@sf.sdf");
		f.setSenha("1234");
		f.setIdCargo(1);
		System.out.println(f.gravar());
		

	}

}
