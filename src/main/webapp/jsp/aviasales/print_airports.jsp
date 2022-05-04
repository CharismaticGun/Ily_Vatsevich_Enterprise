<%@ page contentType="text/html;charset=UTF-8"
         language="java"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Airports</title>
</head>
<body>
<c:forEach items="${requestScope.airports}" var="item">
    <c:out value="${item}"/>
    <br><br>
</c:forEach>
</body>
</html>
