<%@ page contentType="text/html;charset=UTF-8"
         language="java"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Просмотр сообщений</title>
</head>
<body>

<p>Ваши сообщения:</p>
<br>
<c:forEach items="${requestScope.messages}" var="item">
    <br>
    <c:out value="${item}"/>
</c:forEach>

</body>
</html>
