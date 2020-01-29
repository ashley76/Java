<html>
<head>
<!-- Ashley's Example of IF -->
<title> Ashley JSP Decision 1</title>
</head>
<body>
<h1>Decision 1</h1>
<%
	boolean hello = true;
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