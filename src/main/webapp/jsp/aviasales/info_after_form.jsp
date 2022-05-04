<%@ page contentType="text/html;charset=UTF-8"
         language="java"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Races</title>
    <style type="text/css">
        TABLE {
            width: 100%;
            border-collapse: collapse;
            font-size: 13px;
        }
        TD, TH {
            padding: 2px;
            border: 1px solid black;
        }
    </style>
</head>
<body>
<h1>Подходящие рейсы</h1>
<br>
<table>
        <thead>
        <tr>
            <th>flight id</th>
            <th>flight no</th>
            <th>scheduled departure</th>
            <th>scheduled departure_local</th>
            <th>scheduled arrival</th>
            <th>scheduled arrival local</th>
            <th>scheduled duration</th>
            <th>departure airport</th>
            <th>departure airport name</th>
            <th>departure city</th>
            <th>arrival airport</th>
            <th>arrival airport name</th>
            <th>arrival city</th>
            <th>status</th>
            <th>aircraft code</th>
        </tr>
        </thead>
    <tbody>
    <c:forEach items="${requestScope.flights}" var="flights">
        <tr>
        <c:forEach var="flight" items="${flights}">
            <td><c:out value="${flight}"/></td>
        </c:forEach>
    </tr>
    </c:forEach>
    </tbody>
</table>

<c:if test="${requestScope.currentPage!=1}">
    <td><a href="${pageContext.request.contextPath}/flights?page=${requestScope.currentPage - 1}">Previous</a></td>
</c:if>

<table>
    Страницы
    <tr>
        <c:forEach begin="1" end="${requestScope.currentPage}" var="i">
            <c:choose>
                <c:when test="${requestScope.currentPage eq i}">
                    <td>${i}</td>
                </c:when>
                <c:otherwise>
                    <td><a href="${pageContext.request.contextPath}/flights?page=${i}">${i}</a></td>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </tr>
</table>

<c:if test="${requestScope.flights.size()==25}">
    <td><a href="${pageContext.request.contextPath}/flights?page=${requestScope.currentPage + 1}">Next</a></td>
</c:if>

</body>
</html>

