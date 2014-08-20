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
		os.setDateOs("19/08/2014");
		os.setDate("20/08/2014");
		os.gravar();
	}

}
