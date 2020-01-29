<%@ page import="java.util.*" %>
<html>
<head>
<!-- Ashley's Example of Using Directives - with Loop2.jsp included file -->
<title> Ashley JSP Directive Example</title>
</head>
<body>
<h1>Hello World from Ashley</h1>
Hello! :)
<%
    System.out.println( "Evaluating date now" );
    Date date = new Date();
%>
Hello!  The time is now <%= date %> <BR>
Going to include loop2.jsp...<BR>
<%@ include file="loop2.jsp" %>
</body>
</html>