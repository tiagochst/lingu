<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>


<sql:query var="prog" dataSource="jdbc/mc536">
  select ID,Nome from PgmMultilinguistico
</sql:query>
<sql:query var="doc" dataSource="jdbc/mc536">
  SELECT ID,Titulo FROM Documento
</sql:query>
<sql:query var="aut" dataSource="jdbc/mc536">
  SELECT ID,Nome FROM Autor
</sql:query>


<div id="page">
  <div id="content">
    <div class="post">
      <h2 class="title"><a href="#">Upload de documento</a></h2>
      <div class="entry">
	
	
	<FORM action="ControllerServlet" ENCTYPE="multipart/form-data" method="POST">
	  <table>
	    <tbody>
	      <tr>
		<td>Documento</td>
		<td>
		  <input type="file" name="File" value="" />
		</td>
	      </tr>

	      <tr>
		<td></td>
		<td><INPUT type="submit" name="Upload" value="Upload">
		</td>
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
</div>
<!-- end #page -->
</div>
