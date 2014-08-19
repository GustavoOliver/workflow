package teste;

import model.*;

public class TesteCargo {

	public static void main(String[] args) {
		
		CargoDAO c = new CargoDAO();
		
		c.localizar(2);
		c.setFuncao("Estagiario2");
		c.setDescricao("manutenção de pcs2");
		

	}

}
