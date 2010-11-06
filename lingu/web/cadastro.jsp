
	<div id="page">
		<div id="content">

			<div class="post">
				<h2 class="title"><a href="#">Lorem ipsum sed aliquam</a></h2>
				<p class="meta"><span class="author"><a href="#">Someone</a></span> <span class="date">July 07, 2010</span>&nbsp;<span class="links"><a href="#" title="">Comments</a></span></p>
				<div class="entry">


        <FORM action="ControllerServlet" method="POST">
	  <table>
	    <tbody>
	      <tr>
		<td>Nome</td>
		<td>  <INPUT type="text" name="Nome" size="20" maxlength="50" alt="Nome Completo">
		</td>
	      </tr>
	      <tr>
		<td>Senha</td>
		<td>  <INPUT type="password" name="Senha" size="20" maxlength="50" alt="Senha de acesso">
		</td>
	      </tr>
	      <tr>
		<td>Tipo</td>
		<td>

		  <SELECT name="Tipo" >
		    <option>Palestrante</option>
		    <option>Participante</option>
		  </SELECT>
		</td>
	      </tr>
	      <tr>
		<td>Email</td>
		<td> <INPUT type="text" name="Email" size="20" maxlength="60" alt="Email profissional">
		</td>
	      </tr>
	      <tr>
		<td>RG</td>
		<td> <INPUT type="text" name="RG" size="20" maxlength="15" alt="RG">
		</td>
	      </tr>
	      <tr>
		<td>Data de Nascimento</td>
		<td>
		  <INPUT type="text" name="Dia" size="2" maxlength="2" alt="Dia de nascimento">/
		  <INPUT type="text" name="Mes" size="2" maxlength="2" alt="Mes de nascimento">/
		  <INPUT type="text" name="Ano" size="4" maxlength="4" alt="Ano de nascimento">
		</td>
	      </tr>
	      <tr>
		<td>Pais</td>
		<td>  <INPUT type="text" name="Pais" size="20" maxlength="15" alt="Pais de nascimento">
		</td>
	      </tr>
	      <tr>
		<td></td>
		<td><INPUT type="submit" name="Enviar" value="Cadastrar">
		</td>
	      </tr>

	    </tbody>
	  </table>
	</FORM>
   
	</div>
			</div>
		
		</div>
		<!-- end #content -->

<jsp:include page="sidebar.jsp"></jsp:include>
			<div style="clear: both;">&nbsp;</div>
	</div>
	<!-- end #page -->
</div>
