<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<div id="page">
  <div id="content">
    <div class="post">
      <h2 class="title"><a href="#">Cadastro de Autor</a></h2>
      <div class="entry">
	
	
	<FORM action="ControllerServlet" method="POST">
	  <table>
	    <tbody>
	      <tr>
		<td>Nome</td>
		<td>  <INPUT type="text" name="NomeAutor" size="30" maxlength="60" alt="Nome do Autor">
		</td>
	      </tr>
	      <tr>
		<td>País</td>
		<td>  <INPUT type="text" name="PaisAutor" size="30" maxlength="60" alt="País do Autor">
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
