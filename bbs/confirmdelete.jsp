<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="bbs.Contribution" %>

<html lang="ja">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="Content-Style-Type" content="text/CSS">
	<meta http-equiv="Content-Script-Type" content="text/JavaScript">
	<link href="<%= request.getContextPath() %>/BBS/bbs.css" rel="stylesheet" type="text/css">
	<title>削除確認画面</title>
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
		<p>以上の投稿を消去してもよろしいですか。</p>
		<p>削除した場合復元できません。</p>
		<form action="<%= request.getContextPath() %>/BBS/RemovePostServlet" method="post">
			<input type="hidden" name="idCode" value="${ targetData.id }">
			<input type="submit" value="はい">
			<input type="button" value="いいえ" onClick="window.location.href='<%= request.getContextPath() %>/BBS/main.jsp'">
		</form>
	</div>
</body>
</html>