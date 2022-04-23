<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Статистика</title>
</head>
<body>

<p>Кол-во активных сессий: <c:out value="${requestScope.activeSessions}"/> </p>
<br>
<p>Кол-во отправленных сообщений: <c:out value="${requestScope.sentMessages}"/> </p>

</body>
</html>
