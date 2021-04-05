<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="pagination" tagdir="/WEB-INF/tags/pagination" %>
<%@ attribute name="page" required="true" type="org.springframework.data.domain.Page" %>
<%@ attribute name="paginationList" required="true" type="java.util.List<java.lang.Integer>" %>

<c:if test="${paginationList.size() > 0}">
    <ul class="pagination justify-content-center">
        <li class="page-item ${page.first ? 'disabled' : ''}">
            <a class="page-link" href="<pagination:link page="${page.previousOrFirstPageable().pageNumber}"/>">Previous</a>
        </li>
        <c:forEach var="currentPage" items="${paginationList}">
            <li class="page-item ${currentPage eq page.number ? 'active disabled' : ''}">
                <a class="page-link" href="<pagination:link page="${currentPage}"/>">${currentPage + 1}</a>
            </li>
        </c:forEach>
        <li class="page-item ${page.last ? 'disabled' : ''}">
            <a class="page-link" href="<pagination:link page="${page.nextOrLastPageable().pageNumber}"/>">Next</a>
        </li>
    </ul>
</c:if>