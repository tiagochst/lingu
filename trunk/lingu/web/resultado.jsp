
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="page">
    <div id="content">
        <div class="post">
            <h3 class="title"><a href="#">Busca</a></h3>
            <div class="entry">
                        <c:forEach var="res" items="${Resultado}">
                        <h2>${res.titulo}</h2>
                        <ul>
                            <li><a href="#">${res.assunto}</a></li>
                        </ul>
                        </c:forEach>
            </div>
	</div>
    </div>
  <!-- end #content -->
  <jsp:include page="sidebarHome.jsp"></jsp:include>
  <div style="clear: both;">&nbsp;</div>
<!-- end #page -->
