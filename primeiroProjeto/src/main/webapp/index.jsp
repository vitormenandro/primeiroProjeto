<html>
<body>
	<h2>Hello World! Aqui!</h2>
	Today is: <%=new java.util.Date().toString()%>
	<br /> Teste is: <%=new com.menandro.QuickstartSample().escrever()%>
	<br />
	<br />
	<form name="loginForm" method="post" action="loginServlet">
		Username: <input type="text" name="username" /> <br /> 
		Password: <input type="password" name="password" /> <br /> 
		<input type="submit" value="Login" />
	</form>
</body>
</html>
