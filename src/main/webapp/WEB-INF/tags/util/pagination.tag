<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags/util" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ attribute name="page" required="true" type="org.springframework.data.domain.Page" %>
<%@ attribute name="paginationList" required="true" type="java.util.List<java.lang.Integer>" %>

<c:if test="${paginationList.size() > 0}">
    <ul class="pagination justify-content-center">
        <li class="page-item ${page.first ? 'disabled' : ''}">
            <a class="page-link" href="<util:link pageNumber="${page.previousOrFirstPageable().pageNumber}" sortValue="${fn:escapeXml(param.sort)}"/>">Previous</a>
        </li>
        <c:forEach var="currentPage" items="${paginationList}">
            <li class="page-item ${currentPage eq page.number ? 'active' : ''}">
                <a class="page-link" href="<util:link pageNumber="${currentPage}" sortValue="${fn:escapeXml(param.sort)}"/>">${currentPage + 1}</a>
            </li>
        </c:forEach>
        <li class="page-item ${page.last ? 'disabled' : ''}">
            <a class="page-link" href="<util:link pageNumber="${page.nextOrLastPageable().pageNumber}" sortValue="${fn:escapeXml(param.sort)}"/>">Next</a>
        </li>
    </ul>
</c:if>