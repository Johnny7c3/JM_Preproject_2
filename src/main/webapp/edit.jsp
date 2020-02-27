<%@ page import="AccessDB.ServiceClient" %>
<%@ page import="model.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Редактирование</title>
</head>
<body>
<form class="your-form-selector" method="post" action="/update">
    <table width="100%" cellspacing="0" cellpadding="4">
        <tr>
            <td></td>
            <td>Редактирование пользователя:</td>
        </tr>
        <tr>
            <td align="right" width="100">ID:</td>
            <td>
                <c:forEach var="list" items="${users}">
                    <input type="text" name="id" maxlength="50" size="20" value="<c:out value="${list.getId()}"/>">
                </c:forEach>     
            </td>
        </tr>
        <tr>
            <td align="right" width="100">Имя:</td>
            <td>
                <c:forEach var="list" items="${users}">
                    <input type="text" name="name" maxlength="50" size="20" value="<c:out value="${list.getName()}"/>">
                </c:forEach>     
            </td>
        </tr>
        <tr>
            <td align="right" width="100">Фамилия:</td>
            <td>
                <c:forEach var="list" items="${users}">
                    <input type="text" name="surname" maxlength="50" size="20" value="<c:out value="${list.getSurname()}"/>">
                </c:forEach>     
            </td>
        </tr>
        <tr>
            <td align="right" width="100">Пароль:</td>
            <td>
                <c:forEach var="list" items="${users}">
                    <input type="password" name="password" maxlength="50" size="20" value="<c:out value="${list.getPassword()}"/>">
                </c:forEach>     
            </td>
        </tr>
        <tr>
            <td align="right" width="100">Дата рождения:</td>
            <td>
                <c:forEach var="list" items="${users}">
                    <input type="date" name="birthday" maxlength="50" size="20" value="<c:out value="${list.getBirthday()}"/>">
                </c:forEach>     
            </td>
        </tr>
        <tr>
            <td></td>
            <td ><input type="submit" value="Подтвердить изменения"></td>
        </tr>
        </tr>
    </table>
</form>
</body>
</html>
