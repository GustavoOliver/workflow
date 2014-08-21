package model;

import javafx.scene.chart.PieChart.Data;

public class Etapa {
	
	private int idEtapa,idProcesso;
	private String descricao;
	private Data data;
	public int getIdEtapa() {
		return idEtapa;
	}
	public void setIdEtapa(int idEtapa) {
		this.idEtapa = idEtapa;
	}
	public int getIdProcesso() {
		return idProcesso;
	}
	public void setIdProcesso(int idProcesso) {
		this.idProcesso = idProcesso;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	
	

}
