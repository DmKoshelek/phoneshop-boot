<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div class="row">
    <sec:authorize access="!isAuthenticated()">
        <div class="col-4 offset-9">
            <a href="<c:url value="/login"/>">
                <button type="button" class="btn btn-primary">Login</button>
            </a>
        </div>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <div class="col-4 offset-9">
            Hello, <b><sec:authentication property="name" /></b>
            <a href="<c:url value="/logout"/>">
                <button type="button" class="btn btn-primary">Logout</button>
            </a>
        </div>
    </sec:authorize>
    <sec:authorize access="hasRole('ADMIN')">
        <div class="col-4 offset-9">
            <a href="<c:url value="/admin"/>">
                <p>Admin panel</p>
            </a>
        </div>
    </sec:authorize>
</div>