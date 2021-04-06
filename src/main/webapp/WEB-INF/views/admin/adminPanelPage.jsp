<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags/util" %>
<%@ taglib prefix="user" tagdir="/WEB-INF/tags/user" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<common:page pageTitle="Admin panel" showMenu="false">
    <div class="row mb-3">
        <common:back/>
    </div>
    <div class="row justify-content-center">
        <h2>Admin panel page</h2>
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
            <user:tile user="${user}"/>
        </c:forEach>
        </tbody>
    </table>
    <util:pagination page="${page}" paginationList="${paginationList}" />
</common:page>
