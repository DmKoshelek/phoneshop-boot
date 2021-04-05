<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags/util" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ attribute name="currentSortParameter" required="true" %>
<%@ attribute name="sortParameter" required="true" %>
<%@ attribute name="text" required="true" %>

<c:if test="${currentSortParameter != sortParameter}">
    <a href="<util:link sortValue="${sortParameter}"/>">
</c:if>
<c:out value="${text}" escapeXml="false"/>
<c:if test="${currentSortParameter != sortParameter}">
    </a>
</c:if>
