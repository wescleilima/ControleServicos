package org.senai.contrManutencao.modelo;


public class Quadro {

	
	private int cod;
	private String descricao;
	private String status;
	private String responsavel;
	private String dtInicio;
	private String dtFim;
	
	
	
	public Quadro(){
		setDescricao("");
		setStatus("");
		setResponsavel("");
		setDtInicio("");
		setDtFim("");
	
	}


	public int getCod() {
		return cod;
	}


	public void setCod(int cod) {
		this.cod = cod;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String desccricao) {
		this.descricao = desccricao;
	}


	public String getLocal() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getResponsavel() {
		return responsavel;
	}


	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}


	public String getDtInicio() {
		return dtInicio;
	}


	public void setDtInicio(String dtInicio) {
		this.dtInicio = dtInicio;
	}


	public String getDtFim() {
		return dtFim;
	}


	public void setDtFim(String dtFim) {
		this.dtFim = dtFim;
	}


	public boolean inserir() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
