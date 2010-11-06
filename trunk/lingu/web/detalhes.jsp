
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>


<sql:query var="doc" dataSource="jdbc/mc536">
    select * from Documento where ID = ${param.doc}
</sql:query>

<sql:query var="autDado" dataSource="jdbc/mc536">
    select Nome from Autor where ID = ANY (select IDAutor from AutorDoc where IDDoc = ${param.doc})
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
                    <li><b>Descrição:</b> ${row.Descricao}</li>
                    <li><b>Data:</b> ${row.DataInsercao}</li>
                    <li><b>Visualizações:</b> ${row.NumAcessos+1}</li>
                    </ul>
                    <sql:update dataSource="jdbc/mc536">
                        update Documento SET NumAcessos = ${row.NumAcessos+1} where ID = ${param.doc}
                    </sql:update>
                </c:forEach>
            </div>
	</div>
    </div>
  <!-- end #content -->
  <jsp:include page="sidebarHome.jsp"></jsp:include>
  <div style="clear: both;">&nbsp;</div>
<!-- end #page -->