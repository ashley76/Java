<%
   String name = request.getParameter( "username" );
   session.setAttribute( "theName", name );
%>
<HTML>
<head>
<!-- Ashley's Sessions -->
<title> Ashley JSP Session SaveName</title>
</head>
<BODY>
<A HREF="NextPage.jsp">Continue</A>
</BODY>
</HTML>