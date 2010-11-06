
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<div id="page">
    <div id="content">
        <div class="post">
            <h3 class="title"><a href="#">Resultado</a></h3>
            <div class="entry">
                        <c:forEach var="res" items="${Resultado}">
                        <sql:query var="autor" dataSource="jdbc/mc536">
                            select Nome from Autor where ID = ANY (select IDAutor from AutorDoc where IDDoc = ${res.id})
                        </sql:query>
                        <h2><a href="detalhes.jsp?doc=${res.id}">${res.titulo}</a></h2>
                        <ul>
                            <c:forEach var="row" items="${autor.rows}">
                            <li>${row.Nome}</li>
                            </c:forEach>
                            <li>${res.assunto}</li>
                        </ul>
                        </c:forEach>
            </div>
	</div>
    </div>
  <!-- end #content -->
  <jsp:include page="sidebarHome.jsp"></jsp:include>
  <div style="clear: both;">&nbsp;</div>
<!-- end #page -->
