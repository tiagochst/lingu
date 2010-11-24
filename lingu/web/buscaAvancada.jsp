
<div id="page">
  <div id="content">
    <div class="post">
      <h3 class="title"><a href="#">Busca</a></h3>
      <div class="entry" align="center">
        <FORM action="SearchControllerServlet" method="POST">
          <table align="center">
            <tbody>
              <tr>
               <td width="10">Titulo:</td>
               <td align="center"><INPUT type="text" name="Titulo" size="30" alt="Busca por t?tulo."></td>
              </tr>
              <tr>
              </tr>
              <tr>
                  <td>Autor:</td>
                  <td align="center"><INPUT type="text" name="Autor" size="30" alt="Busca por autor."></td>
            </tr>
            <tr>
                <td>Pais:</td>
                <td align="center"><INPUT type="text" name="Pais" size="30" alt="Busca por Pa?s."></td>
            </tr>
            <tr>
                <td>Lingua oficial</td>
                <td align="center"><INPUT type="text" name="LinguaOficial" size="30" alt="Busca por lingua oficial."></td>
            </tr>
            <tr>
                <td>Lingua utilizador</td>
                <td align="center"><INPUT type="text" name="LinguaUtilizador" size="30" alt="Busca por lingua utilizador."></td>
	  </tr>
          <tr>
          <!--    <td>Tipo</td>
		<td>

		  <SELECT name="Tipo" >
		    <option value="0">Artigo jornal?stico</option>
		    <option value="1">Artigo cient?fico</option>
                    <option value="2">Texto reinvidicat?rio</option>
                    <option value="3">Acordos</option>
                    <option value="4">Livro</option>
                    <option value="5">Declara??es</option>
                    <option value="6">Sugest?es</option>
                    <option value="7">Outros</option>
                     <option value="8">Qualquer tipo</option>
		  </SELECT>
		</td>
  </tr> -->   <tr>
                <td align="center"><INPUT type="submit" name="BuscarAvancada" value="Buscar"></td>
              </tr>
            </tbody>
          </table>
        </FORM>
      </div>
    </div>
  </div>
  <!-- end #content -->
  <jsp:include page="sidebarHome.jsp"></jsp:include>
  <div style="clear: both;">&nbsp;</div>
</div>
<!-- end #page -->
