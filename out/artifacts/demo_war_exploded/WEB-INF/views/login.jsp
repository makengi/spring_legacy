<%--
  Created by IntelliJ IDEA.
  User: cjy71
  Date: 2021-08-15
  Time: 오후 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>로그인</title>
</head>
<body>
    <div>
        <h1>로그인</h1>
        <hr>
        <form action="login.do" method="post">
            <table border="1" cellpadding="0" cellspacing="0">
                <tr>
                    <td bgcolor="orange">아이디</td>
                    <td><input type="text" name="id"/></td>
                </tr>
                <tr>
                    <td bgcolor="orange">비밀번호</td>
                    <td><input type="password" name="password"/></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="로그인"/>
                    </td>
                </tr>

            </table>
        </form>
    </div>
</body>
</html>
