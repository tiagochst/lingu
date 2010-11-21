<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<sql:query var="prog" dataSource="jdbc/mc536">
  select * from PgmMultilinguistico where ID != 0 ORDER BY RAND()  LIMIT 3
</sql:query>

<sql:query var="paises" dataSource="jdbc/mc536">
  SELECT Pais, COUNT(*) FROM DocUsuario LEFT JOIN Usuario ON DocUsuario.IDUSER=Usuario.ID group by IDUSER order by COUNT(*) desc limit 3
</sql:query>

  <sql:query var="rede" dataSource="jdbc/mc536">
  select * from RedeDeTrabalho where ID != 0 ORDER BY RAND()  LIMIT 3
</sql:query>

<div id="sidebar">
    <ul>
    <li>
        <h2><fmt:message key='TopCountry'/></h2>
        <ul>
            <c:forEach var="pais" items="${paises.rows}">
                <li><a href="mapa.jsp?pais=${pais.Pais}">${pais.Pais}</a></li>
            </c:forEach>
        </ul>
    </li>

    <li>
      <h2><fmt:message key='pgm'/></h2>
      <ul>
        <c:forEach var="prog" items="${prog.rows}">
          <li>${prog.Nome}</li>
        </c:forEach>
        <li><a href="cadastroprog.jsp">+ <fmt:message key='NewPgm'/></a> </li>
      </ul>
    </li>

     <li>
      <h2><fmt:message key='network'/></h2>
      <ul>
        <c:forEach var="rede" items="${rede.rows}">
          <li>${rede.Nome}</li>
        </c:forEach>
        <li><a href="cadastrorede.jsp">+ <fmt:message key='NewNetwork'/></a> </li>
      </ul>
    </li>
  </ul>



</div>
<!-- end #sidebar -->
