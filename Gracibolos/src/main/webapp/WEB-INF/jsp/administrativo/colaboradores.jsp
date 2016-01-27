<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="PT-BR">
<head>

	<!-- Defenição dos arquivos meta -->
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<!-- Importação dos arquivos CSS -->
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link href="resources/css/bootstrap.css" rel="stylesheet">
	<link href="resources/css/reset.css" rel="stylesheet">
	<link href="resources/css/style.css" rel="stylesheet">
    <link href="resources/css/datatables.css" rel="stylesheet">

	<!-- Titulo da página -->
	<title>Graci Bolos | Colaboradores</title>

</head>

<body>

	<!-- Container com layout fluido, preenchendo maior parte da tela -->
	<div class="container-fluid fullheight">

		<!-- Cria uma linha para armazenar todo o conteudo -->
		<div class="row fullheight">
			
			<!-- Barra de navegação Mobile e desktop -->
			<%@ include file="menu.jsp" %>
			
			<div class="content fullpage col-xs-12 col-sm-12 col-md-9 col-lg-9">
				<div class="margin-top">

					<!-- Titulo e subtitulo da pagina -->
					<header>
						<h2 class="">Colaboradores</h2>
						<h4 class="">Lista de colaboradores</h4>
					</header>

					<hr/>

					<!-- ########## CONTEUDO ########## -->

					<div class="row">
						<div class="input-margin col-xs-12 col-sm-12 col-md-12 col-md-lg-6">
							<label class="control-label">Pesquisar cliente:</label>
							<form action="administrativo-procurar-colaborador" method="POST">
								<div class="input-group">
									<input type="text" class="form-control" maxlength="100" placeholder="Informe o nome, CPF ou RG para realizar a pesquisa." name="pesquisa" id="pesquisa" required />
									<span class="input-group-btn">
										<button class="btn btn-default" type="submit"><span class="glyphicon glyphicon-search disabled"></span></button>
									</span>
								</div>
							</form>
						</div>
					</div>
					

					<div class="row">
						<div class="input-margin col-xs-12 col-sm-12 col-md-12 col-md-lg-6">
							<table id="colaboradores" class="table table-hover display" cellspacing="0" width="100%">
								<thead>
									<tr>
										<th>#</th>
										<th>Status</th>
										<th>Usuário</th>
										<th>Senha</th>
										<th>Nível</th>
										<th>Nome</th>
										<th>CPF / CNPJ</th>
										<th>RG / IE</th>
										<th>Endereço</th>
										<th>Nº</th>
										<th>Complemento</th>
										<th>Bairro</th>
										<th>Estado</th>
										<th>Cidade</th>
										<th>CEP</th>
										<th>Telefone</th>
										<th>Celular</th>
										<th>E-mail</th>
										<th>Observaçoes</th>
										<th>Ações</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="colaborador" items="${colaboradores}">
										<tr>
											<td>${colaborador.id}</td>
											<td>${colaborador.status}</td>
											<td>${colaborador.usuario}</td>
											<td>${colaborador.senha}</td>
											<td>${colaborador.nivel}</td>
											<td>${colaborador.nome}</td>
											<td>${colaborador.cpf}</td>
											<td>${colaborador.rg}</td>
											<td>${colaborador.endereco}</td>
											<td>${colaborador.numero}</td>
											<td>${colaborador.complemento}</td>
											<td>${colaborador.bairro}</td>
											<td>${colaborador.estado}</td>
											<td>${colaborador.cidade}</td>
											<td>${colaborador.cep}</td>
											<td>${colaborador.tel}</td>
											<td>${colaborador.cel}</td>
											<td>${colaborador.email}</td>
											<td>${colaborador.obs}</td>
		                					<td>
		                						<button id="edit" class="btn btn-xs btn-default"><i class="material-icons font-xs">mode_edit</i></button>
		                						<button id="delete" class="btn btn-xs btn-default"><i class="material-icons font-xs">clear</i></button>
		                					</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>

					<div class="row">
						<div class="input-margin pull-right col-xs-12 col-sm-5 col-md-3">
							<a href="" data-toggle="modal" data-target="#incluir-colaborador" class="btn btn-default fullwidth"><i class="material-icons">add</i>&nbsp;&nbsp;&nbsp;Incluir novo colaborador</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	




	<!--

	############################ MODAL DE INCLUSÃO DE NOVO COLABORADOR ############################

	-->
	<div class="modal fade" id="incluir-colaborador" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog modal-lg" role="document">
	    <div class="modal-content">
	    	
	    	<form action="" method="POST">
	    
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h3>COLABORADORES</h3>
				<h4>Incluir novo colaborador</h4>
		      </div>
		      <div class="modal-body">
		        <!-- ########## CONTEUDO ########## -->
					<div class="row">

						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">

							<form action="#" method="POST">
								
								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									<label class="control-label" for="id">Nº colaborador:</label>
									<input type="text" id="id" name="id" placeholder="Digite o numero de ID" class="form-control" disabled="true" />
								</div>

								<div class="input-margin col-xs-6 col-sm-6 col-md-3">
									<label class="control-label" for="status">Status:</label>
									<select id="status" name="status" class="form-control" required/>
										<option selected value="1">Ativado</option>
										<option value="0">Desativado</option>
									</select>
								</div>

								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									<label class="control-label" for="telefone">Usuario*:</label>
									<input type="text" id="usuario" name="usuario" placeholder="Digite o seu usuário" class="form-control" maxlength="20" required/>
								</div>

								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									<label class="control-label" for="celular">Senha*:</label>
									<input type="password" id="senha" name="senha" placeholder="Senha" class="form-control" maxlength="20" required/>
								</div>

								<div class="input-margin col-xs-12 col-sm-12 col-md-6">
									<label class="control-label" for="nome" id="nome_lbl">Nome*:</label>
									<input type="text" id="nome" name="nome" placeholder="Digite seu nome aqui" class="form-control" maxlength="100" required/>
								</div> 

								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									<label class="control-label" for="cpfcnpj" id="cpfcnpj_lbl">CPF*:</label>
									<input type="text" id="cpfcnpj" name="cpfcnpj" placeholder="000.000.000-00" class="form-control" maxlength="14" required/>
								</div>

								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									<label class="control-label" for="rgie" id="rgie_lbl">RG:</label>
									<input type="text" id="rgie" name="rgie" placeholder="00.000.000-0" class="form-control" maxlength="12"/>
								</div>

								<div class="input-margin col-xs-12 col-sm-9 col-md-4">
									<label class="control-label" for="endereco">Endereço*:</label>
									<input type="text" id="endereco" name="endereco" placeholder="Digite aqui o seu endereço" class="form-control" maxlength="120" required/>
								</div>

								<div class="input-margin col-xs-12 col-sm-3 col-md-2">
									<label class="control-label" for="numero">Numero*:</label>
									<input type="text" id="numero" name="numero" placeholder="Digite seu numero" class="form-control" required/>
								</div>

								<div class="input-margin col-xs-12 col-sm-6 col-md-6">
									<label class="control-label" for="complemento">Complemento:</label>
									<input type="text" id="complemento" name="complemento" placeholder="Digite o complemento se houver" class="form-control" maxlength="120"/>
								</div>

								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									<label class="control-label" for="bairro">Bairro*:</label>
									<input type="text" id="bairro" name="bairro" placeholder="Digite seu bairro" class="form-control" maxlength="60" required/>
								</div>

								<div class="input-margin col-xs-12 col-sm-2 col-md-3">
									<label class="control-label" for="estado">Estado*:</label>
									<select class="form-control" id="estado" name="estado" required/>
										<c:forEach var="estado" items="${estados}">
											<option value="${estado.id}">${estado.sigla}</option>
										</c:forEach>
									</select>
								</div>

								<div class="input-margin col-xs-12 col-sm-4 col-md-4">
									<label class="control-label" for="cidade">Cidade*:</label>
									<select class="form-control" id="cidade" name="cidade" required/>
										<c:forEach var="cidade" items="${cidades}">
											<option value="${cidade.id}">${cidade.nome}</option>
										</c:forEach>
									</select>
								</div>

								<div class="input-margin col-xs-12 col-sm-6 col-md-2">
									<label class="control-label" for="cep">CEP*:</label>
									<input type="text" id="cep" name="cep" placeholder="Digite seu CEP" class="form-control" maxlength="8" required/>
								</div>

								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									<label class="control-label" for="tel">Tel:</label>
									<input type="text" id="tel" name="tel" placeholder="(00) 0000-0000" class="form-control" maxlength="10"/>
								</div>

								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									<label class="control-label" for="cel">Cel:</label>
									<input type="text" id="cel" name="cel" placeholder="(00) 00000-0000" class="form-control" maxlength="11" />
								</div>

								<div class="input-margin col-xs-12 col-sm-6 col-md-6">
									<label class="control-label" for="email">E-mail:</label>
									<input type="text" id="email" name="email" class="form-control" placeholder="email@provedor.com.br" maxlength="120"/>
								</div>

								<div class="input-margin col-xs-12 col-sm-12 col-md-12">
									<label class="control-label" for="obs">Observações:</label>
									<textarea id="obs" name="obs" class="form-control" placeholder="Insira uma observação sobre o colaborador"></textarea>
								</div>

							</form>
							
						</div>
					</div>
				<!-- ########## FIM DO CONTEUDO ########## -->
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal"><i class="material-icons">close</i>&nbsp;&nbsp;&nbsp;Fechar</button>
		        <button type="submit" class="btn btn-default"><i class="material-icons">done_all</i>&nbsp;&nbsp;&nbsp;Incluir colaborador</button>
		      </div>
	      </form>
	      
	    </div>
	  </div>
	</div>








	<!--

	############################ MODAL DE ALTERAÇÃO COLABORADOR ############################

	-->
	<div class="modal fade" id="alterar-colaborador" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog modal-lg" role="document">
	    <div class="modal-content">
	    	
	    	<form action="" method="POST">
	    
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h3>COLABORADORES</h3>
				<h4>Alterar colaborador</h4>
		      </div>
		      <div class="modal-body">
		        <!-- ########## CONTEUDO ########## -->
					<div class="row">

						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">

							<form action="#" method="POST">
								
								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									<label class="control-label" for="id">Nº colaborador:</label>
									<input type="text" id="edit_id" name="id" placeholder="" class="form-control" disabled="true" />
								</div>

								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									<label class="control-label" for="status">Status:</label>
									<select id="edit_status" name="status" class="form-control" required/>
										<option selected value="1">Ativado</option>
										<option value="0">Desativado</option>
									</select>
								</div>

								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									<label class="control-label" for="usuario">Usuario*:</label>
									<input type="text" id="edit_usuario" name="usuario" placeholder="Digite o seu usuário" class="form-control" maxlength="20" required/>
								</div>

								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									<label class="control-label" for="celular">Senha*:</label>
									<input type="password" id="edit_senha" name="senha" placeholder="Senha" class="form-control" maxlength="20" required/>
								</div>

								<div class="input-margin col-xs-12 col-sm-12 col-md-6">
									<label class="control-label" for="nome" id="nome_lbl">Nome*:</label>
									<input type="text" id="edit_nome" name="nome" placeholder="Digite seu nome aqui" class="form-control" maxlength="100" required/>
								</div> 

								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									<label class="control-label" for="cpfcnpj" id="cpfcnpj_lbl">CPF*:</label>
									<input type="text" id="edit_cpfcnpj" name="cpfcnpj" placeholder="000.000.000-00" class="form-control" maxlength="14" required/>
								</div>

								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									<label class="control-label" for="rgie" id="rgie_lbl">RG:</label>
									<input type="text" id="edit_rgie" name="rgie" placeholder="00.000.000-0" class="form-control" maxlength="12"/>
								</div>

								<div class="input-margin col-xs-12 col-sm-9 col-md-4">
									<label class="control-label" for="endereco">Endereço*:</label>
									<input type="text" id="edit_endereco" name="endereco" placeholder="Digite aqui o seu endereço" class="form-control" maxlength="120" required/>
								</div>

								<div class="input-margin col-xs-12 col-sm-3 col-md-2">
									<label class="control-label" for="numero">Numero*:</label>
									<input type="text" id="edit_numero" name="numero" placeholder="Digite seu numero" class="form-control" required/>
								</div>

								<div class="input-margin col-xs-12 col-sm-6 col-md-6">
									<label class="control-label" for="complemento">Complemento:</label>
									<input type="text" id="edit_complemento" name="complemento" placeholder="Digite o complemento se houver" class="form-control" maxlength="120"/>
								</div>

								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									<label class="control-label" for="bairro">Bairro*:</label>
									<input type="text" id="edit_bairro" name="bairro" placeholder="Digite seu bairro" class="form-control" maxlength="60" required/>
								</div>

								<div class="input-margin col-xs-12 col-sm-2 col-md-3">
									<label class="control-label" for="estado">Estado*:</label>
									<select class="form-control" id="edit_estado" name="estado" required/>
										<c:forEach var="estado" items="${estados}">
											<option value="${estado.id}">${estado.sigla}</option>
										</c:forEach>
									</select>
								</div>
								
								<div class="input-margin col-xs-12 col-sm-4 col-md-4">
									<label class="control-label" for="cidade">Cidade*:</label>
									<select class="form-control" id="edit_cidade" name="cidade" required/>
										<c:forEach var="cidade" items="${cidades}">
											<option value="${cidade.id}">${cidade.nome}</option>
										</c:forEach>
									</select>
								</div>

								<div class="input-margin col-xs-12 col-sm-6 col-md-2">
									<label class="control-label" for="cep">CEP*:</label>
									<input type="text" id="edit_cep" name="cep" placeholder="Digite seu CEP" class="form-control" maxlength="8" required/>
								</div>

								<div class="clearfix"></div>

								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									<label class="control-label" for="tel">Tel:</label>
									<input type="text" id="edit_tel" name="tel" placeholder="(00) 0000-0000" class="form-control" maxlength="10"/>
								</div>

								<div class="input-margin col-xs-12 col-sm-6 col-md-3">
									<label class="control-label" for="cel">Cel:</label>
									<input type="text" id="edit_cel" name="cel" placeholder="(00) 00000-0000" class="form-control" maxlength="11" />
								</div>

								<div class="input-margin col-xs-12 col-sm-6 col-md-6">
									<label class="control-label" for="email">E-mail:</label>
									<input type="text" id="edit_email" name="email" class="form-control" placeholder="email@provedor.com.br" maxlength="120"/>
								</div>

								<div class="clearfix"></div>

								<div class="input-margin col-xs-12 col-sm-12 col-md-12">
									<label class="control-label" for="obs">Observações:</label>
									<textarea id="edit_obs" name="obs" class="form-control" placeholder="Insira uma observação sobre o colaborador"></textarea>
								</div>

							</form>
							
						</div>
					</div>
				<!-- ########## FIM DO CONTEUDO ########## -->
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal"><i class="material-icons">close</i>&nbsp;&nbsp;&nbsp;Fechar</button>
		        <button type="submit" class="btn btn-default"><i class="material-icons">done_all</i>&nbsp;&nbsp;&nbsp;Salvar alterações</button>
		      </div>
	      
	      </form>
	      
	    </div>
	  </div>
	</div>




	<!--

	############################ MODAL DE EXCLUSÃO DE COLABORADOR ############################

	-->



	<!-- Modal de confirmação de exclusão de cliente -->
	<div class="modal fade" id="excluir-colaborador" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">Excluir colaborador</h4>
	      </div>
	      <div class="modal-body">
	        <div>
	        	<p>Deseja realmente excluir o colaborador?</p>
	        </div>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Não, quero excluir</button>
			<a href="" id="excluirColaborador" class="btn btn-default">Sim, quero excluir</a>
	      </div>
	    </div>
	  </div>
	</div>

	<!-- ########## FIM DO CONTEUDO ########## -->



	<!-- Importação dos arquivos java script -->
	<script src="resources/js/jquery-2.1.4.js"></script>
	<script src="resources/js/datatables.js"></script>
	<script src="resources/js/bootstrap.js"></script>
    

	<script type="text/javascript">
		$(document).ready(function() {
            var table = $('#colaboradores').DataTable({
                "columnDefs": [
                    {
                        "targets": [ 0, 1, 2, 3, 4, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18 ],
                        "visible": false
                    }
                ]
            });

            $('#colaboradores tbody').on( 'click', '#edit', function () {
                var data = table.row( $(this).parents('tr') ).data();

	                $('#alterar-colaborador').modal('show');

	                $('#edit_id').val(data[0]);
	                $('#edit_status').val(data[1]);
	                $('#edit_usuario').val(data[2]);
	                $('#edit_senha').val(data[3]);
	                $('#edit_nivel').val(data[4]);
					$('#edit_nome').val(data[5]);
					$('#edit_cpfcnpj').val(data[6]);
	                $('#edit_rgie').val(data[7]);
	                $('#edit_endereco').val(data[8]);
	                $('#edit_numero').val(data[9]);
					$('#edit_complemento').val(data[10]);
					$('#edit_bairro').val(data[11]);
					$('#edit_estado').val(data[12]);
	                $('#edit_cidade').val(data[13]);
	                $('#edit_cep').val(data[14]);
	                $('#edit_tel').val(data[15]);
					$('#edit_cel').val(data[16]);
	                $('#edit_email').val(data[17]);
					$('#edit_obs').val(data[18]);

            } );

            $('#colaboradores tbody').on( 'click', '#delete', function () {
                var data = table.row( $(this).parents('tr') ).data();

				$('#excluir-colaborador').modal('show');

                alert("Deletar linha " + data[0]);
            } );

        } );

	</script>
	
	<script type="text/javascript">
		var combo_estado = $('#edit_estado');
		var combo_cidade = $('#edit_cidade');
		
		combo_estado.change(function(){
			$.ajax({
	            url : 'administrativo-pesquisar-cidade',
	            method: "POST",
	            data: {id:combo_estado.val()},
	            success : function(data) {
		            
	            	combo_cidade.find('option').remove();

	            	$.each(data, function(val, cidade){
						combo_cidade.append($('<option></option>').val(cidade.id).html(cidade.nome));
					});

	            }
	        });
			
		});
	</script>
	
</body>
</html>