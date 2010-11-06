
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="page">
    <div id="content">
        <div class="post">
            <h3 class="title"><a href="#">Busca</a></h3>
            <div class="entry">
                <table>
                    <tbody>
                        <c:forEach var="res" items="${Resultado}">
                            <tr>
                                <td>
                                    <h2>${res.titulo}</h2>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <h4>${res.assunto}</h4>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
	</div>
    </div>
  <!-- end #content -->
  <jsp:include page="sidebarHome.jsp"></jsp:include>
  <div style="clear: both;">&nbsp;</div>
<!-- end #page -->
