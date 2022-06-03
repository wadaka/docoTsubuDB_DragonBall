<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.User,model.Mutter,java.util.List"%>
<%
	User loginUser = (User) session.getAttribute("loginUser");
	List<Mutter> mutterList = (List<Mutter>)request.getAttribute("list");
	String errorMsg = (String) request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶDB</title>
</head>
<body>
<h1>どこつぶDBメイン</h1>
<p>
<%=loginUser.getUserName() %>さん、ログイン中
<a href="/docoTsubuDB/Logout">ログアウト</a>
<p><a href="/docoTsubuDB/Main">更新</a></p>
<form action="/docoTsubuDB/Main" method="post">
<input type="text" name="text"><button type="submit">つぶやく</button>
</form>
<% if(errorMsg !=null) {%>
<p><%=errorMsg %></p>
<%} %>
<% if(mutterList !=null){ %>
<% for(Mutter mutter : mutterList) {%>
<p><%=mutter.getUserName() %>：<%=mutter.getText() %></p>
<%} %>
<%} %>
</body>
</html>