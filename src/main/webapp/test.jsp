<%@ page import="AccessDB.ServiceClient" %>
<%@ page import="model.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Работа с пользователями</title>
    <style>
        .your-form-selector {
            display: inline-block;
        }
    </style>
</head>
<body>

<form class="your-form-selector"method="post" action="/add">
    <table width="100%" cellspacing="0" cellpadding="4">
        <tr>
            <td></td>
            <td>Добавление пользователя:</td>
        </tr>
        <tr>
            <td align="right" width="100">Имя:</td>
            <td><input type="text" name="name" maxlength="50" size="20" required placeholder></td>
        </tr>
        <tr>
            <td align="right" width="100">Фамилия:</td>
            <td><input type="text" name="surname" maxlength="50" size="20" required placeholder></td>
        </tr>
        <tr>
            <td align="right" width="100">Пароль:</td>
            <td><input type="password" name="password" maxlength="50" size="20" required placeholder></td>
        </tr>
        <tr>
            <td align="right" width="100">Дата рождения:</td>
            <td><input type="date" name="birthday" required placeholder></td>
        </tr>
        <tr>
            <td></td>
            <td ><input type="submit" value="Добавить пользователя"></td>
        </tr>
        </tr>
    </table>
</form>
<form class="your-form-selector" method="post" action="/update">
    <table width="100%" cellspacing="0" cellpadding="4">
        <tr>
            <td></td>
            <td>Редактирование пользователя:</td>
        </tr>
        <tr>
            <td align="right" width="100">ID:</td>
            <td><input type="text" name="id" maxlength="50" size="20" required placeholder></td>
        </tr>
        <tr>
            <td align="right" width="100">Имя:</td>
            <td><input type="text" name="name" maxlength="50" size="20"></td>
        </tr>
        <tr>
            <td align="right" width="100">Фамилия:</td>
            <td><input type="text" name="surname" maxlength="50" size="20"></td>
        </tr>
        <tr>
            <td align="right" width="100">Пароль:</td>
            <td><input type="password" name="password" maxlength="50" size="20"></td>
        </tr>
        <tr>
            <td align="right" width="100">Дата рождения:</td>
            <td><input type="date" name="birthday"></td>
        </tr>
        <tr>
            <td></td>
            <td ><input type="submit" value="Подтвердить изменения"></td>
        </tr>
        </tr>
    </table>
</form>
<form class="your-form-selector" method="post" action="/delete">
    <table width="100%" cellspacing="0" cellpadding="4">
        <tr>
            <td></td>
            <td>Удаление пользователя:</td>
        </tr>
        <tr>
            <td align="right" width="100">ID:</td>
            <td><input type="number" name="id" maxlength="50" size="20" required placeholder></td>
        </tr>
        <tr>
            <td></td>
            <td ><input type="submit" value="Подтвердить"></td>
        </tr>
        </tr>
    </table>
</form>
</br>

<p><b>Список зарегистрированных пользователей:</b></p>
<c:forEach var="list" items="${users}">
    <p><c:out value="${list}"/></p>
</c:forEach>
</body>
</html>



















