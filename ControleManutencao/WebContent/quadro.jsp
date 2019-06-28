<%@page import="org.senai.contrManutencao.modelo.Quadro"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Controle de Manutenção</title>
</head>
<body>
<div class="container">
<div align="center"><img src="img/allia.jpg"
	height="240" width="400"/>
	<h1>Controle de Serviço</h1>
</div>
            
  
  <table class="table table-striped">
  
    <thead>
      <tr>
     
        <th width="28%">Descrição do Serviço<p></th>
		<th width="17%">Status<p></th>
	    <th width="17%">Local<p></th> 
		<th width="17%">Responsavel<p></th>
		<th width="15%">Data Início<p></th>
		<th width="15%">Data Fim<p></th>
		
      </tr>
    </thead>
    <tbody>
      <script>
      
      function prepararEditar(cod){
      //alert("ediatar "+cod);
     window.location.replace('gerenciarQuadro.jsp?cod'+cod);
      }
      
      </script>
      
      <%
      Quadro quadro = new Quadro();
      
      for (Quadro p : quadro.getLista()) {
    	out.print("<tr onclick='prepararEditar("+p.getCod()+")'>");
    	//out.print("<td>"+p.getCod()+"</td>");
    	out.print("<td>"+ p.getDescricao()+"</td>");
    	out.print("<td class='"+p.getStatus()+"'>" + p.getStatus()+"</td>");
    	out.print("<td>"+ p.getLocal()+"</td>");
    	out.print("<td>"+ p.getResponsavel()+"</td>");
    	out.print("<td>"+ p.getDtInicio()+"</td>");
    	out.print("<td>"+ p.getDtFim()+"</td>");
    	out.print("</tr>");
    	
      } 
      
      %>
    </tbody>
  </table>

</div>
</body>
</html>