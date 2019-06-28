package org.senai.contrManutencao.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.senai.contrManutencao.modelo.ConectarJDBC;

public class Quadro {

	
	private int cod;
	private String descricao;
	private String status;
	private String local;
	private String responsavel;
	private String dtInicio;
	private String dtFim;
	
	
	
	public Quadro(){
		setCod(0);
		setDescricao("");
		setStatus("");
		setLocal("");
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


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
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

	public boolean apagar() {

		Connection conexao = new ConectarJDBC().getConectar();
		
		if(conexao != null) {
			String sql = "delete from quadro where cod = ? ";
			try {
				PreparedStatement prepararSQL =
						conexao.prepareStatement(sql);
				prepararSQL.setInt(1, cod);
				
				prepararSQL.execute();
				prepararSQL.close();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			
		}
		return false;
	}
	
		//copiamos o codigo  inserir para reaproveitar o codigo e 
		//fazer o metodo atualizar
	public boolean atualizar() {

		Connection conexao = new ConectarJDBC().getConectar();
		
		if(conexao != null) {
			String sql = "update painel set " + 
					"	descricao = ? ," + 
					"	status        = ? ," + 
					"	local        = ? ," + 
					"	responsavel  = ? ," + 
					"	dt_inicio  = ? ," + 
					"	dt_fim   = ?," + 
					" where cod = ? ";
			try {
				PreparedStatement prepararSQL =
						conexao.prepareStatement(sql);
				prepararSQL.setString(1, descricao);
				prepararSQL.setString(2, status);
				prepararSQL.setString(3, local);
				prepararSQL.setString(4, responsavel);
				prepararSQL.setString(5, dtInicio);
				prepararSQL.setString(6, dtFim);
				prepararSQL.setInt(7, cod);
				
				prepararSQL.execute();
				prepararSQL.close();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			
		}
		return false;
	}
	
	public boolean inserir() {

		Connection conexao = new ConectarJDBC().getConectar();
		
		if(conexao != null) {
			String sql = "insert into quadro(" + 
					"	descricao  ," + 
					"	status         ," + 
					"	local          ," + 
					"	responsavel   ," + 
					"	dt_inicio   ," + 
					"	dt_fim   " + 
					"	 )" + 
					"values (?," + 
					"		?," + 
					"		?," + 
					"		?," + 
					"		?," + 
					"		? " + 
					"		)";
			try {
				PreparedStatement prepararSQL =
						conexao.prepareStatement(sql);
				prepararSQL.setString(1, descricao);
				prepararSQL.setString(2, status);
				prepararSQL.setString(3, local);
				prepararSQL.setString(4, responsavel);
				prepararSQL.setString(5, dtInicio);
				prepararSQL.setString(6, dtFim);
				
				prepararSQL.execute();
				prepararSQL.close();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			
		}
		return false;
	}
	
	public List<Quadro> getLista(){		
		try {
			Connection conexao = new ConectarJDBC().getConectar();
			PreparedStatement ps = 					
					conexao.prepareStatement("select * from quadro");
			ResultSet rs = ps.executeQuery();
			
			List<Quadro> lsQuadro = new ArrayList<Quadro>();
			
			while (rs.next()) {
				Quadro p = new Quadro();
				// o que esta entre aspas "nome_da_coluna_no_banco"
				p.setCod(rs.getInt("cod"));
				p.setDescricao(rs.getString("descricao"));
				p.setStatus(rs.getString("status"));
				p.setLocal(rs.getString("local"));
				p.setResponsavel(rs.getString("responsavel"));
				p.setDtInicio(rs.getString("dt_inicio"));
				p.setDtFim(rs.getString("dt_fim"));
				lsQuadro.add(p);
			}
			ps.close();
			conexao.close();
			return lsQuadro;
		} catch (Exception e) {

		}		
		return null;
	}
	
	public Quadro getQuadro(int cod){		
		try {
			Connection conexao = new ConectarJDBC().getConectar();
			PreparedStatement ps = 					
					conexao.prepareStatement("select * from quadro where cod = ? ");
			ps.setInt(1, cod);
			ResultSet rs = ps.executeQuery();
			
			Quadro p = new Quadro();
			
			while (rs.next()) {
				
				// o que esta entre aspas "nome_da_coluna_no_banco"
				p.setCod(rs.getInt("cod"));
				p.setDescricao(rs.getString("descricao_servico"));
				p.setStatus(rs.getString("status"));
				p.setLocal(rs.getString("local"));
				p.setResponsavel(rs.getString("responsavel"));
				p.setDtInicio(rs.getString("dt_inicio"));
				p.setDtFim(rs.getString("dt_fim "));
		
			}
			ps.close();
			conexao.close();
			return p;
		} catch (Exception e) {

		}		
		return null;
	}
	
	public String getCorStatus() {
			
		if(status.equals("Agendado")) {
			return "table-warning";
		}

		if(status.equals("Em andamento")) {
			return "table-danger";
		}		
		
		if(status.equals("Parado")) {
			return "table-success";
		}

		if(status.equals("Concluído")) {
			return "table-primary";
		}
		
		return "";
	}


}

