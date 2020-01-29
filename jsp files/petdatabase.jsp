<%@page import="java.sql.*" %>
<html>
<head>
<!--Example of JSP with Database processing   -->
<title>JSP Example with MySQL Database</title>
</head>
<body>
My Pets:  
<br>
<%!private static void loadDriver() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded");
		} 
		catch (Exception ex) {
			System.out.println("Driver error");
		} 
	}
	
	
	
	
	private static Connection makeConnection() {
		Connection conn = null;  
		try{
			// Create a connection to the database
			
			Statement s;
			
			String userName = "root";
			String password = "";
			String url = "jdbc:mysql://localhost/MYPETS";
			conn = DriverManager.getConnection (url, userName, password);
			System.out.println ("Database connection established");
			return conn;
		}
		catch (Exception ex) {
			System.out.println("Connection error");
			return conn;
		} 
	}
	
	
	
	
	
	private static boolean insertRow() {
		// Create the insert statement. This example uses hardcoded values.
		Statement s;
		int count;
		try {
			s = conn.createStatement ();
			String stmt = "INSERT INTO student (name, age, gender, graduation)"
				+ " VALUES" + "('Jackie', 22, 'F', 2020)";
			System.out.println(stmt);
			count = s.executeUpdate (stmt);
			System.out.println ("Row added "+ stmt);
		} 
		catch (SQLException e) {
			System.out.println("SQL error during DROP/CREATE");
			return false;
		}
		return true;
	}
				
	
	
	
	
	private static ResultSet selectAll(Connection conn, String sql) {
		ResultSet rs = null;
		Statement s;
		try {
			s = conn.createStatement();

			// Get a ResultSet by executing a query (your insert/delete/etc. statement) on that statement 
			s.execute(sql); // select the data from the table
			rs = s.getResultSet();
			return rs;
		}
		catch (Exception ex) {
			System.out.println("SQL error");
			return rs;
		} 
		
	}
%>
<%	
	Connection conn = null;	
	loadDriver();
	conn = makeConnection();
		
	try {
		
		ResultSet rs = selectAll(conn, "select * from pet");
		
		out.print("<table BORDER=2> ");
		out.print("<tr> <th>Id</th><th>Name</th><th>Gender</th><th>Age</th><th>Species</th><th>Breed</th></tr>");
		while(rs.next()){
			int id = Integer.parseInt(rs.getString("id"));
			String name = rs.getString("name");
			char gender = rs.getString("gender").charAt(0);
			int age = Integer.parseInt(rs.getString("age"));
			String species = rs.getString("species");		
			String breed = rs.getString("breed");
			out.print("<tr>"); 
			out.print("<td>" + id + "</td>");
			out.print("<td>" + name + "</td>");
			out.print("<td>" + gender + "</td>");
			out.print("<td>" + age + "</td>");
			out.print("<td>" + species + "</td>");
			out.print("<td>" + breed + "</td>");
			out.print("</tr>");
		}
		out.print("</table>");
	}		
	catch (Exception ex) {
		out.print("database error");
		System.out.println("database error");
	}  
%>
</BODY>
</HTML>