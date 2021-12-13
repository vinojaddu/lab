
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>
<head>
<title>Displaying Student Mark List</title>
</head>
<body>
<center> <h2> HERE YOU WITH THE MARK DETAILS OF ${param.s_branch}
DEPARTMENT STUDENTS!</h2>
<h1> STUDENT MARK LIST </h1> </center>

<c:set var ="branch" value = "${param.s_branch}"/>

<sql:setDataSource var="snapshot" driver="org.apache.derby.jdbc.ClientDriver"
url="jdbc:derby://localhost:1527/a" user="kavi" password="123"/>

<sql:query dataSource="${snapshot}" var="result">
SELECT * from KAVI.STUDENT where BRANCH=?
<sql:param value = "${branch}" />
</sql:query>
<table border="1" width="100%">
<tr>
<th>REGNO</th>
<th>Name</th>
<th>BATCH</th>
<th>BRANCH</th>
<th>SECTION</th>
<th>SUB1</th>
<th>SUB2</th>
<th>SUB3</th>
<c:forEach var="row" items="${result.rows}">
<tr>
<td><c:out value="${row.REGNO}"/></td>
<td><c:out value="${row.NAME}"/></td>
<td><c:out value="${row.BATCH}"/></td>
<td><c:out value="${row.BRANCH}"/></td>
<td><c:out value="${row.SECTION}"/></td>
<td><c:out value="${row.WT}"/></td>
<td><c:out value="${row.CN}"/></td>
<td><c:out value="${row.GIS}"/></td>
</tr>
</c:forEach>
</table>
</body>
</html>