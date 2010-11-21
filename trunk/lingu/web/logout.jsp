<div id="page">
    <div id="content">
        <div class="post">
            <h3 class="title"><a href="#">Logout</a></h3>
            <div class="entry">
                <%
                    session.invalidate();
                %>
                <ul>
                    <li>Você foi desconectado.</li>
                    <li><a href="index.jsp">Clique aqui para voltar!</a></li>
                </ul>
            </div>
	</div>
    </div>
  <!-- end #content -->
  <jsp:include page="sidebarLogin.jsp"></jsp:include>
  <div style="clear: both;">&nbsp;</div>
<!-- end #page -->
