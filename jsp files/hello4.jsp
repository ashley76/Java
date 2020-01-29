<%@ page import="java.util.*" %>
<html>
<head>
<!-- Ashley's Example of Using Declarations -->
<title> Ashley JSP Declaration Example</title>
</head>
<BODY>
<%!
    Date theDate = new Date();
    Date getDate()
    {
        System.out.println( "In getDate() method" );
        return theDate;
    }
%>
Hello!  The time is now <%= getDate() %>
</BODY>
</HTML>