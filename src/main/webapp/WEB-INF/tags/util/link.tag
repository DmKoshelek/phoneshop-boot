<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="pageNumber" required="false"%>
<%@ attribute name="sortValue" required="false" %>
<%--@elvariable id="searchForm" type="com.expertsoft.phoneshop.forms.SearchForm"--%>
<c:set var="pageUrlParams" value="${not empty pageNumber ? 'page='.concat(pageNumber) : ''}"/>
<c:set var="sortingUrlParams" value="${not empty sortValue ? 'sort='.concat(sortValue) : ''}"/>
<c:set var="sortingUrlParams" value="${not empty pageUrlParams ? '&'.concat(sortingUrlParams) : sortingUrlParams}"/>
<c:set var="searchQueryUrlParams" value="${not empty searchForm.searchQuery ? '&searchQuery='.concat(searchForm.searchQuery) : ''}"/>
<c:set var="fromPriceUrlParams" value="${not empty searchForm.fromPrice ? '&fromPrice='.concat(searchForm.fromPrice) : ''}"/>
<c:set var="toPriceUrlParams" value="${not empty searchForm.toPrice ? '&toPrice='.concat(searchForm.toPrice) : ''}"/>
<c:url value="${pageContext.request.pathInfo}?${pageUrlParams}${sortingUrlParams}${searchQueryUrlParams}${fromPriceUrlParams}${toPriceUrlParams}"/>