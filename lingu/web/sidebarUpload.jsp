<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<sql:query var="prog" dataSource="jdbc/mc536">
  select * from PgmMultilinguistico where ID != 0 ORDER BY RAND()  LIMIT 3
</sql:query>

<sql:query var="paises" dataSource="jdbc/mc536">
  SELECT Pais, COUNT(*) FROM DocUsuario LEFT JOIN Usuario ON DocUsuario.IDUSER=Usuario.ID group by IDUSER order by COUNT(*) desc limit 3
</sql:query>

<div id="sidebar">
    <ul>
    <li>
        <h2>Países que mais postam</h2>
        <ul>
            <c:forEach var="pais" items="${paises.rows}">
                <li><a href="mapa.jsp?pais=${pais.Pais}">${pais.Pais}</a></li>
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
