<%@ page contentType="text/html;charset=UTF-8"
         language="java"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Search for race</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/flights" method="GET">

    <label>
        Дата и время вылета: <input type="date" name="dateOut">
        <input type="time" name="timeOut">
    </label>
    <br><br>
    <label>
        Аэропорт вылета:<select name="airportOut">
            <option></option>
            <c:forEach var="item" items="${requestScope.airports}">
                <option value="${item}">${item}</option>
            </c:forEach>
        </select>
    </label>
    <br><br>
    <label>
        Дата и время прилета: <input type="date" name="dateIn">
        <input type="time" name="timeIn">
    </label>
    <br><br>
    <label>
        Аэропорт прилета: <select name="airportIn">
            <option></option>
            <c:forEach var="item" items="${requestScope.airports}">
                <option value="${item}">${item}</option>
            </c:forEach>
        </select>
    </label>
    <br><br>
    <input type="submit" value="искать">

</form>
</body>
</html>
