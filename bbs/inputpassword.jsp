<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="bbs.Contribution" %>
<html lang="ja">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="Content-Style-Type" content="text/CSS">
	<meta http-equiv="Content-Script-Type" content="text/JavaScript">
	<link href="<%= request.getContextPath() %>/BBS/bbs.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="<%= request.getContextPath() %>/BBS/formcheck.js"></script>
	<title>パスワード入力画面</title>
</head>
<body>
	<h2>Web掲示板</h2>
	<hr>
	<h3>[${ param.indexNumber }]&nbsp;${ targetData.title }</h3>
	<p class="content">${ targetData.message }</p>
	<div class="right">
		<p>${ targetData.name }&nbsp;&nbsp${ targetData.posttime }</p>
	</div>
	<hr>
	<div class="confirm">
		<p>投稿した際に登録したパスワードを入力し、送信を押してください。</p>
		<form name="checkPass" method="post" action="<%= request.getContextPath() %>/BBS/CheckPasswordServlet" onsubmit="return passwordCheck();">パスワード（必須）
			<input type="password" name="inputPassword" maxlength="8">
			<c:if test="${ !empty errorMessage }">
				<p class="error">${ errorMessage }	</p>
			</c:if>
			<p>
				<input type="hidden" name="actionSwitch" value="<%= request.getParameter("actionSwitch") %>">
				<input type="hidden" name="idCode" value="${ targetData.id }">
				<input type="hidden" name="indexNumber" value="${ param.indexNumber }">
				<input type="submit" value="送信">
				<input type="button" value="戻る" onClick="window.location.href='<%= request.getContextPath() %>/BBS/main.jsp'">
			</p>
		</form>
	</div>
</body>
</html>