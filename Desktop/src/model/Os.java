package model;

/**
 * A classe OS � respons�vel por conter todas as informa��es referentes a
 * ordem de servi�o,nelas devem constar informa��es do cliente,m�quina,
 * processo e etapa, assim como as datas de abertura e fechamento.
 * @author MarlonSilva
 *
 */

public class Os {
	
	private int idOS,idCliente,idFuncionario,idMaquina,idProcesso,idEtapa;
	private String date,dateOs;
	
	
	
	
	
	public int getIdEtapa() {
		return idEtapa;
	}
	public void setIdEtapa(int idEtapa) {
		this.idEtapa = idEtapa;
	}
	public String getDateOs() {
		return dateOs;
	}
	public void setDateOs(String dateOs) {
		this.dateOs = dateOs;
	}
	public int getIdProcesso() {
		return idProcesso;
	}
	public void setIdProcesso(int idProcesso) {
		this.idProcesso = idProcesso;
	}
	public int getIdOS() {
		return idOS;
	}
	public void setIdOS(int idOS) {
		this.idOS = idOS;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public int getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	public int getIdMaquina() {
		return idMaquina;
	}
	public void setIdMaquina(int idMaquina) {
		this.idMaquina = idMaquina;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	

}
