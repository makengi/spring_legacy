<%@ page contentType="text/html; charset=EUC-KR"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
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
        <h1>글 등록</h1>
        <a href="logout.do">로그아웃</a>
        <hr>
        <form action="newInsertBoard.do" method="post">
            <table border="1" cellpadding="0" cellspacing="0">
                <tr>
                    <td bgcolor="orange" width="70">제목</td><td align="left">
                    <input type="text" name="title" size="10"/>
                </td>
                </tr>
                <tr>
                    <td bgcolor="orange">내용</td><td align="left">
                    <textarea name="content" cols="40" rows="10"></textarea>
                </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="새글 등록"/>
                    </td>
                </tr>
            </table>
        </form>
        <hr>
        <a href="newGetBoardList.do">글 목록 가기</a>
    </div>
</body>
</html>