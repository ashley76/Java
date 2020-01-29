<html>
<head>
<!-- Ashley's Example of JSP Expressions and Scriplets -->
<title> Ashley JSP Loop 1</title>
</head>
<body>
<h1>Loop 1</h1>
	<TABLE BORDER=2>
<%
	int n=5; 
    for ( int i = 0; i < n; i++ ) {
        %>
        <TR>
        <TD>Number</TD>
        <TD><%= i+1 %></TD>
        </TR>
        <%
    }
%>
</TABLE>
</body>
</html>