<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags/util" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<common:page pageTitle="Admin panel" showMenu="false">
    <div class="row mb-3 offset-1">
        <common:back/>
    </div>
    <div class="row justify-content-center">
        <h2>Admin panel page</h2>
    </div>
    <div class="row justify-content-center font-italic mb-3">
        Found <c:out value="${page.totalElements}"/> users!
    </div>
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Login</th>
            <th scope="col">Name</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${page.content}">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.login}"/></td>
                <td><c:out value="${user.name}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <util:pagination page="${page}" paginationList="${paginationList}" />
</common:page>
