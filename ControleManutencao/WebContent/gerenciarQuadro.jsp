<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gerenciar Quadro</title>
</head>
<body>

<script type="text/javascript">
	
	function dadosForm() {
		var dados = "";		
		dados += "descrServ="+document.getElementById("descrServ").value;
		dados += "&local="+document.getElementById("local").value;		
		dados += "&responsavel="+document.getElementById("responsavel").value;
		dados += "&situacao="+document.getElementById("situacao").value;
		dados += "&dtInicio="+document.getElementById("dtInicio").value;
		dados += "&dtFim="+document.getElementById("dtFim").value;
		dados += "&cod="+document.getElementById("cod").value;
		return dados;
	}
		function gravar() {
			
			
			
			var xhttp = new XMLHttpRequest();
			xhttp.onreadystatechange = function() {
			    if (this.readyState == 4 && this.status == 200) {
			       var msg = xhttp.responseText;
			       document.getElementById("msg").innerHTML = msg;
			       if(msg == "Gravado com sucesso"){
			    	   document.getElementById("msg").className = "alert alert-info";
			       }else{
			    	   document.getElementById("msg").className = "alert alert-danger";
			       }
			    }
			};
			xhttp.open("GET", "servletPainel?"+dadosForm(), true);
			xhttp.send();
			
		}
		
		function apagar(){
			
			if(confirm("Realmente deseja Apagar esse registro?")){
			
			var xhttp = new XMLHttpRequest();
			xhttp.onreadystatechange = function() {
			    if (this.readyState == 4 && this.status == 200) {
			       var msg = xhttp.responseText;
			       document.getElementById("msg").innerHTML = msg;
			       
			       
			       if(msg == "Gravado com sucesso"){
			    	   document.getElementById("msg").className = "alert alert-info";
			    	   document.getElementById("msg").innerHTML = "informa��o apagada";
			    	   document.getElementById("formulario").reset();
			    	   
			       }else{
			    	   document.getElementById("msg").className = "alert alert-danger";
			    	   document.getElementById("msg").innerHTML = "Erro ao apagar";
			       }
			    }
			};
			xhttp.open("GET", "servletPainel?"+dadosForm()+"&apagar", true);
			xhttp.send();
			
		}
			
			function novo(){
				window.location.replace('gerenciarPainel.jsp');
			}
					
		}
	</script>


<%
// meu java rolar
Painel painel = new Painel();

if(request.getParameter("cod") != null){
	int cod = Integer.parseInt(request.getParameter("cod"));
	painel = painel.getPainel(cod);	
}


%>

	<div class="container">
		<h2>Gerenciar o Painel dos Pacientes no Centro Cir�rgico</h2>
		<form id="formulario">
		<input type="hidden" 
		value="<% out.print(painel.getCod()); %>"
		id="cod"
		/>
		
		
		<div id="msg"></div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="nome">Nome Completo:</label> 
					<input type="text"
						class="form-control" 
						id="nome" 
						value="<% out.print(painel.getNomeCompleto()); %>"
						placeholder="Nome do Paciente"
						name="nome">
				</div>

				<div class="form-group col-md-3">
					<label for="status">Status:</label> 
					<select class="form-control" id="status">
						<option >Pr�-Operat�rio</option>
						<option >Em sala cir�rgica</option>
						<option >Em recupera��o</option>
						<option >Transferido</option>
					</select>	
					<script>
					document.getElementById("status").value = 
						"<% out.print(painel.getStatus()); %>";
					</script>
				</div>

				<div class="form-group col-md-3">
					<label for="local">Local:</label> <input type="text"
						class="form-control" 
						value="<% out.print(painel.getLocal()); %>"
						id="local" placeholder="Quarto/Sala"
						>
				</div>
			</div>

			<div class="form-row">
				<div class="form-group col-md-3">
					<label for="local">In�cio Previsto:</label> <input type="time"
						class="form-control" 
						value="<% out.print(painel.getIniPrevisto()); %>"
						id="iniPrev" >
				</div>
				<div class="form-group col-md-3">
					<label for="local">In�cio Cir�rgia:</label> <input type="time"
						class="form-control" 
						value="<% out.print(painel.getIniCirurgia()); %>"
						id="iniCirrg" >
				</div>
				<div class="form-group col-md-3">
					<label for="local">Fim Cir�rgia:</label> <input type="time"
						class="form-control" 
						value="<% out.print(painel.getFimCirurgia()); %>"
						id="fimCirrg" >
				</div>
				<div class="form-group col-md-3">
					<label for="local">Sa�da Prevista:</label> <input type="time"
						class="form-control" 
						value="<% out.print(painel.getSaidaPrevista()); %>"
						id="saiPrev" >
				</div>
			</div>
			<button type="button" class="btn btn-secondary" onclick="novo()">Novo</button>
			<button type="button" class="btn btn-primary" onclick="gravar()">Gravar</button>
			<button type="button" class="btn btn-danger" onclick="apagar()">Apagar</button>
		</form>
	</div>


</body>
</html>