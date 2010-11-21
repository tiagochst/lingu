<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<sql:query var="topUsers" dataSource="jdbc/mc536">
  select IDUser, COUNT(*) from DocUsuario group by IDUser order  by COUNT(*) desc LIMIT 5;
</sql:query>

<sql:query var="prog" dataSource="jdbc/mc536">
  select * from PgmMultilinguistico where ID != 0 ORDER BY RAND()  LIMIT 3
</sql:query>

<div id="sidebar">
  <ul>
    <li>
      <h2>Mais ativos</h2>
      <ul>
        <c:forEach var="topUser" items="${topUsers.rows}">
            <sql:query var="users" dataSource="jdbc/mc536">
                select * from Usuario where ID=${topUser.IDUser}
            </sql:query>
            <c:forEach var="user" items="${users.rows}">
                <li>${user.Nome}</li>
            </c:forEach>
        </c:forEach>
      </ul>
    </li>

    <li>
      <h2>Programas multilinguísticos</h2>
      <ul>
        <c:forEach var="prog" items="${prog.rows}">
          <li>${prog.Nome}</li>
        </c:forEach>
        <li><a href="cadastroprog.jsp">+ Novo programa</a></li>
      </ul>
    </li>
  </ul>



</div>
<!-- end #sidebar -->
