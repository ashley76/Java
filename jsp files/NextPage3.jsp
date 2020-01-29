<jsp:useBean id="user" class="user.UserData" scope="session"/> 
<HTML>
<BODY>
You entered<BR>
Name: <%= user.getUsername() %><BR>
Email: <%= user.getEmail() %><BR>
Age: <%= user.getAge() %><BR>

<br>
<A HREF="GetName3.html">Return to GetName3.</A>
</BODY>
</HTML>