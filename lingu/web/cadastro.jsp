<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>


    <sql:query var="rede" dataSource="jdbc/mc536">
        SELECT ID,NOME FROM RedeDeTrabalho
    </sql:query>


	<div id="page">
		<div id="content">
		<div class="post">
				<h2 class="title"><a href="#">Cadastro de Usuário</a></h2>
				<div class="entry">

   <FORM action="ControllerServlet" method="POST">
	  <table>
	    <tbody>
	      <tr>
		<td>Nome</td>
		<td>  <INPUT type="text" name="Nome" size="20" maxlength="60" alt="Nome Completo">
		</td>
	      </tr>
	      <tr>
		<td>Senha</td>
		<td>  <INPUT type="password" name="Senha" size="20" maxlength="12" alt="Senha de acesso">
		</td>
	      </tr>
	      <tr>
		<td>Tipo</td>
		<td>

		  <SELECT name="Tipo" >
		    <option>Normal</option>
		    <option>Universidade</option>
                    <option>Instituição</option>
               </SELECT>
		</td>
	      </tr>
	      <tr>
		<td>Email</td>
		<td> <INPUT type="text" name="Email" size="20" maxlength="60" alt="Email profissional">
		</td>
	      </tr>
	      <tr>
		<td>País</td>
		<td> <INPUT type="text" name="pais" size="20" maxlength="60" alt="RG">
		</td>
	      </tr>
	      <tr>
		<td>Pais</td>
		<td>  <INPUT type="text" name="Pais" size="20" maxlength="15" alt="Pais de nascimento">
		</td>
	      </tr>
<tr>
          <td>  <strong>Selecione uma palestra:</strong></td><td>
    <select name="idRede">
        <c:forEach var="row" items="${rede.rows}">
            <option value="${row.ID}">${row.nome}</option>
        </c:forEach>
    </select>
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
