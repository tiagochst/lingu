
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<sql:query var="doc" dataSource="jdbc/mc536">
  select * from Documento where ID = ${param.doc}
</sql:query>

<sql:query var="autDado" dataSource="jdbc/mc536">
  select Nome from Autor where ID = ANY (select IDAutor from AutorDoc where IDDoc = ${param.doc})
</sql:query>

<sql:query var="comments" dataSource="jdbc/mc536">
  select * from Comentario where IDDoc = ${param.doc} ORDER BY Data DESC LIMIT 5
</sql:query>

<div id="page">
  <div id="content">
    <div class="post">
      <h3 class="title"><a href="#">Detalhes</a></h3>
      <div class="entry">
        <c:forEach var="row" items="${doc.rows}">
          <h2>${row.Titulo}</h2>
          <ul>
            <c:forEach var="autor" items="${autDado.rows}">
              <li><b>Autor:</b> ${autor.Nome}</li>
            </c:forEach>
            <li><b>Assunto:</b> ${row.Assunto}</li>
            <li><b>Descri��o:</b> ${row.Descricao}</li>
            <li><b>Data:</b> ${row.DataInsercao}</li>
            <li><b>Visualiza��es:</b> ${row.NumAcessos+1}</li>
            <li><a href="upload/${row.Id}${row.Extensao}"><b>Baixar!</b></a>
          </ul>
          <sql:update dataSource="jdbc/mc536">
            update Documento SET NumAcessos = ${row.NumAcessos+1} where ID = ${param.doc}
          </sql:update>
        </c:forEach>
        <a href="#" onclick="return showForm();"><h4 align="right">Comentar</h4></a>
        <form id="commentForm" name="commentForm" action="ControllerServlet" method="POST" style="display:none">
          <table align="center">
            <tbody>
              <tr>
                <td>Nome: </td>
                <td><INPUT type="text" name="NomeComentario" size="30" maxlength="60" alt="Nome do usu�rio."></td>
              </tr>
              <tr>
                <td valign="top">Coment�rio: </td>
                <td><textarea name="Comentario" rows="4" cols="34" alt="Coment�rio."></textarea></td>
              </tr>
              <tr>
                <td></td>
                <td align="left"><INPUT type="submit" name="Enviar" value="Enviar" alt="Enviar coment�rio.">
                  <INPUT type="reset" name="Cancelar" value="Cancelar" onclick="return hideForm();" alt="Cancelar coment�rio.">
                  <INPUT type="hidden" name="DocId" value="${param.doc}"></td>
              </tr>
            </tbody>
          </table>
        </form>
        <c:forEach var="comment" items="${comments.rows}">
          <ul>
            <li><b>${comment.AutorCom}</b> - ${comment.Data}</li>
            <ul><li>${comment.Texto}</li></ul>
          </ul>
        </c:forEach>
      </div>
    </div>
  </div>
  <!-- end #content -->
  <jsp:include page="sidebarHome.jsp"></jsp:include>
  <div style="clear: both;">&nbsp;</div>
  <!-- end #page -->
