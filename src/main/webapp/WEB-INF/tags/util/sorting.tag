<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags/util" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ attribute name="parameter" required="true" %>
<c:set var="upperArrow" value="&#x25B2;"/>
<c:set var="downArrow" value="&#x25BC;"/>
<c:set var="ascParameter" value="${fn:escapeXml(parameter.concat(\",asc\"))}"/>
<c:set var="descParameter" value="${fn:escapeXml(parameter.concat(\",desc\"))}"/>
<c:set var="currentSortParameter" value="${fn:escapeXml(param.sort)}"/>

<util:sortingArrow currentSortParameter="${currentSortParameter}" sortParameter="${ascParameter}" text="${upperArrow}"/>
<util:sortingArrow currentSortParameter="${currentSortParameter}" sortParameter="${descParameter}" text="${downArrow}"/>