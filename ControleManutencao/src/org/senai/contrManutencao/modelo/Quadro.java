package org.senai.contrManutencao.modelo;


public class Quadro {

	
	private int cod;
	private String descServico;
	private String local;
	private String responsavel;
	private String situacao;
	private String dtInicio;
	private String dtFim;
	
	
	public Quadro(){
		setDescServico("");
		setLocal("");
		setResponsavel("");
		setSituacao("");
		setDtInicio("");
		setDtFim("");
	
	}


	public int getCod() {
		return cod;
	}


	public void setCod(int cod) {
		this.cod = cod;
	}


	public String getDescServico() {
		return descServico;
	}


	public void setDescServico(String descServico) {
		this.descServico = descServico;
	}


	public String getLocal() {
		return local;
	}


	public void setLocal(String local) {
		this.local = local;
	}


	public String getResponsavel() {
		return responsavel;
	}


	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}


	public String getSituacao() {
		return situacao;
	}


	public void setSituacao(String situacao) {
		this.situacao = situacao;
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
	
	
}
