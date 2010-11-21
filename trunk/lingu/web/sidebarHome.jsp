<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<sql:query var="topDocs" dataSource="jdbc/mc536">
  select * from Documento ORDER BY NumAcessos DESC LIMIT 5
</sql:query>


<sql:query var="prog" dataSource="jdbc/mc536">
  select * from PgmMultilinguistico where ID != 0 ORDER BY RAND()  LIMIT 3
</sql:query>

<div id="sidebar">
  <ul>
    <li>
      <h2>Mais buscados</h2>
      <ul>
        <c:forEach var="doc" items="${topDocs.rows}">
          <li><a href="detalhes.jsp?doc=${doc.ID}">${doc.Titulo}</a></li>
        </c:forEach>
      </ul>
    </li>

    <li>
      <h2>Programas multilinguísticos</h2>
      <ul>
        <c:forEach var="prog" items="${prog.rows}">
          <li>${prog.Nome}</li>
        </c:forEach>
        <li><a href="cadastroprog.jsp">+ Novo programa</a> </li>
      </ul>
    </li>
  </ul>
  
  
  
</div>
<!-- end #sidebar -->
