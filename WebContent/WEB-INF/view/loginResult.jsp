<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*"%>
<%
User user = (User) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶDBログイン</title>
</head>
<body>
<h1>どこつぶDBログイン</h1>
<% if(user!=null) { %>
<p>ログインに成功しました！</p>
<p>ようこそ<%=user.getUserName() %>さん</p>
<a href="/docoTsubuDB/Main">つぶやき投稿・閲覧へ</a>
<%}else{ %>
<p>ログインに失敗しました</p>
<a href="/docoTsubuDB/">トップへ</a>
<%} %>
</body>
</html>