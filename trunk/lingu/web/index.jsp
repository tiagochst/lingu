
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<sql:query var="paises" dataSource="jdbc/mc536">
  SELECT Pais, COUNT(*) FROM DocUsuario LEFT JOIN Usuario ON DocUsuario.IDUSER=Usuario.ID group by IDUSER order by COUNT(*) desc limit 1
</sql:query>

<div id="page">
  <div id="content">
    <div class="post">
      <h3 class="title"><a href="#">Busca</a></h3>
      <div class="entry" align="center">
        <FORM action="SearchControllerServlet" method="POST">
          <table align="center">
            <tbody>
              <tr>
                <td align="center"><INPUT type="text" name="Titulo" size="30" alt="Busca por título."></td>
                <td align="center"><INPUT type="submit" name="Buscar" value="Buscar"></td>
              </tr>
            </tbody>
          </table>
        </FORM>
        <table align="center">
          <tbody>
            <tr>
              <td align="center"><a href="buscaAvancada.jsp">Busca avançada</a></td>
            </tr>
            <tr>
                <c:forEach var="pais" items="${paises.rows}">
                    <td align="center"><a href="mapa.jsp?pais=${pais.Pais}">Mapa</a></td>
                </c:forEach>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
  <!-- end #content -->
  <jsp:include page="sidebarHome.jsp"></jsp:include>
  <div style="clear: both;">&nbsp;</div>
</div>
<!-- end #page -->
