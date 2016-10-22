<%@page language="java" pageEncoding="UTF-8" contentType="text/html; UTF-8"%>
<html>
<body>
<h3>Login</h3>
<form action="servlet/LoginServlet" method="post">
<input type="text" name="u" placeholder="username"><br>
<input type="text" name="p" placeholder="password"><br>
<input type="submit">
</form>
<hr>
<h3>Register</h3>
<form action="servlet/RegisterServlet" method="post">
<input type="text" name="u" placeholder="username"><br>
<input type="text" name="p" placeholder="password"><br>
<input type="submit">
</form>
</body>
</html>
