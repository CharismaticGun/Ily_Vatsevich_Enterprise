<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Title</title>
    <meta content="text/html" charset="UTF-8">
</head>
<body>

<form action="${pageContext.request.contextPath}/api/message" method="POST">

    <label>

        Кому: <input name="login">
        <br>
        Текст сообщения: <input name="messageText">
        <br>
        <input type="submit" value="отправить">

    </label>

</form>

</body>
</html>
