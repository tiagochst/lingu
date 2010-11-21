
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<div id="page">
  <div id="content">
    <div class="post">
      <h3 class="title"><a href="#">Busca</a></h3>
      <div class="entry" align="center">
        <FORM action="SearchControllerServlet" method="POST">
          <table align="center">
            <tbody>
              <tr>
                <td align="center"><INPUT type="text" name="Titulo" size="30" alt="Busca por t�tulo."></td>
                <td align="center"><INPUT type="submit" name="Buscar" value="Buscar"></td>
              </tr>
            </tbody>
          </table>
        </FORM>
        <table align="center">
          <tbody>
            <tr>
              <td align="center"><a href="buscaAvancada.jsp">Busca avan�ada</a></td>
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
