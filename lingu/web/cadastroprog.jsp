<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>


<div id="page">
  <div id="content">
    <div class="post">
      <h2 class="title"><a href="#">Cadastro de Programa</a></h2>

      <div class="entry">
	
	<FORM action="ControllerServlet" method="POST">
	  <table>
	    <tbody>
	      <tr>
		<td>Nome: </td>
		<td>  <INPUT type="text" name="NomeProg" size="20" maxlength="60" alt="Nome Completo">
		</td>
	      </tr>
              <tr>
		<td>Lingua: </td>
		<td>  <INPUT type="text" name="Lingua" size="20" maxlength="15" alt="Lingua do utilizador">
		</td>
	      </tr>
              <tr>
                <td valign="top">Descrição: </td>
                <td><textarea name="Descricao" rows="4" cols="34" alt="Descrição do projeto."></textarea></td>
              </tr>
              <tr>
		<td></td>
		<td><INPUT type="submit" name="Enviar" value="NovoProg">
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
