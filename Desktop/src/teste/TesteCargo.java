package teste;

import javax.swing.JOptionPane;

import model.*;

public class TesteCargo {

	public static void main(String[] args) {
		
		CargoDAO c = new CargoDAO();
		// realiza uma consulta no bd e retorna o cargo atendente
		//c.setIdCargo(1);
		//JOptionPane.showMessageDialog(null, c.buscarCargo());
		
		c.setDescricao("T�cnico II");
		c.setFuncao("Realizar manuten��es em empresas na parte de infra");
		JOptionPane.showMessageDialog(null, c.gravar());
		
		

	}

}
