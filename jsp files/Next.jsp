<HTML>
<head>
<!-- Ashley's Pets -->
<title> Ashley JSP Pets</title>
</head>
<BODY>
<h2> Ashley's Pets </h2>
Name: <%= session.getAttribute( "theName" ) %>
<p> Gender: <%= session.getAttribute( "theGender" ) %>
<p>Age: <%= session.getAttribute( "theAge" ) %>
<p>Species: <%= session.getAttribute( "theSpecies" ) %>
<p>Breed: <%= session.getAttribute( "theBreed" ) %>
</BODY>
</HTML>