<html>
<head>
<!-- Ashley's Example of IF -->
<title> Ashley JSP Decision 2</title>
</head>
<body>
<h1>Decision 2</h1>
<%
	boolean hello = false;
    if ( hello ) {
        %>
        <P>Hello, world
        <%
    } else {
        %>
        <P>Goodbye, world
        <%
    }
%>
</body>
</html> 