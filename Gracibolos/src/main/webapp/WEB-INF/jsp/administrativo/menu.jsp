<!-- Cria a barra de naveção mobile, ela não aparece em telas medias e grandes -->
			<nav class="navbar navbar-transparent hidden-md hidden-lg">

				<div class="container-fluid">
					
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse" aria-expanded="false">
							<span class="glyphicon glyphicon-menu-hamburger disabled"></span>
						</button>
						<a class="navbar-brand" href="#"><img src="resources/img/logo.png" width="100px"></a>
					</div>

					<div class="collapse navbar-collapse" id="navbar-collapse">
						<ul class="nav navbar-nav">
							<li id="menu-mob-dashboard"><a href="administrativo-dashboard"><i class="material-icons">trending_up</i>&nbsp;&nbsp;Dashboard</a></li>
							<li id="menu-mob-encomendas"><a href="#"><i class="material-icons">chrome_reader_mode</i>&nbsp;&nbsp;Encomendas</a></li>
							<li id="menu-mob-clientes"><a href="administrativo-clientes"><i class="material-icons">people</i>&nbsp;&nbsp;Clientes</a></li>
							<li id="menu-mob-produtos"><a href="administrativo-produtos"><i class="material-icons">local_grocery_store</i>&nbsp;&nbsp;Produtos</a></li>
							<li id="menu-mob-materiasprimas"><a href="administrativo-materiasprimas"><i class="material-icons">cake</i>&nbsp;&nbsp;Matérias-primas</a></li>
							<li id="menu-mob-fornecedores"><a href="administrativo-fornecedores"><i class="material-icons">shopping_basket</i>&nbsp;&nbsp; Fornecedores</a></li>
							<li id="menu-mob-colaboradores"><a href="administrativo-colaboradores"><i class="material-icons">person</i>&nbsp;&nbsp;Colaboradores</a></li>
							<!-- O href está vazio para o botão não perder o tipo de ponteiro (Deixar assim) -->
							<li><a href="" data-toggle="modal" data-target="#myModal"><i class="material-icons">exit_to_app</i>&nbsp;&nbsp;Sair do sistema</a></li>
						</ul>
					</div>
					

				</div>
			</nav>
			<!-- Fim do menu de navegação mobile -->

			<!-- Cria a barra de naveção lateral, aparecendo somente em telas grandes -->
			<div class="hidden-xs hidden-sm col-md-3 col-lg-3 ">
				<div class="margin-top text-center logo">
					<img src="resources/img/logo.png" width="150px">
				</div>

				<ul class="nav nav-pills nav-stacked">
					<li id="menu-dashboard"><a href="administrativo-dashboard"><i class="material-icons">trending_up</i>&nbsp;&nbsp;Dashboard</a></li>
					<li id="menu-encomendas"><a href="#"><i class="material-icons">chrome_reader_mode</i>&nbsp;&nbsp;Encomendas</a></li>
					<li id="menu-clientes"><a href="administrativo-clientes"><i class="material-icons">people</i>&nbsp;&nbsp;Clientes</a></li>
					<li id="menu-produtos"><a href="administrativo-produtos"><i class="material-icons">local_grocery_store</i>&nbsp;&nbsp;Produtos</a></li>
					<li id="menu-materiasprimas"><a href="administrativo-materiasprimas"><i class="material-icons">cake</i>&nbsp;&nbsp;Matérias-primas</a></li>
					<li id="menu-fornecedores"><a href="administrativo-fornecedores"><i class="material-icons">shopping_basket</i>&nbsp;&nbsp; Fornecedores</a></li>
					<li id="menu-colaboradores"><a href="administrativo-colaboradores"><i class="material-icons">person</i>&nbsp;&nbsp;Colaboradores</a></li>
					<!-- O href está vazio para o botão não perder o tipo de ponteiro (Deixar assim) -->
					<li><a href="" data-toggle="modal" data-target="#myModal"><i class="material-icons">exit_to_app</i>&nbsp;&nbsp;Sair do sistema</a></li>
				</ul>
			</div>
			<!-- Fim da barra de naveção lateral -->
			
			
			<!-- Modal de logoff -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title" id="myModalLabel">Logoff</h4>
			      </div>
			      <div class="modal-body">
			        <div>
			        	<p>Deseja realmente sair do sistema?</p>
			        </div>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">Não, quero continuar</button>
					<a href="logout" class="btn btn-default">Sim, quero sair</a>
			      </div>
			    </div>
			  </div>
			</div>