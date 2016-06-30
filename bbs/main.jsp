<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="bbs.controller.BbsServlet" %>
<%@page import="bbs.entity.Contribution" %>
<%@page import="java.util.ArrayList" %>
<html lang="ja">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="Content-Style-Type" content="text/CSS">
	<meta http-equiv="Content-Script-Type" content="text/JavaScript">
	<link href="<%= request.getContextPath() %>/bbs/bbs.css" rel="stylesheet" type="text/css">
	<title>Web掲示板</title>
</head>
<body>
	<h2>Web掲示板</h2>
	<form method="post" action="<%= request.getContextPath() %>/bbs/BbsServlet">
		<input type="hidden" name="actionSwitch" value="main">
		<button type="submit" name="selectFunction" value="register">新規投稿</button>
	</form>
	<c:if test="${ !empty message }">
		<p class="announce">${ message }</p>
		<c:remove var="message" scope="session" />
	</c:if>
	<c:forEach var="postData" items="${ list }" varStatus="status">
		<hr>
		<h3>[${ status.count }]&nbsp;${ postData.title }</h3>
		<p class="content">${ postData.message }</p>
		<div class="right">
			<form method="post" action="<%= request.getContextPath() %>/bbs/BbsServlet">
				<c:if test="${ !empty postData.mail }">
					<a href="mailto:${ postData.mail }"> ${ postData.name }</a>
				</c:if>
				<c:if test="${ empty postData.mail }">
					${ postData.name }
				</c:if>&nbsp;&nbsp;${ postData.posttime }
				<input type="hidden" name="indexNumber" value="${ status.count }">
				<input type="hidden" name="idCode" value="${ postData.id }">
				<input type="hidden" name="actionSwitch" value="main">
				<button type="submit" name="selectFunction" value="check">変更</button>
			</form>
		</div>
	</c:forEach>
	<hr>
</body>
</html>