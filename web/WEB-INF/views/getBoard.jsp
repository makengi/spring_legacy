<%--
  Created by IntelliJ IDEA.
  User: cjy71
  Date: 2021-08-16
  Time: ���� 1:35
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>
        ���� ���
    </title>
    <style>
        div .container{
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>�� ��</h1>
        <a href="logout.do">Log-out</a>
        <hr>
        <form action="newUpdateBoard.do" method="post">
            <input name="seq" type="hidden" value="${board.seq}"/>
            <table border="1" cellspacing="0" cellpadding="0">
                <tr>
                    <td bgcolor="orange" width="70">����</td>
                    <td align="left"><input name="title" type="text" value="${board.title}"></td>
                </tr>
                <tr>
                    <td bgcolor="orange">�ۼ���</td>
                    <td align="left">${board.writer}</td>
                </tr>
                <tr>
                    <td bgcolor="orange">����</td>
                    <td align="left"><textarea name="content" cols="40" rows="10">
                       ${board.content}</textarea></td>
                </tr>
                <tr>
                    <td bgcolor="orange">�����</td>
                    <td align="left">${board.regDate}</td>
                </tr>

                <tr>
                    <td bgcolor="orange">��ȸ��</td>
                    <td align="left">${board.cnt}</td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="�� ����"/>
                    </td>
                </tr>

            </table>
        </form>
    </div>
<hr>
<a href="boardForm.jsp">�� ���</a>&nbsp;&nbsp;&nbsp;
<a href="deleteBoard_proc.do?seq=${board.seq}">�� ����</a>&nbsp;&nbsp;&nbsp;
<a href="newGetBoardList.do">�� ���</a>
</body>
</html>
