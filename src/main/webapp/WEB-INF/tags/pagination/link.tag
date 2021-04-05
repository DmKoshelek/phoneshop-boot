<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="page" required="true"%>
<c:url value="${pageContext.request.pathInfo}?page=${page}"/>