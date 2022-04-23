<%@ page import="org.example.JD2_Maven.home_work_1.dto.Roles" %>
<%@ page contentType="text/html;charset=UTF-8"
         language="java"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html lang="ru">
<head>
    <title>Главная страница</title>
    <meta content="text/html; charset=UTF-8">
</head>
<body>
<c:choose>
    <c:when test="${sessionScope.user!=null}">
        <form action="${pageContext.request.contextPath}/ui/user/message" method="GET">
            <p>
                Отправка сообщений: <input type="submit" value="Отправить">
            </p>
        </form>
        <form action="${pageContext.request.contextPath}/ui/user/chats" method="GET">
            <p>
                Просмотр сообщений: <input type="submit" value="Просмотреть">
            </p>
        </form>
        <form action="${pageContext.request.contextPath}/api/logout" method="POST" >
            <p>
                Выход: <input type="submit" value="выйти">
            </p>
        </form>
        <c:if test="${sessionScope.user.role.equals(Roles.ADMIN.name())}">
            <form action="${pageContext.request.contextPath}/ui/admin/statistic" method="GET">
                <p>
                    Просмотр статистики: <input type="submit" value="статистика">
                </p>
            </form>
        </c:if>
    </c:when>
    <c:otherwise>
        <form action="${pageContext.request.contextPath}/ui/signUp" method="GET">
            <p>
                Регистрация: <input type="submit" value="зарегистрироваться">
            </p>
        </form>
        <form action="${pageContext.request.contextPath}/ui/signIn" method="GET">
            <p>
                Вход: <input type="submit" value="вход">
            </p>
        </form>
    </c:otherwise>
</c:choose>
</body>
</html>
