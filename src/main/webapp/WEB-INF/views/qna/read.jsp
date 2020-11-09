<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>NotusFashion</title>
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

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
						<input type="hidden" id="page" name="page" value="${scri.page}"
							readonly="readonly" /> <input type="hidden" id="perPageNum"
							name="perPageNum" value="${scri.perPageNum}" readonly="readonly" />
						<input type="hidden" id="searchType" name="searchType"
							value="${scri.searchType}" readonly="readonly" /> <input
							type="hidden" id="keyword" name="keyword" value="${scri.keyword}"
							readonly="readonly" />

						<div class="form-group">
							<label for="bno" class="col-sm-2 control-label">글 번호</label> <input
								type="text" id="bno" name="bno" class="form-control"
								value="${read.bno}" readonly="readonly" />

						</div>

					</form>

					<div class="form-group">
						<label for="title" class="col-sm-2 control-label">글 제목</label>
					
							<input type="text" id="title" name="title" class="form-control"
								value="${read.title}" readonly="readonly" />
						
					</div>
					<div class="form-group">
						<label for="content" class="col-sm-2 control-label">글 내용</label>
					
							<textarea id="content" name="content" class="form-control"
								readonly="readonly">${read.content}</textarea>
						
					</div>
					<div class="form-group">
						<label for="writer" class="col-sm-2 control-label">작성자</label>
					
							<input type="text" id="writer" name="writer" class="form-control"
								value="${read.writer}" readonly="readonly" />
						
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label">작성 날짜</label>
						
							<span><fmt:formatDate value="${read.regDate}"
									pattern="yyyy-MM-dd" /></span>
						
					</div>

					<div class="form-group">
						<button type="button" id="list_btn" class="btn btn-primary">목록</button>
						<button type="button" id="modity_btn" class="btn btn-warning">수정</button>
						<button type="button" id="delete_btn" class="btn btn-danger">삭제</button>

						<script>
							// 폼을 변수에 저장
							var formObj = $("form[role='form']");

							// 목록 버튼 클릭
							$("#list_btn")
									.click(
											function() {

												self.location = "/qna/listSearch?"
														+ "page=${scri.page}&perPageNum=${scri.perPageNum}"
														+ "&searchType=${scri.searchType}&keyword=${scri.keyword}";
											});

							// 수정 버튼 클릭
							$("#modity_btn").click(function() {

								formObj.attr("action", "/qna/modify");
								formObj.attr("method", "get");
								formObj.submit();

							});

							// 삭제 버튼 클릭
							$("#delete_btn").click(function() {

								formObj.attr("action", "/qna/delete");
								formObj.attr("method", "get");
								formObj.submit();

							});
						</script>
					</div>

					<div id="reply">
						<ol class="replyList">
							<c:forEach items="${repList}" var="repList">
								<li>
									<p>
										<span class="glyphicon glyphicon-user"></span>
										${repList.writer} (
										<fmt:formatDate value="${repList.regDate}"
											pattern="yyyy-MM-dd" />
										)
									</p>

									<p class="bg-info">${repList.content}</p>

									<div class="form-group">
										<button type="button"
											class="replyUpdate btn btn-warning btn-xs"
											data-rno="${repList.rno}">수정</button>
										<button type="button"
											class="replyDelete btn btn-danger btn-xs"
											data-rno="${repList.rno}">삭제</button>

										<script>
											$(".replyUpdate")
													.click(
															function() {
																self.location = "/qna/replyUpdate?bno=${read.bno}"
																		+ "&page=${scri.page}"
																		+ "&perPageNum=${scri.perPageNum}"
																		+ "&searchType=${scri.searchType}"
																		+ "&keyword=${scri.keyword}"
																		+ "&rno="
																		+ $(
																				this)
																				.attr(
																						"data-rno");
															});

											$(".replyDelete")
													.click(
															function() {
																self.location = "/qna/replyDelete?bno=${read.bno}"
																		+ "&page=${scri.page}"
																		+ "&perPageNum=${scri.perPageNum}"
																		+ "&searchType=${scri.searchType}"
																		+ "&keyword=${scri.keyword}"
																		+ "&rno="
																		+ $(
																				this)
																				.attr(
																						"data-rno");
															});
										</script>
									</div>
								</li>
							</c:forEach>
						</ol>

						<section class="replyForm">
							<form role="form" method="post" autocomplete="off"
								class="form-horizontal">

								<input type="hidden" id="bno" name="bno" value="${read.bno}"
									readonly="readonly" /> <input type="hidden" id="page"
									name="page" value="${scri.page}" readonly="readonly" /> <input
									type="hidden" id="perPageNum" name="perPageNum"
									value="${scri.perPageNum}" readonly="readonly" /> <input
									type="hidden" id="searchType" name="searchType"
									value="${scri.searchType}" readonly="readonly" /> <input
									type="hidden" id="keyword" name="keyword"
									value="${scri.keyword}" readonly="readonly" />

								<div class="form-group">
									<label for="writer" class="col-sm-2 control-label">작성자</label>
									<div class="col-sm-10">
										<input type="text" id="writer" name="writer"
											class="form-control" />
									</div>
								</div>

								<div class="form-group">
									<label for="content" class="col-sm-2 control-label">댓글
										내용</label>
									<div class="col-sm-10">
										<textarea id="content" name="content" class="form-control"></textarea>
									</div>
								</div>

								<div class="form-group">
									<div class="col-sm-offset-2 col-sm-10">
										<button type="button" class="repSubmit btn btn-success">작성</button>
									</div>
									<script>
										var formObj = $(".replyForm form[role='form']");

										$(".repSubmit").click(
												function() {
													formObj.attr("action",
															"replyWrite");
													formObj.submit();
												});
									</script>
								</div>
							</form>
						</section>

					</div>
			</div>

			<aside id="aside">
				<%@ include file="../include/aside.jsp"%>
			</aside>
		</section>
		<footer id="footer">
			<div id="footer_box">
				<%@ include file="../include/footer.jsp"%>
			</div>
		</footer>

	</div>
</body>
</html>