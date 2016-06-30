<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="bbs.entity.Contribution" %>
<%@page import="java.util.ArrayList" %>
<html lang="ja">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="Content-Style-Type" content="text/CSS">
	<meta http-equiv="Content-Script-Type" content="text/JavaScript">
	<link href="<%= request.getContextPath() %>/bbs/bbs.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="<%= request.getContextPath() %>/bbs/formcheck.js"></script>
	<title>投稿画面</title>
</head>
<body>
	<h2>Web掲示板</h2>
	<form name="input" action="<%= request.getContextPath() %>/bbs/BbsServlet" method="post" onsubmit="return formCheck();">
		<table class="register">
			<tr>
				<td class="index">名前</td>
				<td><input type="text" name="name" maxlength="20" size="40" value="${ targetData.name }"></td>
			</tr>
			<tr>
				<td class="index">メール</td>
				<td><input type="text" name="mail" maxlength="30" size="35" value="${ targetData.mail }"></td>
			</tr>
			<tr>
				<td class="index">タイトル（必須）</td>
				<td><input type="text" name="title" maxlength="20" size="40" value="${ targetData.title }"></td>
			</tr>
			<tr>
				<td class="index">本文（必須）</td>
				<td><textarea name="message" cols="50" rows="5">${ targetData.message }</textarea></td>
			</tr>
			<tr>
				<td class="index">パスワード（必須）</td>
				<td><input type="password" name="password" maxlength="8" size="12" value=""></td>
			</tr>
		</table>
		<c:forEach var="errorMessage" items="${ errorList }">
			<p class="registerError">${ errorMessage }</p>
		</c:forEach>
		<p>
			<c:if test="${ !empty param.idCode }">
				<input type="hidden" name="idCode" value="${ param.idCode }">
			</c:if>
			<input type="hidden" name="actionSwitch" value="${ param.selectFunction }">
			<button type="submit" name="formflag" value="sendForm">送信</button>
			<input type="button" value="リセット" onClick="clearInputForm();">
			<input type="button" value="投稿中止" onClick="window.location.href='<%= request.getContextPath() %>/bbs/main.jsp'">
		</p>
	</form>
</body>
</html>