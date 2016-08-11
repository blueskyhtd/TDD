<%@page import="application.LoginDao"%>
<jsp:useBean id="obj" class="application.LoginBean" />
<jsp:setProperty property="*" name="obj" />

<h3>Login Form</h3>
<%
	String action = request.getParameter("submit");
	if ("login".equals(action)) {
		boolean status = LoginDao.validate(obj, request);
		if (status) {
			out.println("Login success !");
			session.setAttribute("session", "TRUE");
		} else {
			out.print("Login failed ! ");
		}
	}
%>

<br />
<form method="post">
	<div>
		Username: <input type="text" name="username" />
	</div>
	<br /> <br />
	<div>
		Password:<input type="password" name="password" />
	</div>
	<br /> <br />
	<div>
		<input type="submit" name="submit" value="login" />
	</div>
</form>


