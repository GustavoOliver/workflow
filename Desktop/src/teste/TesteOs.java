package teste;
import model.*;

public class TesteOs {
	
	public static void main(String[] args) {
		
		OsDAO os = new OsDAO();
		os.setIdFuncionario(2);
		os.setIdCliente(2);
		os.setIdEtapa(1);
		os.setIdProcesso(1);
		os.setIdMaquina(2);
		os.setDateOs("2014/08/21");
		os.setDate("2014/08/22");
		System.out.println(os.gravar());
	}

}
