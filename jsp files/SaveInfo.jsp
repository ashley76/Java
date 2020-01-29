<%
   String name = request.getParameter( "username" );
   session.setAttribute( "theName", name );
   
   String gender = request.getParameter( "gender" );
   session.setAttribute( "theGender", gender );
   
   String age = request.getParameter( "age" );
   session.setAttribute( "theAge", age );
   
   String species = request.getParameter( "species" );
   session.setAttribute( "theSpecies", species );
   
   String breed = request.getParameter( "breed" );
   session.setAttribute( "theBreed", breed );
%>
<HTML>
<head>
<!-- Ashley's Pets -->
<title> Ashley JSP Pets</title>
</head>
<BODY>
<A HREF="Next.jsp">Continue to see Pet Info</A>
</BODY>
</HTML>