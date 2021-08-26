<%--
  Created by IntelliJ IDEA.
  User: cjy71
  Date: 2021-08-16
  Time: 오전 1:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <style>
        .container{
            position: absolute;
            left: 50%;
            transform: translateX(-50%);
        }

    </style>
</head>
<body>
    <div class="container">
        <h1>글목록</h1>
        <h3>${userName}님! 게시판에 오신걸 환영합니다. <a href="logout.do">Log-out</a></h3>

<%--        search start--%>
        <form action="newGetBoardList.do" method="post">
            <table class="data-table" border="1" cellspacing="0" cellpadding="0" width="700">

                <tr>
                    <td align="right">
                        <select name="searchCondition">
                            <option value="TITLE">제목
                            <option value="CONTENT">내용
                        </select>
                        <input name="searchKeywork" type="text"/>
                        <input type="submit" value="검색"/>
                    </td>
                </tr>
            </table>
        </form>
        <table border="1" cellpadding="0" cellspacing="0" width="700">
                <tr>
                    <th bgcolor="orange" width="100">번호</th>
                    <th bgcolor="orange" width="200">제목</th>
                    <th bgcolor="orange" width="150">작성자</th>
                    <th bgcolor="orange" width="150">등록일</th>
                    <th bgcolor="orange" width="100">조회수</th>
                </tr>
                <c:forEach items="${boardList}" var="board">
                    <tr>
                        <td>${board.seq}</td>
                        <td align="left"><a href="newGetBoard.do?seq=${board.seq}">${board.title}</a> </td>
                        <td>${board.writer}</td>
                        <td>${board.regDate}</td>
                        <td>${board.cnt}</td>
                    </tr>
                </c:forEach>
            </table>
            <br>
            <a href="boardForm.do">새글 등록</a>
    </div>
</body>
</html>
