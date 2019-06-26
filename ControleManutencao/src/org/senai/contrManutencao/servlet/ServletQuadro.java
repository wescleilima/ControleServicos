package org.senai.contrManutencao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.senai.contrManutencao.modelo.Quadro;

//mapear a classe servlet
@WebServlet(name ="ServletQuadro",
 urlPatterns = "/servletQuadro"
 )
public class ServletQuadro extends HttpServlet{

public void service(HttpServletRequest request,
  HttpServletResponse response)throws
ServerException, IOException{
 
 //tenho que pegar as informações do formulário
 String descricao = request.getParameter("descricao");
 String status = request.getParameter("status");
 String local = request.getParameter("local");
 String responsavel = request.getParameter("responsavel");
// String dtInicio = request.getParameter("dtInicio");
// String dtFim = request.getParameter("dtFim");
// System.out.println(" Descrição do Serviço: "+ descServico + "Status: " + status + Local: "+ local + " Responsável: "+ responsavel +" Data Início: " + dtInicio + "Data Fim" + dtFim );
 
 Quadro obj = new Quadro();
 obj.setDescricao(descricao);
 obj.setStatus(status);
 obj.setLocal(local);
 obj.setResponsavel(responsavel);
// obj.setDtInicio(dtInicio);
// obj.setDtFim(dtFim);
 
 obj.inserir();
 
 PrintWriter saida = response.getWriter();
 int cod = Integer.parseInt(
   request.getParameter("cod"));
 
 boolean sucesso = false;
 if(cod > 0) {
  obj.setCod(cod);
  if(request.getParameter("apagar")==null) {
  sucesso = obj.atualizar();
 }else {
  sucesso = obj.apagar();
 }
  
}else {
  sucesso = obj.inserir();
}
 
 if(sucesso) {
  saida.print("Gravado com sucesso");
 }else {
  saida.print("Erro ao gravar");
 }

}

}
