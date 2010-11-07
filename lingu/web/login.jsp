
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<div id="page">
    <div id="content">
        <div class="post">
            <h3 class="title"><a href="#">Login</a></h3>
            <div class="entry">
                <FORM action="ControllerServlet" method="POST">
                    <table align="center">
                        <tbody>
                            <tr>
                                <td>E-mail: </td>
                                <td><INPUT type="text" name="Email" size="20" maxlength="60" alt="E-mail de usuário.">
                                </td>
                            </tr>
                            <tr>
                                <td>Senha: </td>
                                <td><INPUT type="password" name="Senha" size="20" maxlength="12" alt="Senha de usuário.">
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <table align="center">
                        <tbody>
                            <tr>
                                <td align="center"><INPUT type="submit" name="Entrar" value="Login" alt="Entrar no sistema."></td>
                            </tr>
                            <tr>
                                <td align="center"><a href="cadastro.jsp">Não sou cadastrado!</a></td>
                            </tr>
                        </tbody>
                    </table>
                </FORM>
            </div>
	</div>
    </div>
  <!-- end #content -->
  <jsp:include page="sidebar.jsp"></jsp:include>
  <div style="clear: both;">&nbsp;</div>
<!-- end #page -->