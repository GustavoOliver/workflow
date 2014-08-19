package teste;
import model.*;

public class TesteOs {
	
	public static void main(String[] args) {
		
		OsDAO os = new OsDAO();
		os.setIdOS(2);
		os.setIdFuncionario(1);
		os.setIdCliente(1);
		os.setIdEtapa(1);
		os.setIdProcesso(1);
		os.setIdMaquina(1);
		os.setDateOs("19/08/2014");
		os.setDate("20/08/2014");
		os.gravar();
	}

}
