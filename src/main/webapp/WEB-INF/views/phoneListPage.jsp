<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags/util" %>
<%@ taglib prefix="phone" tagdir="/WEB-INF/tags/phone" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8"%>

<common:page pageTitle="Phone list" showMenu="true">
        <form:form method="GET"
                   action="/phones/search" modelAttribute="searchForm">
            <div class="row md-6 justify-content-center">
                <div class="form-group row">
                    <form:label path="searchQuery">Search query:</form:label>
                    <form:input path="searchQuery" type="text" class="form-control-plaintext" placeholder="Enter search phase"/>
                </div>
                <div class="form-group row">
                    <form:label path="fromPrice">From Price:</form:label>
                    <form:input path="fromPrice" type="number" step="0.01" min="0" class="form-control-plaintext" placeholder="Enter from price"/>
                </div>
                <div class="form-group row">
                    <form:label path="toPrice">To Price:</form:label>
                    <form:input path="toPrice" type="number" step="0.01" min="0" class="form-control-plaintext" placeholder="Enter to price"/>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>
        </form:form>
    <div class="row justify-content-center font-italic mb-3">
        Found <c:out value="${page.totalElements}"/> results!
    </div>
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">Image</th>
            <th scope="col">Brand <util:sorting parameter="brand"/></th>
            <th scope="col">Model <util:sorting parameter="model"/></th>
            <th scope="col">Price <util:sorting parameter="price"/></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="phone" items="${page.content}">
            <phone:tile phone="${phone}"/>
        </c:forEach>
        </tbody>
    </table>
    <util:pagination page="${page}" paginationList="${paginationList}" />
</common:page>