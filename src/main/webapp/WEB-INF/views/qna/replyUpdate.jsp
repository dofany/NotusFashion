<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>NotusFashion</title>
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
<style>
body {
	margin: 0;
	padding: 0;
	font-family: '맑은 고딕', verdana;
}

a {
	color: #05f;
	text-decoration: none;
}

a:hover {
	text-decoration: underline;
}

h1, h2, h3, h4, h5, h6 {
	margin: 0;
	padding: 0;
}

ul, lo, li {
	margin: 0;
	padding: 0;
	list-style: none;
}

/* ---------- */
div#root {
	width: 900px;
	margin: 0 auto;
}

header#header {
	
}

nav#nav {
	
}

section#container {
	
}

section#content {
	float: right;
	width: 700px;
}

aside#aside {
	float: left;
	width: 180px;
}

section#container::after {
	content: "";
	display: block;
	clear: both;
}

footer#footer {
	background: #eee;
	padding: 20px;
}

/* ---------- */
header#header div#header_box {
	text-align: center;
	padding: 30px 0;
}

header#header div#header_box h1 {
	font-size: 50px;
}

header#header div#header_box h1 a {
	color: #000;
}

nav#nav div#nav_box {
	font-size: 14px;
	padding: 10px;
	text-align: right;
}

nav#nav div#nav_box li {
	display: inline-block;
	margin: 0 10px;
}

nav#nav div#nav_box li a {
	color: #333;
}

section#container {
	
}

aside#aside .menu1 {
	font-size: 22px;
	margin-bottom: 20px;
	text-align: center;
}

aside#aside .menu2 {
	font-size: 22px;
	margin-bottom: 20px;
	text-align: center;
}

aside#aside li {
	font-size: 16px;
	text-align: center;
}

aside#aside li a {
	color: #000;
	display: block;
	padding: 10px 0;
}

aside#aside li a:hover {
	text-decoration: none;
	background: #eee;
}

aside#aside li {
	position: relative;
}

aside#aside li:hover {
	background: #eee;
}

aside#aside li>ul.low {
	display: none;
	position: absolute;
	top: 0;
	left: 180px;
}

aside#aside li:hover>ul.low {
	display: block;
}

aside#aside li:hover>ul.low li a {
	background: #eee;
	border: 1px solid #eee;
}

aside#aside li:hover>ul.low li a:hover {
	background: #fff;
}

aside#aside li>ul.low li {
	width: 180px;
}

aside#aside li>ul.low {
	display: none;
	position: absolute;
	top: 0;
	left: 180px;
}

footer#footer {
	margin-top: 100px;
	border-radius: 50px 50px 0 0;
}

footer#footer div#footer_box {
	padding: 0 20px;
}
</style>
</head>
<body>
	<div id="root">
		<header id="header">
			<div id="header_box">
				<%@ include file="../include/header.jsp"%>
			</div>
		</header>
		<nav id="nav">
			<div id="nav_box">
				<%@ include file="../include/nav.jsp"%>
			</div>
		</nav>
		<section id="container">
			<div id="container_box">

				<section id="content">
					<form role="form" method="post" autocomplete="off">

						<input type="hidden" id="bno" name="bno" value="${readReply.bno}"
							readonly="readonly" /> <input type="hidden" id="rno" name="rno"
							value="${readReply.rno}" readonly="readonly" /> <input
							type="hidden" id="page" name="page" value="${scri.page}"
							readonly="readonly" /> <input type="hidden" id="perPageNum"
							name="perPageNum" value="${scri.perPageNum}" readonly="readonly" />
						<input type="hidden" id="searchType" name="searchType"
							value="${scri.searchType}" readonly="readonly" /> <input
							type="hidden" id="keyword" name="keyword" value="${scri.keyword}"
							readonly="readonly" />

						<p>
							<label for="content">글 내용</label>
							<textarea id="content" name="content">${readReply.content}</textarea>
						</p>

						<p>
							<button type="submit">수정</button>
							<button type="button" id="cancel_btn">취소</button>

							<script>
								// 폼을 변수에 저장
								var formObj = $("form[role='form']");

								// 취소 버튼 클릭
								$("#cancel_btn")
										.click(
												function() {
													self.location = "/qna/read?bno=${readReply.bno}"
															+ "&page=${scri.page}"
															+ "&perPageNum=${scri.perPageNum}"
															+ "&searchType=${scri.searchType}"
															+ "&keyword=${scri.keyword}";
												});
							</script>
						</p>
					</form>
				</section>

				<aside id="aside">
					<%@ include file="../include/aside.jsp"%>
				</aside>

			</div>
		</section>
		<footer id="footer">
			<div id="footer_box">
				<%@ include file="../include/footer.jsp"%>
			</div>
		</footer>

	</div>
</body>
</html>