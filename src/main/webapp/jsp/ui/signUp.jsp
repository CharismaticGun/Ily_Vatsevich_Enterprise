<%@ page contentType="text/html;charset=UTF-8"
         language="java"
         pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html lang="ru">
<head>
    <title>Страница регистрации</title>
  <meta content="text/html" charset="UTF-8">
</head>
<body>

<form action="${pageContext.request.contextPath}/api/user" method="POST">
  <label>

    Логин: <input name="login">
    <br>
    Пароль: <input name="password">
    <br>
    ФИО: <input name="fullName">
    <br>
    Дата рождения: <input name="dateOfBirth">

    <input type="submit" value="отправить">

  </label>
</form>

</body>
</html>
