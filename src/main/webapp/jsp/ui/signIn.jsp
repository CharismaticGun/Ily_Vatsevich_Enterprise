<%@ page contentType="text/html;charset=UTF-8"
         language="java"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <title>Страница входа</title>
    <meta content="text/html" charset="UTF-8">
</head>
<body>

<form action="${pageContext.request.contextPath}/api/login" method="POST">

    <label>

       Логин: <input name="login">
        <br>
       Пароль: <input name="password">
        <br>
        <input type="submit" value="войти">
    </label>

</form>

</body>
</html>
