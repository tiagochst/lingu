<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>


    <sql:query var="prog" dataSource="jdbc/mc536">
        select ID,Nome from PgmMultilinguistico
    </sql:query>
        <sql:query var="doc" dataSource="jdbc/mc536">
            SELECT ID,Titulo FROM Documento
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
		<td>Documento</td>
                <td>
                    <input type="file" name="Upload" value="" width="2000" />
                  </td>
	      </tr>
                  <tr>
		<td>Titulo</td>
		<td> <INPUT type="text" name="Titulo" size="20" maxlength="60" alt="Lingua da descrição">
		</td>
	      </tr>
	      <tr>
		<td>Assunto</td>
                <td><textarea name="Assunto" rows="4" cols="20">
                    </textarea>
                  </td>
	      </tr>
	      <tr>
		<td>Descrição</td>
                <td><textarea name="Descricao" rows="4" cols="20">
                    </textarea>
                  </td>
	      </tr>
	      <tr>
		<td>Palavras-chave</td>
                <td><textarea name="Chaves" rows="4" cols="20">
                    </textarea>
                  </td>
	      </tr>
	      <tr>
		<td>Tipo</td>
		<td>

		  <SELECT name="Tipo" >
		    <option value="0">Artigo jornalístico</option>
		    <option value="1">Artigo científico</option>
                    <option value="2">Texto reinvidicatório</option>
                     <option value="3">Acordos</option>
                    <option value="4">Acordos</option>
                   <option value="5">Declarações</option>
                    <option value="6">Sugestões</option>
                        <option value="7">Outros</option>
               </SELECT>
		</td>
	      </tr>
	      <tr>
		<td>Língua descrição</td>
		<td> <INPUT type="text" name="LinguaDescricao" size="20" maxlength="30" alt="Lingua da descrição">
		</td>
	      </tr>
	      <tr>
		<td>País</td>
		<td> <INPUT type="text" name="Pais" size="20" maxlength="60" alt="Pais do utilizador">
		</td>
	      </tr>
	      <tr>
		<td>Lingua Oficial </td>
		<td>  <INPUT type="text" name="LinguaOficial" size="20" maxlength="30" alt="Lingua oficial">
		</td>
	      </tr>
                   <tr>
		<td>Lingua Utilizador </td>
		<td>  <INPUT type="text" name="LinguaUtilizador" size="20" maxlength="30" alt="Lingua do utilizador">
		</td>
	      </tr>
                             <tr>
		<td>Lingua Palavra chaves </td>
		<td>  <INPUT type="text" name="LinguaChave" size="20" maxlength="30" alt="Lingua das palavras chaves">
		</td>
	      </tr>
              <%--<tr>
          <td>  Documento resposta:</td><td>
    <select name="DocResp">
             <option value="0">Não é resposta</option>
        <c:forEach var="row" items="${doc.rows}">
            <option value="${row.ID}">${row.Titulo}</option>
        </c:forEach>
    </select>
              	</td>
	      </tr>
              --%>
              <tr>
          <td>  Programa multilinguismo:</td><td>
                  <select name="MultiLing" multiple size="5">
             <option value="0" selected>Nenhum programa</option>
        <c:forEach var="row" items="${prog.rows}">
            <option value="${row.ID}">${row.Titulo}</option>
        </c:forEach>
    </select>
              	</td>
	      </tr>
              <tr>
		<td>Autor </td>
		<td>  <INPUT type="text" name="Autor" size="20" maxlength="60" alt="Autor documento">
		</td>
	      </tr>
        

              <tr>
		<td></td>
		<td><INPUT type="submit" name="Upload" value="Upload">
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
